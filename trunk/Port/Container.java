public class Container {

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
	 * @label is at
	 */

	private LeafPortLocation lnkLeafPortLocation;

	private int ID;

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

	public void setCurrentLocation(LeafPortLocation location) {
		return;
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
