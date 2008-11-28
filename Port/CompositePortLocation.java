public abstract class CompositePortLocation extends PortLocation {

	
	/**
	 * @directed true
	 * @link composition
	 */
	
	private PortLocation lnkPortLocation;

	public void addChild(PortLocation location) {
		return;
	}

	public PortLocation getChildren() {
		//Commented automatically
		//return;
		return null;
	}
}
