package gui;

import java.awt.Point;
import java.util.Vector;

import data.Container;
import data.Port;
import data.SCarrier;

public class GraphicalTest {

	public static void main(String[] args) {
		Port port = new Port(1, "BestPort", new Point(10, 50));
		CraneGUI cgui = new CraneGUI(null, null);
		LogisticsDptGUI logistics = new LogisticsDptGUI(null, new Vector<Container>(), port);
	
		SCarrier sc = new SCarrier(1, "SC1", new Point(600, 400));
		port.addChild(sc);
		
		while(sc.getPosition().x > 0 && sc.getPosition().y > 0) {
			sc.getPosition().translate(-1, -1);
			sc.setPosition(sc.getPosition());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
