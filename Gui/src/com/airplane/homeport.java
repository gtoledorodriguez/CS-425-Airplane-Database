package com.airplane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class homeport {

	private JFrame frame;
	private JTextField e_hport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeport window = new homeport();
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
	public homeport() {
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
		
		JLabel lblhport = new JLabel("Home Airport");
		lblhport.setBounds(284, 31, 253, 37);
		lblhport.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		frame.getContentPane().add(lblhport);
		
		JLabel lble_hport = new JLabel("Please Enter the 3-digit IATA Code for your Home Airport:");
		lble_hport.setBounds(22, 173, 388, 89);
		frame.getContentPane().add(lble_hport);
		
		JLabel lblex1 = new JLabel("Example of IATA Code: ORD - O'Hare International Airport");
		lblex1.setBounds(22, 247, 379, 16);
		frame.getContentPane().add(lblex1);
		
		e_hport = new JTextField();
		e_hport.setBounds(519, 204, 130, 26);
		frame.getContentPane().add(e_hport);
		e_hport.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApp hp1 = new GUIApp();
				hp1.NewScreen();
			}
		});
		btnBack.setBounds(68, 444, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JButton btnSkip = new JButton("Skip");
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				address ad1 = new address();
				ad1.NewScreen();
			}
		});
		btnSkip.setBounds(253, 444, 117, 29);
		frame.getContentPane().add(btnSkip);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lrun.addhport(StartApp.uname.getText(), e_hport.getText());
				address ad2 = new address();
				ad2.NewScreen();
			}
		});
		btnNext.setBounds(440, 444, 117, 29);
		frame.getContentPane().add(btnNext);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/Omesh/Downloads/flight.jpg"));
		lblNewLabel.setBounds(0, 0, 750, 578);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeport window = new homeport();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}

}