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
		frame.setBounds(100, 100, 456, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAirlineFlighBooking = DefaultComponentFactory.getInstance().createTitle("Airline Flight Booking");
		lblAirlineFlighBooking.setBounds(0, 10, 442, 30);
		lblAirlineFlighBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblAirlineFlighBooking.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblAirlineFlighBooking);
		
		JButton btnNewButton = new JButton("Registration");
		btnNewButton.setBounds(145, 154, 119, 41);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Registration");
		button.setBounds(145, 217, 119, 41);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Registration");
		button_1.setBounds(145, 283, 119, 41);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Registration");
		button_2.setBounds(145, 348, 119, 41);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Registration");
		button_3.setBounds(145, 415, 119, 41);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(button_3);
	}
}
