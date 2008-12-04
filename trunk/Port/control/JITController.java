package control;
import java.awt.Point;
import java.util.Iterator;
import java.util.Vector;

import data.CargoArea;
import data.CargoAreaSpace;
import data.CargoAreaStack;
import data.ContainerSpace;
import data.ExternalCarrier;
import data.Port;
import data.Container;
import data.Crane;
import data.PortLocation;
import data.Quay;
import data.SCarrier;
import data.Transport;


public class JITController {

	private Vector<SCarrier> SCarriers;
	private Port Port;
	private Vector<Container> Containers;

	
	/**
	 * Constructor : will build the port here
	 *
	 */
	public JITController() {
		super();
		
		/*
		 * The port will be like this : (X,Y) are the coordinates in a 2D representation
		 * 
		 *	Port(0,0):
		 *		-Quay1(500,0)
		 *			-Crane1(490,0)
		 *			-Crane2(510,0)
		 *		-CargoArea1 (Non-hasardous)  (0,500)
		 *			-Stack1(10,500)
		 *			-Stack2(20,500)
		 *			-Stack3(30,500)
		 *		-CargoArea2 : Hasardous  (500,500)
		 *			-Stack1(510,500)
		 *		-StraddleCarrier 1 (250,250)
		 *		-StraddleCarrier 2 (260,250)
		 *		-StraddleCarrier 3 (270,250)
		 * 
		 * 
		 */
		this.SCarriers = new Vector<SCarrier>();
		this.Containers = new Vector<Container>();
		
		this.Port = new Port(0,"SmallPort",new Point(50,50)); // Our Entire Port
		
		//Location directly under the port
		Quay quay1 = new Quay(10,"Quay1",new Point(500,50));
		CargoArea cargoArea1 = new CargoArea(30,"CargoArea1",new Point(40,460));
		CargoArea cargoArea2Hasardous = new CargoArea(80,"CargoArea2Hasardous",new Point(500,460));
		this.Port.addChild(quay1);
		this.Port.addChild(cargoArea1);
		this.Port.addChild(cargoArea2Hasardous);
		
		//location under the quay
		Crane crane1 = new Crane(11,"Crane1",new Point(460,70));
		Crane crane2 = new Crane(12,"Crane2",new Point(540,70));
		quay1.addChild(crane1);
		quay1.addChild(crane2);
		
		
		//Location under the cargoarea non-hasardous (contain 3 stack of 3 containers)
		CargoAreaStack cargoAreaStack1 = new CargoAreaStack(31,"area1stack1",new Point(10,510));
		cargoArea1.addChild(cargoAreaStack1);
		CargoAreaSpace nhstack1space1 = new CargoAreaSpace(32,"",new Point(10,510),1);
		CargoAreaSpace nhstack1space2 = new CargoAreaSpace(33,"",new Point(10,510),2);
		CargoAreaSpace nhstack1space3 = new CargoAreaSpace(34,"",new Point(10,510),3);
		cargoAreaStack1.addChild(nhstack1space1);
		cargoAreaStack1.addChild(nhstack1space2);
		cargoAreaStack1.addChild(nhstack1space3);
		
		CargoAreaStack cargoAreaStack2 = new CargoAreaStack(35,"area1stack2",new Point(10,540));
		cargoArea1.addChild(cargoAreaStack2);
		CargoAreaSpace nhstack2space1 = new CargoAreaSpace(36,"",new Point(10,540),1);
		CargoAreaSpace nhstack2space2 = new CargoAreaSpace(37,"",new Point(10,540),2);
		CargoAreaSpace nhstack2space3 = new CargoAreaSpace(38,"",new Point(10,540),3);
		cargoAreaStack2.addChild(nhstack2space1);
		cargoAreaStack2.addChild(nhstack2space2);
		cargoAreaStack2.addChild(nhstack2space3);
		
		CargoAreaStack cargoAreaStack3 = new CargoAreaStack(40,"area1stack3",new Point(10,570));
		cargoArea1.addChild(cargoAreaStack3);
		CargoAreaSpace nhstack3space1 = new CargoAreaSpace(41,"",new Point(10,570),1);
		CargoAreaSpace nhstack3space2 = new CargoAreaSpace(42,"",new Point(10,570),2);
		CargoAreaSpace nhstack3space3 = new CargoAreaSpace(43,"",new Point(10,570),3);
		cargoAreaStack3.addChild(nhstack3space1);
		cargoAreaStack3.addChild(nhstack3space2);
		cargoAreaStack3.addChild(nhstack3space3);
		
		
		//Location under the cargoarea hasardous (contain 1 stack of 3 containers)
		CargoAreaStack hasardousStack1 = new CargoAreaStack(81,"area2stack1",new Point(510,510));
		cargoArea2Hasardous.addChild(hasardousStack1);
		CargoAreaSpace hstack1space1 = new CargoAreaSpace(82,"",new Point(510,510),1);
		CargoAreaSpace hstack1space2 = new CargoAreaSpace(83,"",new Point(510,510),2);
		CargoAreaSpace hstack1space3 = new CargoAreaSpace(84,"",new Point(510,510),3);
		hasardousStack1.addChild(hstack1space1);
		hasardousStack1.addChild(hstack1space2);
		hasardousStack1.addChild(hstack1space3);
		
		//creation of the Stradle carrier
		SCarrier scarrier1 = new SCarrier(151,"scarrier1",new Point(250,250),this);
		SCarrier scarrier2 = new SCarrier(152,"scarrier2",new Point(260,260),this);
		SCarrier scarrier3 = new SCarrier(153,"scarrier3",new Point(270,270),this);
		this.SCarriers.addElement(scarrier1);
		this.SCarriers.addElement(scarrier2);
		this.SCarriers.addElement(scarrier3);
		this.Port.addChild(scarrier1);
		this.Port.addChild(scarrier2);
		this.Port.addChild(scarrier3);
	
		
		//External Carrier (Where all the container will be at start)
		ExternalCarrier vessel = new ExternalCarrier(180,"Vessel", new Point(650,50));
		this.Port.addChild(vessel);
		
		//creation of the containers
		Container container1 = new Container(200,vessel,false);
		Container container2 = new Container(201,vessel,false);
		Container containerHasardous1= new Container(202,vessel,true);
		
		//Add the container the the list of container
		this.Containers.addElement(container1);
		this.Containers.addElement(container2);
		this.Containers.addElement(containerHasardous1);
	
	}

	/**
	 * FindClosetSC : Find the closest SCarrier who don't have a container on its near the location
	 * @param location : the place where a straddle carrier have to go
	 * @return the sCarrier nearest to the location or null if no Scarrier are available
	 */
	private SCarrier findClosestSC(PortLocation location) {
		Point position = location.getPosition();
		SCarrier closest = null;
		double distance = Double.MAX_VALUE;	
		for (Iterator iter = this.SCarriers.iterator(); iter.hasNext();) {
			SCarrier sctemp = (SCarrier)iter.next();
			//if the carrier is more near and if it is free
			if((position.distance(sctemp.getPosition()) < distance ) && (sctemp.getContainerIDSensor() == -1)){
				distance = position.distance(sctemp.getPosition());
				closest = sctemp;
			}
		}
		return closest;
	}
	
	/**
	 * fincContainer : return the container corresponding to the respective id
	 * @param id of the container to find
	 * @return the container
	 */
	private Container findContainer(int id){
		Container container = null;
		for (Iterator iter = this.Containers.iterator(); iter.hasNext();) {
			container = (Container)iter.next();
			if (container.getID() == id) return container;
		}
		return container;
	}

	/**
	 * containerLoaded : I don't know yet
	 * @param crane
	 */
	public void containerLoaded(Crane crane) {
		return;
	}

	/**
	 * containerUnloaded : find the closest Scarrier and set the destination of this carrier the the crane 
	 * @param crane : where the closest Scarrier had to go
	 */
	public void containerUnloaded(Crane crane) {
		SCarrier closest = findClosestSC(crane);
		closest.setDestination(crane);
		//And when the Scarrier will reach his destination the simulator will put the container on it
	}

	public void containerLoaded(SCarrier carrier, int containerID) {
		// TODO Auto-generated method stub

	}

	public void containerUnloaded(SCarrier carrier, int containerID) {
		// TODO Auto-generated method stub

	}

	/**
	 * destinationReached : when a stradlecarrier reach his destination, the simulator told him that
	 * 						if the Scarrier has a container on it, it has to unload it
	 * 						else it has to load the container and find where it has to go
	 * @param carrier : the carrier which reach its destination
	 */
	public void destinationReached(SCarrier carrier) {
		int idContainer = carrier.getContainerIDSensor();
			if (idContainer == -1){
				//Load a container
				Container Container = findContainer(idContainer);
				carrier.loadContainer(Container); //set the location of the container on the straddle carrier
				PortLocation cargoArea;
				if(Container.isHazardous()){
					//the Container is Hasardous
					cargoArea = this.Port.getChildren("CargoArea2Hasardous");
				}else{
					//The container is not Hasardous
					cargoArea = this.Port.getChildren("cargoArea1");
				}
				ContainerSpace emptyPlace = cargoArea.findFreeContainerSpace();
				Container.insertTransport(new Transport(emptyPlace));
				carrier.setDestination(emptyPlace);
			}else{
				//Unload a container
				Container Container = findContainer(idContainer);
				carrier.unloadContainer(Container, carrier.getDestination()); //will set the new location of the container
				Container.nextTransport();
				carrier.setContainerIDSensor(-1);
				//A savoir si il faut pas qu'on mette ici que le container est plus sur le carrier, dailleurs pour l'instant je l'ai fait comme ca
				
			}
	}

	public Vector<Container> getContainers() {
		return this.Containers;
	}

	public void setContainers(Vector<Container> containers) {
		this.Containers = containers;
	}

	public Port getPort() {
		return this.Port;
	}

	public void setPort(Port port) {
		this.Port = port;
	}

	public Vector<SCarrier> getSCarriers() {
		return this.SCarriers;
	}

	public void setSCarriers(Vector<SCarrier> carriers) {
		this.SCarriers = carriers;
	}

}
