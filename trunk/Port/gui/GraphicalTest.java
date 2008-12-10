package gui;

import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import simulation.Simulator;

import control.JITController;

import data.Container;
import data.Crane;
import data.ExternalCarrier;
import data.Port;
import data.PortLocation;
import data.Quay;
import data.SCarrier;

public class GraphicalTest {

	public static void main(String[] args) {
		
		JITController control = new JITController();
		LogisticsDptGUI logistics = new LogisticsDptGUI(control, control.getContainers(), control.getPort());
		
		Crane crane1 = (Crane)((Quay)control.getPort().getChildren("Quay1")).getChildren("Crane1");
		Crane crane2 = (Crane)((Quay)control.getPort().getChildren("Quay1")).getChildren("Crane2");
		
		CraneGUI cgui1 = new CraneGUI(control, crane1);
		CraneGUI cgui2 = new CraneGUI(control, crane2);
		
		ExternalCarrier vessel = (ExternalCarrier)control.getPort().getChildren("Vessel");
		
		
		Simulator simu = new Simulator(vessel, control.getSCarriers(),control.getContainers());
		simu.start(); // this will automatically call the run() method in the simulator
		
	
	}

}
