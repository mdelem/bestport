package data;

import java.util.Collection;
import java.util.Vector;

public abstract class LeafPortLocation extends PortLocation {
	
	public Collection<PortLocation> getChildren() {
		return new Vector<PortLocation>(0);
	}
}
