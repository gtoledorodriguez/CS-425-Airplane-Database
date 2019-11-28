package com.airplane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MileageProgram {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	private final String url = "jdbc:postgresql://localhost/projtest2";
    String user = "admin";
    String password = "admin";
    private JTextField textField;
    public Connection connect() throws SQLException{
    	Connection conn = null;
    	Scanner u = new Scanner(System.in);
    	Scanner p = new Scanner(System.in);
    	
    	user = "admin";
    	password = "admin";
    	conn = DriverManager.getConnection(url, user, password);
    	
    	return conn;
    }
    
 
   // int i = this.MilegaeProgram(...);
   // mileageprogramupdate(11-11-11, 1, A, gto, i)
    public void MileageProgramUpdate(String airline_id, String email_id){
    	String SQL1 = "INSERT into MilageProgram(email_id, airline_id)"
    			+ "SELECT email_id,airline_id From Booked_Flights where email_id = ? and airline_id = ?";
    	
    	
    	String SQL2 ="UPDATE MilageProgram Set bonus_miles = extract(hour FROM (arrival_time-depart_time)*60) FROM Flight WHERE email_id = ? ";
    	
    	try(Connection conn = this.connect();
    		PreparedStatement mystmt = conn.prepareStatement(SQL1)){
    		mystmt.setString(1, email_id);
    		mystmt.setString(2, airline_id);
    		
    		ResultSet rs = mystmt.executeQuery();
    		String miles = "";
    		try(PreparedStatement mystmt1 = conn.prepareStatement(SQL2)){
        		mystmt1.setString(1, email_id);
        		ResultSet rs1 = mystmt1.executeQuery();
        		
        		while(rs1.next()) {
        			miles = rs1.getString("bonus_miles");
        		}
        		
        	}catch (SQLException e) {
                System.out.println(e.getMessage());
            }	
    	
    	}catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MileageProgram window = new MileageProgram();
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
	public MileageProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 441, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMileageProgram = new JLabel("Mileage Program by Airline");
		lblMileageProgram.setBounds(84, 24, 259, 44);
		lblMileageProgram.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 20));
		frame.getContentPane().add(lblMileageProgram);
		
		JLabel lblTotalBonusMiles = new JLabel("Total Bonus Miles:");
		lblTotalBonusMiles.setBounds(20, 143, 117, 33);
		frame.getContentPane().add(lblTotalBonusMiles);
		
		JButton btnBack = new JButton("Main Menu");
		btnBack.setBounds(62, 202, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApp ga = new GUIApp();
				ga.NewScreen();
			}
		});
		frame.getContentPane().add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(190, 202, 117, 29);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApp app = new GUIApp();
				app.NewScreen();
				
			}
		});
		frame.getContentPane().add(btnExit);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(162, 147, 145, 33);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setBounds(315, 145, 83, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MileageProgramUpdate(textField.getText(),StartApp.uname.getText());
				String mi = setMileageProgram(StartApp.uname.getText());
				System.out.println("Miles: " + mi);
				textArea.setText(mi);
			
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(161, 102, 146, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterAirlineId = new JLabel("Enter Airline ID:");
		lblEnterAirlineId.setBounds(20, 104, 102, 29);
		frame.getContentPane().add(lblEnterAirlineId);
		
		
		
	}

	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MileageProgram window = new MileageProgram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}
	
	private String setMileageProgram(String email_id) {
		String SQL = "SELECT sum(bonus_miles) as bonus_miles from MilageProgram"
    		    + " where email_id = ? ";

    	String miles ="";
    	try(Connection conn = this.connect();
    		PreparedStatement mystmt = conn.prepareStatement(SQL)){
    		
    		mystmt.setString(1, email_id);
    		ResultSet rs = mystmt.executeQuery();
    		
    		while(rs.next()) {
    			miles = rs.getString("bonus_miles");
    		}
    		
    		System.out.println("Bonus Miles : "+ rs.getString("bonus_miles"));
    	}catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	return miles;
	}
}