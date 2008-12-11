package data.tests;

import java.awt.Point;

import data.CargoArea;
import data.Crane;
import data.Port;
import data.SCarrier;
import junit.framework.TestCase;

public class PortTest extends TestCase {
	
	private Port port;
	private SCarrier sc;
	private Crane crane;
	private CargoArea cargo;

	public void setUp() {
		port = new Port(99, "Port", new Point(0, 0));
		sc = new SCarrier(1, "SC", new Point(0, 0), null);
		crane = new Crane(2, "Crane", new Point(0, 0));
		cargo = new CargoArea(3, "Cargo", new Point(0, 0));
	}

	public void testGetChildren() {
		assertTrue("there should be no child", port.getChildren().isEmpty());
		port.addChild(sc);
		assertTrue("should have only one child yet", port.getChildren().size()==1);
		assertTrue("should contain sc", port.getChildren().contains(sc));
		port.addChild(crane);
		port.addChild(cargo);
		assertTrue("should be of size 3", port.getChildren().size()==3);
		assertTrue("should contain sc, crane and cargo",
				port.getChildren().contains(sc)
				&& port.getChildren().contains(cargo)
				&& port.getChildren().contains(crane));
	}

	public void testAddChild() {
		port.addChild(sc);
		assertTrue("should have only one child yet", port.getChildren().size()==1);
		assertTrue("should contain sc", port.getChildren().contains(sc));
		cargo.addChild(crane);
		port.addChild(cargo);
		assertTrue("should be of size 2", port.getChildren().size()==2);
		assertTrue("should contain scand cargo",
				port.getChildren().contains(sc)
				&& port.getChildren().contains(cargo));
	}

	public void testGetChildrenString() {
		port.addChild(sc);
		port.addChild(cargo);
		port.addChild(crane);
		System.out.println(port.getChildren("nohere"));
		assertTrue("should not contain this element \"nothere\"", port.getChildren("nohere")==null);
		
		assertTrue(port.getChildren("SC")==sc 
				&& port.getChildren("Crane")==crane
				&& port.getChildren("Cargo")==cargo);
	}

}
