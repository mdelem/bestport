package data;

import java.util.Vector;

public abstract class CompositePortLocation extends PortLocation {

	
	/**
	 * @directed true
	 * @link composition
	 * @supplierCardinality 0..*
	 */
	private Vector<PortLocation> PortLocations;

	/**
	 * addChild : add a new location inside the current location
	 * @param location new location inside the current location (exemple : new quay in the port)
	 */
	public void addChild(PortLocation location) {
		this.PortLocations.addElement(location);
	}

	/**
	 * GetChildrens : get one children of the current location (exemple : return one cargoAreaStack of one CargoArea)
	 * @return PortLocation : the asked children
	 */
	public PortLocation getChildren(PortLocation location) {
		int index = this.PortLocations.indexOf(location);
		return this.PortLocations.elementAt(index);
	}
}
