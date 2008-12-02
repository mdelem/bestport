package data;

import java.util.Collection;

public abstract class CompositePortLocation extends PortLocation {

	
	/**
	 * @directed true
	 * @link composition
	 */
	
	private PortLocation lnkPortLocation;

	public void addChild(PortLocation location) {
		return;
	}

	public Collection<PortLocation> getChildren() {
		//Commented automatically
		//return null;
		return null;
	}
}
