package simulation;
import java.util.Vector;

import data.SCarrier;


public class Simulator extends java.lang.Thread {

	private Vector<SCarrier> SCarriers;

	public Simulator(Vector<SCarrier> carriers) {
		super();
		this.SCarriers = carriers;
		run();
	}

	
	public void run() {
		
		
		while(true){
			
			
		}
	}

}
