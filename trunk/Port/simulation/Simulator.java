package simulation;
import java.util.Iterator;
import java.util.Vector;

import data.Container;
import data.Quay;
import data.SCarrier;


public class Simulator extends java.lang.Thread {

	private Vector<SCarrier> SCarriers;
	private Vector<Container> Containers;

	public Simulator(Vector<SCarrier> carriers, Vector<Container> containers) {
		super();
		this.SCarriers = carriers;
		this.Containers = containers;
	}

	
	public void run() {
		
		double dx = 0;
		double dy = 0;
		int translateX = 0;
		int translateY = 0;
		
		while(true){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Bloc catch auto-généré
			e1.printStackTrace();
		}
		for (Iterator iter = this.SCarriers.iterator(); iter.hasNext();) {
			SCarrier scarrier = (SCarrier) iter.next();
			System.out.println("nom du SCcarrier " + scarrier.getName());
			System.out.println("Position de ce SCarrier (x) : " + scarrier.getPosition().getX());
			if (scarrier.getDestination() != null){
				//the Scarrier has a destination
				if (!(scarrier.getDestination().getPosition().equals(scarrier.getPosition()))){
					//the Scarrier is not at his destination
					dx = scarrier.getDestination().getPosition().getX() - scarrier.getPosition().getX();
					if (dx < 0 ) translateX = -1; else translateX = 1;
					dy = scarrier.getDestination().getPosition().getY() - scarrier.getPosition().getY();
					if (dy < 0 ) translateY = -1; else translateY = 1;
					if(Math.abs(dx)<Math.abs(dy)){
						//First move in diagonale and then following Y componant
						while(scarrier.getPosition().getX() != scarrier.getDestination().getPosition().getX() ) {
							scarrier.getPosition().translate(translateX, translateY);
							scarrier.setPosition(scarrier.getPosition());
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						while(scarrier.getPosition().getY() != scarrier.getDestination().getPosition().getY() ) {
							scarrier.getPosition().translate(0 , translateY);
							scarrier.setPosition(scarrier.getPosition());
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						
					}else{
						//First move in diagonale and then following X componant
						while(scarrier.getPosition().getY() != scarrier.getDestination().getPosition().getY() ) {
							scarrier.getPosition().translate(translateX, translateY);
							scarrier.setPosition(scarrier.getPosition());
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						while(scarrier.getPosition().getX() != scarrier.getDestination().getPosition().getX() ) {
							scarrier.getPosition().translate(translateX , 0);
							scarrier.setPosition(scarrier.getPosition());
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}//end if for the choice of directions
					
					if (scarrier.getContainerIDSensor() == -1){
						//the carrier does'nt have a container on it
						scarrier.destinationReachedEventSensor();
					}else{
						//the carrier has a container on it,  it should let it where it is
						scarrier.destinationReachedEventSensor();
						for(int i = 0; i<100;i++){
							scarrier.getPosition().translate(0, -1);
							scarrier.setPosition(scarrier.getPosition());
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						scarrier.setDestination(null);
					}
					
				}//end if position.origin != position.destination
			}//end if destination != null
			
			
		
			
			
			
			
			//The carrier reach his destination, he has no more purpose until the controlleur told him otherwise
			//scarrier.setDestination(null);
		}
		
		
			
			
		}
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
		
		
		
	
}
