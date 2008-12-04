package simulation;
import java.util.Iterator;
import java.util.Vector;

import data.Container;
import data.SCarrier;


public class Simulator extends java.lang.Thread {

	private Vector<SCarrier> SCarriers;
	private Vector<Container> Containers;

	public Simulator(Vector<SCarrier> carriers, Vector<Container> containers) {
		super();
		this.SCarriers = carriers;
		this.Containers = containers;
	}

	
	public void run() {
		
		for (Iterator iter = this.SCarriers.iterator(); iter.hasNext();) {
			SCarrier scarrier = (SCarrier) iter.next();
			System.out.println("nom du SCcarrier " + scarrier.getName());
			System.out.println("Postion de ce SCcarrier du SCcarrier " + scarrier.getName());
			
		}
		
		while(true){
			
			
		}
	}

}
