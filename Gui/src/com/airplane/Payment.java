package com.airplane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Payment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	private final String url = "jdbc:postgresql://localhost/projtest2";
    String user = "admin";
    String password = "admin";
    public Connection connect() throws SQLException{
    	Connection conn = null;
    	Scanner u = new Scanner(System.in);
    	Scanner p = new Scanner(System.in);
    	
    	user = "admin";
    	password = "admin";
    	conn = DriverManager.getConnection(url, user, password);
    	
    	return conn;
    }
	
    public void BookFlights(int f_date, int flight_num, String airline_id, int no_seatsE, int no_seatsF){
    	String SQL = "SELECT *"
    			+ "FROM Flight"
    			+ "WHERE airline_id = ?"
    			+ "and flight_num = ?"
    			+ "and f_date = ? " ;
    	
    	String SQL1 ="INSERT INTO booked_flight ("
    			+ airline_id
    			+ ", "
    			+ flight_num
    			+ ", "
    			+ f_date
    			+ ",depart_airport, dest_airport,depart_time,arrival_time, "
    			+ no_seatsE
    			+ ", "
    			+ no_seatsF
    			+ ", email_id)";
    	
    	
    	try(Connection conn = this.connect(); 
    	PreparedStatement mystmt = conn.prepareStatement(SQL)){
    		

    		mystmt.setInt(3, f_date);
    		mystmt.setInt(2, flight_num);
    		mystmt.setString(1, airline_id);
    	
    		ResultSet rs = mystmt.executeQuery();

    		while(rs.next()) {
    			//System.out.println("Error?");
    			String str = "\n=======================================================";

    			str = str + "\nAirline: " + rs.getString("airline_id");
    			str = str + "\nFlight No.: " + rs.getInt("flight_num");
    			str = str + "\nFlight Date: " + rs.getDate("f_date");
    			str = str + "\nDepart Airport: " + rs.getString("depart_airport");
    			str = str + "\nDestination Airport: " + rs.getString("dest_airport");
    			str = str + "\nDeparture: " + rs.getTime("depart_time");
    			str = str + "\nArrival: " + rs.getTime("arrival_time");
    			str = str + "\nEconomic Seats: " + rs.getInt("num_ec_seats");
    			str = str + "\nFirst Class Seats: " + rs.getInt("num_fc_seats");
    			
    			

    			System.out.println(str);
    			duration(rs.getString("airline_id"), rs.getInt("flight_num"), rs.getDate("f_date"));
    			getPrice(rs.getString("airline_id"), rs.getInt("flight_num"), rs.getDate("f_date"));
    			System.out.println("=======================================================");
    		}
    		
    		try(PreparedStatement mystmt2 = conn.prepareStatement(SQL1)){
    		    		//System.out.println("Here");

    		    		mystmt2.setString(1,rs.getString("depart_airport"));
    		    		mystmt2.setString(2,rs.getString("dest_airport"));
    		    		mystmt2.setString(3,rs.getString("depart_time"));
    		    		mystmt2.setString(3,rs.getString("arrival_time"));
    		    		
    		    	} catch (SQLException e) {
    		            System.out.println(e.getMessage());
    		        }
    		
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
  
    public String duration(String cA, int cFn, Date cFd){
    	String SQL = "SELECT arrival_time-depart_time AS duration FROM flight where flight.airline_id = ? and flight.flight_num = ? and flight.f_date = ?";
    	String str = "";
    	try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)){
    		//System.out.println("Here");
    		pstmt.setString(1, cA);
    		//System.out.println("There");
    		pstmt.setInt(2, cFn);
    		//System.out.println("Everywhere");
    		pstmt.setDate(3, cFd);
    		ResultSet rs = pstmt.executeQuery();

    		while(rs.next()) {
    			//System.out.println("Error?");
    			System.out.println("Flight Duration (HH:MM:SS) : "+rs.getString("duration"));
    			str = str +"Flight Duration(HH:MM:SS): "+rs.getString("duration");
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	return str;
    }
    public String getPrice(String cA, int cFn, Date cFd){
    	String SQL = "Select ec_price,fc_price, ec_price+fc_price as total_price from price where airline_id = ? and flight_num = ? and f_date = ?";
    	String str = "";
    
    	
    	try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)){
    		//System.out.println("Here");
    		pstmt.setString(1, cA);
    		//System.out.println("There");
    		pstmt.setInt(2, cFn);
    		//System.out.println("Everywhere");
    		pstmt.setDate(3, cFd);
    		ResultSet rs = pstmt.executeQuery();

    		while(rs.next()) {
    			//System.out.println("Error?");
    			System.out.println("Economic Seat Price: "+rs.getInt("ec_price"));
    			System.out.println("First Class Seat Price: "+rs.getInt("fc_price"));
    			System.out.println("Total Price (Ec. Price + Fc. Price): "+rs.getInt("total_price"));
    			str = str +"Economic Seat Price: "+rs.getInt("ec_price") + "\n";
    			str = str +"First Class Seat Price: "+rs.getInt("fc_price") + "\n";
    			str = str +"Total Price (Ec. Price + Fc. Price): "+rs.getInt("total_price") + "\n";
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	return str;
    }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
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
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 84, 530, 163);
		frame.getContentPane().add(textArea);
		
		
		JButton btnNewButton = new JButton("Use Existing Credit Card");
		btnNewButton.setBounds(58, 34, 220, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(this.setlistCCinfo(StartApp.uname.getText()));
			}

			private String setlistCCinfo(String au_name) {
				
			    	String SQL = "SELECT cc_number, street_number, street_name, apt_number, city, state, zipcode FROM hascc NATURAL JOIN billing where email_id = ?;";
			    	String r = "";
			    	try (Connection c = DriverManager.getConnection(url, user, password);
			    			PreparedStatement ps = c.prepareStatement(SQL))
			    			{
			    				ps.setString(1, au_name);
								ResultSet rs = ps.executeQuery();
								ResultSetMetaData rsmd = rs.getMetaData();
								
								int columnsNumber = rsmd.getColumnCount();
								
								while (rs.next()) {          
									for(int i = 1 ; i <= columnsNumber; i++){

									      r = r + rs.getString(i) + "            ";
									}
									r = r +"\n";
									//return rs.getString(columnsNumber);
									  System.out.println();
									    }
			    			}
					catch (Exception e10) {
						System.out.println(e10.getMessage());
					}
					return r;
				}
			
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Use New Credit Card");
		btnNewButton_1.setBounds(319, 34, 220, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creditcard ga = new creditcard();
				ga.NewScreen();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnPayNow = new JButton("Pay Now!");
		btnPayNow.setBounds(74, 276, 117, 29);
		btnPayNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			JOptionPane.showMessageDialog(null,  "Success!! " ,"Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frame.getContentPane().add(btnPayNow);
		
		JButton btnBack = new JButton("Main Menu");
		btnBack.setBounds(411, 276, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApp ga = new GUIApp();
				ga.NewScreen();
			}
		});
		frame.getContentPane().add(btnBack);
		
		JButton btnBookAnotherFlight = new JButton("Book Another Flight");
		btnBookAnotherFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightConnections rtn = new FlightConnections();
				rtn.NewScreen();
				
			}
		});
		btnBookAnotherFlight.setBounds(237, 276, 129, 29);
		frame.getContentPane().add(btnBookAnotherFlight);
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}
}