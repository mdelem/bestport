import java.awt.Point;

public class SCarrier extends LeafPortLocation {

	public void destinationReachedEventSensor() {
				return;
			}

	public void containerIDSensor() {
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

}
