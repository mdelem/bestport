package data;

import java.util.Observable;

public class Container extends Observable {

	private int nextTransportIndex;

	/**
	 * @clientCardinality 1
	 * @directed true
	 * @label itinerary
	 * @supplierCardinality 0..*
	 */

	private Transport lnkTransport;

	private boolean hazardous;

	/**
	 * @clientNavigability NAVIGABLE
	 * @directed true
	 * @label is at
	 */

	private LeafPortLocation lnkLeafPortLocation;

	private int ID;

	public void insertTransport(Transport t) {
		return;
	}

	public Transport peekTransport() {
		//Commented automatically
		//return;
		return null;
	}

	public Transport nextTransport() {
		//Commented automatically
		//return;
		return null;
	}

	public void setLocation(LeafPortLocation location) {
		return;
	}

	public LeafPortLocation getLocation() {
		//Commented automatically
		//return;
		return null;
	}

	public int getID() {
		return ID;
	}

	public void setID(int property1) {
		this.ID = property1;
	}

	public boolean isHazardous() {
		return hazardous;
	}

	public void setHazardous(boolean hazardous) {
		this.hazardous = hazardous;
	}

}
