package data;

import java.awt.Point;

public class CargoAreaSpace extends ContainerSpace {

	private boolean free; //true : empty,   false : occupied
	private int zPosition; //3 position : 1:On the ground / 2:in the middle / 3: on the top
	
	public CargoAreaSpace(int id, String name, Point position, int zposition) {
		super(id, name, position);
		this.free = true;
		this.zPosition=zposition;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}
	
	
	
}
