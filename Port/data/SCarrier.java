package data;


public class SCarrier extends Carrier {

	private int containerIDSensor;

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
