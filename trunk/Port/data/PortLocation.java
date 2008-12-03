package data;
import java.awt.Point;
import java.util.Collection;
import java.util.Observable;


public abstract class PortLocation extends Observable {

	private int ID;
	private String name;
	private Point position;
	
	public PortLocation(int ID, String name, Point position) {
		this.ID=ID;
		this.name=name;
		this.position=position;
	}

	

	/**
	 * GetChildrens : get one children of the current location (exemple : return one cargoAreaStack of one CargoArea)
	 * @return PortLocation : the asked children
	 */
	public abstract Collection<PortLocation> getChildren();

	public long distanceTo(PortLocation otherLocation) {
		//Commented automatically
		//return;
		return 0;
	}

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
		notifyObservers();
	}

	public String getName() {
		return name;
	}

	public void setName(String property1) {
		this.name = property1;
		notifyObservers();
	}

	public int getID() {
		return ID;
	}

	public void setID(int property1) {
		this.ID = property1;
		notifyObservers();
	}
	
	
	public void notifyObservers(Object arg) {
		super.notifyObservers(arg);
		if(getParent()!=null) {
			getParent().notifyObservers();
		}
	}
}
