package data;

import java.awt.Point;
import java.util.Collection;
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
		notifyObservers();
	}
	
	public Collection<PortLocation> getChildren() {
		return portLocations;
	}

}
