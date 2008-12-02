package data;

import java.awt.Point;


public class SCarrier extends Carrier {

	private int containerIDSensor;

	
	
	/**
	 * Constructor of the classe
	 * @param id : id of the straddle carrier
	 * @param name : name of the straddle carrier
	 * @param position : original position of the straddle carrier
	 */
	public SCarrier(int id, String name, Point position) {
		super();
		this.ID = id;
		this.name = name;
		this.position = position;
		this.containerIDSensor = -1;
	}

	public void unloadContainer() {
		return;
	}

	public void loadContainer() {
			return;
		}

	public void destinationReachedEventSensor() {
		return;
	}

	public boolean isMoving() {
		//Commented automatically
		//return;
		return false;
	}

	public LeafPortLocation getDestination() {
		return destination;
	}

	public void setDestination(LeafPortLocation property1) {
		this.destination = property1;
	}

	public int getContainerIDSensor() {
			return property1;
		}

	public void setContainerIDSensor(int property1) {
			this.property1 = property1;
		}

}
