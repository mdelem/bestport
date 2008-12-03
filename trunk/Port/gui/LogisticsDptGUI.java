package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.JITController;

import data.Container;
import data.Port;
import data.PortLocation;

public class LogisticsDptGUI extends JFrame implements Observer {

	
	/**
	 * @directed true
	 */
	
	private Collection<Container> containers;
	private Port port;
	private JITController controller;
	private JPanel jPanel;
	
	public LogisticsDptGUI(JITController jitc, Collection<Container> c, Port p) {
		this.controller=jitc;
		this.port=p;
		this.containers=c;
		
		port.addObserver(this);
		
		jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension(800, 600));
		this.setContentPane(jPanel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		update(null, null);
	}
	
	public void update(Observable o, Object arg) {
		this.repaint();
		
	}
	
	private void paint(Graphics g, PortLocation loc) {
		g.drawString(loc.getName(), loc.getPosition().x, loc.getPosition().y);
		for(PortLocation child : loc.getChildren()) {
			paint(g, child);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		paint(g, port);
	}
}
