public class Container {

	/**
	 * @directed true
	 * @label is at
	 */

	private LeafPortLocation lnkLeafPortLocation;

	/**
	 * @directed true
	 * @label itinerary
	 */

	private Location lnkLocation;

	private int ID;

	public void setCurrentLocation(LeafPortLocation location) {
		return;
	}

	public int getID() {
		return ID;
	}

	public void setID(int property1) {
		this.ID = property1;
	}
}
