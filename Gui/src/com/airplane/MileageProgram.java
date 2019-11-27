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

public class MileageProgram {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	private final String url = "jdbc:postgresql://localhost/demo";
    String user = "postgres";
    String password = "Zion@123";
    public Connection connect() throws SQLException{
    	Connection conn = null;
    	Scanner u = new Scanner(System.in);
    	Scanner p = new Scanner(System.in);
    	
    	user = "admin";
    	password = "admin";
    	conn = DriverManager.getConnection(url, user, password);
    	
    	return conn;
    }
    
    public int MileageProgram(Date f_date, int flight_num, String airline_id, String email_id,int bonus_miles){
    	String SQL = "SELECT extract(hour from arrival_time - depart_time)*60 as bonus_miles FROM Flight"
    			+ "WHERE airline_id ='?'" 
    			+ "and flight_num = '?'"  
    		    + "and f_date = '?' "
    		    + "and email_id ='?' ";
		
		String SQL2 = "SELECT SUM(bonus_miles)"
				+ "FROM MileageProgram";
		
    	int miles =0;
    	try(Connection conn = this.connect();
    		PreparedStatement mystmt = conn.prepareStatement(SQL)){
    		ResultSet rs = mystmt.executeQuery();
 		miles = rs.getInt("bonus_miles");
 		
 		try(PreparedStatement mystmt3 = conn.prepareStatement(SQL2)){
	    	
    		ResultSet rs1 = mystmt3.executeQuery();
    		System.out.println("Bonus Miles : "+ rs1.getString("bonus_mile"));
    	  
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	return miles;
    }
   // int i = this.MilegaeProgram(...);
   // mileageprogramupdate(11-11-11, 1, A, gto, i)
    public void MileageProgramUpdate(String airline_id, String email_id,int bonus_miles){
    	String SQL1 = "INSERT into MileageProgram(email_id, airline_id, bonus_miles) "
    			+ "VALUES(?,?,?)";
    	
    	try(Connection conn = this.connect();
    		PreparedStatement mystmt = conn.prepareStatement(SQL1)){
    		
    		mystmt.setString(2, airline_id);
    		
    		mystmt.setString(1, email_id);
    		
    		mystmt.setInt(3, bonus_miles);
    		
    	
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
		frame.setBounds(100, 100, 421, 217);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMileageProgram = new JLabel("Mileage Program");
		lblMileageProgram.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 20));
		lblMileageProgram.setBounds(102, 23, 154, 44);
		frame.getContentPane().add(lblMileageProgram);
		
		JLabel lblTotalBonusMiles = new JLabel("Total Bonus Miles:");
		lblTotalBonusMiles.setBounds(61, 79, 124, 33);
		frame.getContentPane().add(lblTotalBonusMiles);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(185, 82, 130, 26);
		frame.getContentPane().add(textField);
		//textField.setText(this.setMileageProgram());
		
		JButton btnBack = new JButton("Main Menu");
		btnBack.setBounds(0, 0, 117, 33);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApp ga = new GUIApp();
				ga.NewScreen();
			}
		});
		btnBack.setBounds(61, 127, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnExit.setBounds(196, 127, 117, 29);
		frame.getContentPane().add(btnExit);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(319, 82, 83, 29);
		frame.getContentPane().add(btnNewButton);
	}
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageFlights window = new ManageFlights();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private int setMileageProgram() {
		String SQL = "SELECT extract(hour from arrival_time - depart_time)*60 as bonus_miles FROM Flight"
    			+ "WHERE airline_id ='?'" 
    			+ "and flight_num = '?'"  
    		    + "and f_date = '?' "
    		    + "and email_id ='?' ";
		
		String SQL2 = "SELECT SUM(bonus_miles)"
				+ "FROM MileageProgram";
		
    	int miles =0;
    	try(Connection conn = this.connect();
    		PreparedStatement mystmt = conn.prepareStatement(SQL)){
    		ResultSet rs = mystmt.executeQuery();
 		miles = rs.getInt("bonus_miles");
 		
 		try(PreparedStatement mystmt3 = conn.prepareStatement(SQL2)){
	    	
    		ResultSet rs1 = mystmt3.executeQuery();
    		System.out.println("Bonus Miles : "+ rs1.getString("bonus_mile"));
    	  
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	return miles;
	}
}