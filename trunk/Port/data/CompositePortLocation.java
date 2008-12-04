package data;

import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public abstract class CompositePortLocation extends PortLocation {

	/**
	 * @directed true
	 * @link composition
	 * @supplierCardinality 0..*
	 */
	private Vector<PortLocation> portLocations;
	
	public CompositePortLocation(int ID, String name, Point position) {
		super(ID, name, position);
		portLocations = new Vector<PortLocation>();
	}

	/**
	 * addChild : add a new location inside the current location
	 * @param location new location inside the current location (exemple : new quay in the port)
	 */
	public void addChild(PortLocation location) {
		this.portLocations.addElement(location);
		location.setParent(this);
		notifyObservers();
	}
	
	/**
	 * getChildren : return the specific children 
	 * @param name of the children that we want to find
	 * @return the specific children
	 */
	public PortLocation getChildren(String name){
		PortLocation location = null;
		for (Iterator iter = this.portLocations.iterator(); iter.hasNext();) {
			location = (PortLocation)iter.next();
			//if the carrier is more near and if it is free
			if(location.getName().equals(name)) return location;
		}
		return location;
	}
	
	/**
	 * getChildren : return all the children of the current location
	 * @return all the childrens
	 */
	public Collection<PortLocation> getChildren() {
		return portLocations;
	}

}
