import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class homepage {

	private JFrame HomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage window = new homepage();
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
	public homepage() {
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
		
		JLabel msglbl = new JLabel("Hello " +supage.uname.getText() + ",");
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
		btnSearchFlight.setBounds(238, 148, 207, 55);
		btnSearchFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		HomePage.getContentPane().add(btnSearchFlight);
		
		JButton btnbookFlight = new JButton("BookFlight");
		btnbookFlight.setBounds(238, 240, 207, 55);
		btnbookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		HomePage.getContentPane().add(btnbookFlight);
		
		JButton btnManageFlights = new JButton("Manage Flights");
		btnManageFlights.setBounds(238, 329, 207, 55);
		HomePage.getContentPane().add(btnManageFlights);
		
		JButton button = new JButton("Log Off");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supage sp2 = new supage();
				sp2.NewScreen();
			}
		});
		button.setBounds(238, 426, 207, 55);
		HomePage.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/Omesh/Downloads/flight.jpg"));
		lblNewLabel.setBounds(0, 0, 750, 578);
		HomePage.getContentPane().add(lblNewLabel);
		
		
		
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage window = new homepage();
					window.HomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}
}