package data;
import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

public abstract class PortLocation extends Observable {

	private int ID;
	private String name;
	private Point position;
	private PortLocation parent;
	
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
		return parent;
	}
	
	public void setParent(PortLocation parent) {
		this.parent=parent;
	}

	/**
	 * findfreeContainerSpace : look into the cargoArea in order to find free space for stocking containers
	 * @return the CargoAreaSpace free or null if there is no empty place
	 */
	public CargoAreaSpace findFreeContainerSpace() {
		Collection<PortLocation> childrens = this.getChildren();
		for (Iterator iter = childrens.iterator(); iter.hasNext();) {
			PortLocation stack = (PortLocation) iter.next();
			Collection<PortLocation> cargoAreaspaces = stack.getChildren();
			for (Iterator iterator2 = cargoAreaspaces.iterator(); iterator2.hasNext();) {
				CargoAreaSpace space = (CargoAreaSpace) iterator2.next();
				if (space.isFree()) return space;
			}
		}
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
		setChanged();
		super.notifyObservers(arg);
		if(getParent()!=null) {
			getParent().notifyObservers();
		}
	}
}
