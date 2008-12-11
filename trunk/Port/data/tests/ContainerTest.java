package data.tests;

import java.awt.Point;

import data.Container;
import data.Crane;
import data.Transport;
import junit.framework.TestCase;

public class ContainerTest extends TestCase {
	
	private Container cont;
	private Transport t1;
	private Transport t2;

	public void setUp() {
		Crane crane1 = new Crane(1, "C1", new Point(0, 0));
		Crane crane2 = new Crane(2, "C2", new Point(0, 0));
		cont = new Container(99, null, false);
		t1= new Transport(crane1);
		t2= new Transport(crane2);
	}

	public void testInsertTransport() {
		cont.insertTransport(t1);
		assertTrue("insertion failed", cont.peekTransport()==t1);
		cont.insertTransport(t2);
		assertTrue("insertion failed", cont.peekTransport()==t2);
	}

	public void testPeekTransport() {
		assertTrue("should return null if no existing transport", cont.peekTransport()==null);
		cont.insertTransport(t1);
		assertTrue("should return t1 because it is the last inserted", cont.peekTransport()==t1);
		cont.insertTransport(t2);
		assertTrue("should return t2 because it is the last inserted", cont.peekTransport()==t2);
		cont.nextTransport();
		assertTrue("should return t1 because it was inserted before t2",cont.peekTransport()==t1);
	}

	public void testNextTransport() {
		try {
			cont.nextTransport();
			fail("an IllegalStateException should be thrown because there is no next transport.");
		} catch(IllegalStateException e) {}
		cont.insertTransport(t1);
		cont.insertTransport(t2);
		assertTrue(cont.nextTransport()==t1);
		try {
			cont.nextTransport();
			fail("an IllegalStateException should be thrown because there is no next transport.");
		} catch(IllegalStateException e) {}
	}

}
