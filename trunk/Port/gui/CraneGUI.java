package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.JITController;

import data.*;

public class CraneGUI extends JFrame implements ActionListener {

	
	private JITController controller;
	/**
	 * @directed true
	 */
	
	private Crane crane;
	
	public CraneGUI(JITController jitc, Crane c) {
		controller=jitc;
		crane=c;
		
		JPanel jPanel = new JPanel();
		this.setContentPane(jPanel);
		JButton jButton = new JButton("container unloaded");
		jPanel.add(jButton);
		
		jButton.addActionListener(this);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public void containerUnloaded() {
		controller.containerUnloaded(crane);
	}

	public void actionPerformed(ActionEvent e) {
		containerUnloaded();
	}
}
