public class Container {

	private boolean hazardous;

	/**
	 * @clientNavigability NAVIGABLE
	 * @label is at
	 */

	private LeafPortLocation lnkLeafPortLocation;

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

	public boolean isHazardous() {
		return hazardous;
	}

	public void setHazardous(boolean hazardous) {
		this.hazardous = hazardous;
	}

}
