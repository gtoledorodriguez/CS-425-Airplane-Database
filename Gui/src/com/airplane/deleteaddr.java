package com.airplane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class deleteaddr {

	private JFrame frame;
	private JTextField snum;
	private JTextField sname;
	private JTextField apnum;
	private JTextField city;
	private JTextField state;
	private JTextField zcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteaddr window = new deleteaddr();
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
	public deleteaddr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblsnum = new JLabel("Enter the Street Number:");
		lblsnum.setBounds(20, 62, 191, 16);
		frame.getContentPane().add(lblsnum);
		
		JLabel lblsname = new JLabel("Enter the Street Name:");
		lblsname.setBounds(20, 124, 191, 16);
		frame.getContentPane().add(lblsname);
		
		JLabel lblapnum = new JLabel("Enter the Apt. Number (if any):");
		lblapnum.setBounds(20, 190, 191, 16);
		frame.getContentPane().add(lblapnum);
		
		JLabel lblcity = new JLabel("Enter the City:");
		lblcity.setBounds(20, 249, 191, 16);
		frame.getContentPane().add(lblcity);
		
		JLabel lblstate = new JLabel("Enter the State:");
		lblstate.setBounds(20, 303, 191, 16);
		frame.getContentPane().add(lblstate);
		
		JLabel lblzcode = new JLabel("Enter the Zipcode:");
		lblzcode.setBounds(20, 364, 191, 16);
		frame.getContentPane().add(lblzcode);
		
		snum = new JTextField();
		snum.setBounds(424, 57, 130, 26);
		frame.getContentPane().add(snum);
		snum.setColumns(10);
		
		sname = new JTextField();
		sname.setBounds(424, 114, 130, 26);
		frame.getContentPane().add(sname);
		sname.setColumns(10);
		
		apnum = new JTextField();
		apnum.setColumns(10);
		apnum.setBounds(424, 185, 130, 26);
		frame.getContentPane().add(apnum);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(424, 244, 130, 26);
		frame.getContentPane().add(city);
		
		state = new JTextField();
		state.setColumns(10);
		state.setBounds(424, 298, 130, 26);
		frame.getContentPane().add(state);
		
		zcode = new JTextField();
		zcode.setColumns(10);
		zcode.setBounds(424, 359, 130, 26);
		frame.getContentPane().add(zcode);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				address a3 = new address();
				a3.NewScreen();
			}
		});
		btnBack.setBounds(54, 512, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lrun.remaddress(StartApp.uname.getText(), snum.getText(), sname.getText(), apnum.getText(), city.getText(), state.getText(), zcode.getText());
				address a4 = new address();
				a4.NewScreen();
			}
		});
		btnDelete.setBounds(277, 512, 117, 29);
		frame.getContentPane().add(btnDelete);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lrun.addaddress(StartApp.uname.getText(), snum.getText(), sname.getText(), apnum.getText(), city.getText(), state.getText(), zcode.getText());
				address a5 = new address();
				a5.NewScreen();
			}
		});
		btnAdd.setBounds(528, 512, 117, 29);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/Omesh/Downloads/flight.jpg"));
		lblNewLabel.setBounds(0, 0, 750, 578);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteaddr window = new deleteaddr();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}

}