import java.awt.Point;

public class SCarrier implements ContainerLocation {

	private Point position;

	public void identifyContainer() {
			return;
		}

	public void destinationReached() {
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

	public Point getPosition() {
		//Commented automatically
		//return;
		return null;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(Point property1) {
		this.position = property1;
	}
}
