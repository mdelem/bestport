import java.awt.Point;

public abstract class PortLocation {

	private int ID;

	private String name;

	private Point position;

	public PortLocation getParent() {
		//Commented automatically
		//return;
		return null;
	}

	public ContainerSpace findFreeContainerSpace() {
		//Commented automatically
		//return null;
		return null;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point property1) {
		this.position = property1;
	}

	public String getName() {
		return name;
	}

	public void setName(String property1) {
		this.name = property1;
	}

	public int getID() {
		return ID;
	}

	public void setID(int property1) {
		this.ID = property1;
	}
}
