package com.airplane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GUIApp {

	private JFrame HomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApp window = new GUIApp();
					window.HomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HomePage = new JFrame();
		HomePage.setBounds(100, 100, 750, 600);
		HomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HomePage.getContentPane().setLayout(null);
		
		JLabel msglbl = new JLabel("Hello " +StartApp.uname.getText() + ",");
		msglbl.setBounds(32, 22, 131, 16);
		HomePage.getContentPane().add(msglbl);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(238, 69, 207, 55);
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeport hp = new homeport();
				hp.NewScreen();
			}
		});
		HomePage.getContentPane().add(btnProfile);
		
		JButton btnSearchFlight = new JButton("Search Flight");
		btnSearchFlight.setBounds(238, 134, 207, 55);
		btnSearchFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightConnections fc = new FlightConnections();
				fc.NewScreen();
			}
		});
		HomePage.getContentPane().add(btnSearchFlight);
		
		JButton btnbookFlight = new JButton("BookFlight");
		btnbookFlight.setBounds(238, 199, 207, 55);
		btnbookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookFlights bf = new BookFlights();
				bf.NewScreen();
			}
		});
		HomePage.getContentPane().add(btnbookFlight);
		
		JButton btnManageFlights = new JButton("Manage Flights");
		btnManageFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageFlights mf = new ManageFlights();
				mf.NewScreen();
			}
		});
		btnManageFlights.setBounds(238, 264, 207, 55);
		HomePage.getContentPane().add(btnManageFlights);
		
		JButton button = new JButton("Log Off");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartApp sp2 = new StartApp();
				sp2.NewScreen();
			}
		});
		button.setBounds(238, 426, 207, 55);
		HomePage.getContentPane().add(button);
		
		JButton btnMileageProgram = new JButton("Mileage Program");
		btnMileageProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MileageProgram mp = new MileageProgram();
				mp.NewScreen();
			}
		});
		btnMileageProgram.setBounds(238, 336, 207, 55);
		HomePage.getContentPane().add(btnMileageProgram);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/Omesh/Downloads/flight.jpg"));
		lblNewLabel.setBounds(0, 0, 750, 578);
		HomePage.getContentPane().add(lblNewLabel);
		
		
		
		
		
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApp window = new GUIApp();
					window.HomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}
}