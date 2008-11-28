import java.awt.Point;

public class SCarrier extends LeafPortLocation {

	private LeafPortLocation destination;

	public void identifyContainerSensor() {
		return;
	}

	public boolean isMoving() {
		//Commented automatically
		//return;
		return false;
	}

	public void setDestination(Point p, boolean loadContainerAtLocation) {
		return;
	}

	public LeafPortLocation getDestination() {
		return destination;
	}

	public void setDestination(LeafPortLocation property1) {
		this.destination = property1;
	}

}
