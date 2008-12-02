package data;

import java.awt.Point;

public class Port extends CompositePortLocation {

	public Port(int id, String name, Point position) {
		super();
		this.ID = id;
		this.name = name;
		this.position = position;
	}
}
