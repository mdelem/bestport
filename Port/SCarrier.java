
public class SCarrier extends LeafPortLocation {

	private int containerIDSensor;

	public void loadContainerOrder() {
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
