package data;

import java.awt.Point;

public abstract class Carrier extends LeafPortLocation {

	public Carrier(int ID, String name, Point position) {
		super(ID, name, position);
	}
}
