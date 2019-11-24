package com.airplane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApp window = new GUIApp();
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
	public GUIApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 457, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAirlineFlighBooking = DefaultComponentFactory.getInstance().createTitle("Airline Flight Booking");
		lblAirlineFlighBooking.setBounds(0, 10, 442, 30);
		lblAirlineFlighBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblAirlineFlighBooking.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblAirlineFlighBooking);
		
		JButton btnNewButton = new JButton("Registration");
		btnNewButton.setBounds(125, 108, 182, 41);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnPaymentaddress = new JButton("Payment/Address");
		btnPaymentaddress.setBounds(125, 171, 182, 41);
		btnPaymentaddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnPaymentaddress);
		
		JButton btnFlightConnections = new JButton("Flight Connections");
		btnFlightConnections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightConnections flightCs = new FlightConnections();
				flightCs.NewScreen();
			}
		});
		btnFlightConnections.setBounds(125, 237, 182, 41);
		btnFlightConnections.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnFlightConnections);
		
		JButton btnBookFlights = new JButton("Book Flight(s)");
		btnBookFlights.setBounds(125, 302, 182, 41);
		btnBookFlights.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnBookFlights);
		
		JButton btnManageFlights = new JButton("Manage Flights");
		btnManageFlights.setBounds(125, 369, 182, 41);
		btnManageFlights.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnManageFlights);
	}
}
