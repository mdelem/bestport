package gui;

import java.awt.Point;

import data.Port;

public class GraphicalTest {

	public static void main(String[] args) {
		CraneGUI cgui = new CraneGUI(null, null);
		LogisticsDptGUI logistics = new LogisticsDptGUI(null, null, new Port(1, "BestPort", new Point(100, 100)));
	}

}
