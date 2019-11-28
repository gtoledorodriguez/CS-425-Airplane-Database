package com.airplane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;


public class address {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	lrun ladr = new lrun();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					address window = new address();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public address() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(16, 531, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeport hp3 = new homeport();
				hp3.NewScreen();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnBack);
		
		JButton btnSkip = new JButton("Next/Skip");
		btnSkip.setBounds(594, 531, 117, 29);
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creditcard cc1 = new creditcard();
				cc1.NewScreen();
			}
		});
		frame.getContentPane().add(btnSkip);
		
		
		
		JButton btnAddAddress = new JButton("Add Address");
		btnAddAddress.setBounds(537, 476, 117, 29);
		btnAddAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteaddr da2 = new deleteaddr();
				da2.NewScreen();
			}
		});
		frame.getContentPane().add(btnAddAddress);
		
		JButton btnChangeAddress = new JButton("Change Address");
		btnChangeAddress.setBounds(51, 476, 138, 29);
		btnChangeAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeaddr ca1 = new changeaddr();
				ca1.NewScreen();
			}
		});
		frame.getContentPane().add(btnChangeAddress);
		
		JButton btnDeleteAddress = new JButton("Delete Address");
		btnDeleteAddress.setBounds(297, 476, 130, 29);
		btnDeleteAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteaddr da1 = new deleteaddr();
				da1.NewScreen();
			}
		});
		frame.getContentPane().add(btnDeleteAddress);
		
		JLabel lblr3 = new JLabel("The following addresses are registered under your username:");
		lblr3.setBounds(16, 55, 710, 16);
		frame.getContentPane().add(lblr3);
		
		JLabel lbladformat = new JLabel("Street_Number         Street_Name     Apt_Number(if any)        City         State           Zipcode");
		lbladformat.setBounds(16, 72, 728, 16);
		frame.getContentPane().add(lbladformat);
		
		JTextArea try1 = new JTextArea();
		try1.setBackground(new Color(255, 204, 102));
		try1.setBounds(6, 94, 738, 61);
		try1.setEditable(false);
		frame.getContentPane().add(try1);
		
		JButton btnSubmit = new JButton("View Addresses");
		btnSubmit.setBounds(268, 16, 117, 29);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try1.setText(lrun.listaddr(StartApp.uname.getText()));
			}});
		frame.getContentPane().add(btnSubmit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/Omesh/Downloads/flight.jpg"));
		label.setBounds(0, -1, 750, 579);
		frame.getContentPane().add(label);
		
		
		
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					address window = new address();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}
}
