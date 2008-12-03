package data;

import java.awt.Point;
import java.util.Collection;
import java.util.Vector;

public abstract class LeafPortLocation extends PortLocation {
	
	public LeafPortLocation(int ID, String name, Point position) {
		super(ID, name, position);
	}
	
	public Collection<PortLocation> getChildren() {
		return new Vector<PortLocation>(0);
	}
}
