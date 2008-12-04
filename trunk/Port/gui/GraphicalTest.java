package gui;

import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import control.JITController;

import data.Container;
import data.Crane;
import data.Port;
import data.PortLocation;
import data.Quay;
import data.SCarrier;

public class GraphicalTest {

	public static void main(String[] args) {
		
		JITController control = new JITController();
		LogisticsDptGUI logistics = new LogisticsDptGUI(control, control.getContainers(), control.getPort());
		
		CraneGUI cgui = new CraneGUI(control, null);
		
		PortLocation vessel = control.getPort().getChildren("Vessel");
		//First part of the simulation , make the vessel approch the quay
		while(vessel.getPosition().x > 500 ) {
			vessel.getPosition().translate(-1, 0);
			vessel.setPosition(vessel.getPosition());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/*
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
		}*/
	}

}
