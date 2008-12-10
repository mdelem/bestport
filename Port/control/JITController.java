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
		Container container3 = new Container(202,vessel,false);
		Container container4 = new Container(203,vessel,false);
		Container container5 = new Container(204,vessel,false);
		Container container6 = new Container(205,vessel,false);
		Container container7 = new Container(206,vessel,false);
		Container containerHasardous1= new Container(220,vessel,true);
		Container containerHasardous2= new Container(221,vessel,true);
		Container containerHasardous3= new Container(222,vessel,true);
		
		
		//Add the container the the list of container
		this.Containers.addElement(container1);
		this.Containers.addElement(containerHasardous1);
		this.Containers.addElement(container2);
		this.Containers.addElement(containerHasardous2);
		this.Containers.addElement(container3);
		this.Containers.addElement(containerHasardous3);
		this.Containers.addElement(container4);
		this.Containers.addElement(container5);
		this.Containers.addElement(container6);
		this.Containers.addElement(container7);
		
		
	
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
	 * findContainerToUnload : will find one container to onload at the quay
	 * @return the container to unload or null if there is no container
	 */
	private Container findContainerToUnload(){
		
		for (Iterator iter = this.Containers.iterator(); iter.hasNext();) {
			Container cont = (Container) iter.next();
			if (cont.getLocation().getPosition().equals(((Quay)this.Port.getChildren("Quay1")).getPosition())){
				//there is at least one container waiting at the quay
				return cont;
			}
		}
		return null;
	}
	
	/**
	 * moveContainerToCrane : will move the container which is supposed to be at quay to the crane
	 * @param cont : container to move
	 * @param crane : crane where the container has to go
	 */
	private void moveContainerToCrane(Container cont, Crane crane){
		cont.setLocation(crane);
	}
	
	/**
	 * findContainerAtCrane : will find the container which is at the crane  (and then at the position of the scarrier)
	 * @return the container at the same position than the scarrier
	 */
	private Container findContainerAtCrane(SCarrier scarrier){			
		for (Iterator iter = this.Containers.iterator(); iter.hasNext();) {
			Container cont = (Container) iter.next();
			if (cont.getLocation().getPosition().equals(scarrier.getPosition())){
				return cont; //there is a container at the crane , we return it
			}
		}
		return null;
	}
	
	/**
	 * isContainerAtCrane : test if there is a container at the specific crane
	 * @param c : the crane where we want to test if there is a container
	 * @return true : there is a container / false : no container at the crane
	 */
	private boolean isContainerAtCrane(Crane c){
		for (Iterator iter = this.Containers.iterator(); iter.hasNext();) {
			Container cont = (Container) iter.next();
			if (cont.getLocation().getPosition().equals(c.getPosition())){
				return true; //there is a container at the crane , we return it
			}
		}
		return false;
	}
	
	/**
	 * containerLoaded : not implemented
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
		//first we have to check that some containers wait at quay to be unloaded
		Container cont = findContainerToUnload();
		if (cont != null){
			if(!isContainerAtCrane(crane)){//We now check that there are no container on the crane at the moment
				//there is at least one container to unload
				SCarrier closest = findClosestSC(crane);
				if (closest != null){
				moveContainerToCrane(cont, crane); //The container was at the quay we put it on the crane (it simulate that the crane unload the container from the vessel)		
				closest.setContainerIDSensor(0); //this is a trick in order to tell to the simulator that this Scarrier is not free
				closest.setDestination(crane);
				}else{
					System.out.println("No Straddle Carrier are available for the moment, try later");
				}
			}else{
				System.out.println("There is a container at the crane, you have to wait that a Straddle carrier come to get it");
			}
			//And when the Scarrier will reach his destination the simulator will put the container on it
		}else{
			System.out.println("There are no more containers to unload");
		}
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
	public void destinationReached(SCarrier scarrier) {
		int idContainer = scarrier.getContainerIDSensor();
		if(!scarrier.isContainerLoaded() && idContainer!=-1) {
			//Load a container
			Container container = findContainer(idContainer);
			scarrier.loadContainer(container); //set the location of the container on the straddle carrier
			PortLocation cargoArea;
			if(container.isHazardous()){
				//the Container is Hasardous
				cargoArea = this.Port.getChildren("CargoArea2Hasardous");
			}else{
				//The container is not Hasardous
				cargoArea = this.Port.getChildren("CargoArea1");
			}
			CargoAreaSpace emptyPlace = cargoArea.findFreeContainerSpace();
			emptyPlace.setFree(false); //we supose here that there is always free space in the port
			container.insertTransport(new Transport(emptyPlace));
			scarrier.setDestination(emptyPlace);
		}
		else if(idContainer!=-1){
			//Unload a container
			scarrier.getLoadedContainer().nextTransport();
			scarrier.unloadContainer(scarrier.getDestination()); //will set the new location of the container
			scarrier.setDestination(null);
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
