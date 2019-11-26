package com.airplane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import java.awt.TextArea;

public class FlightConnections {

	private JFrame frame;
	private JTextField textDepartA;
	private JTextField textArrivalA;
	private final ButtonGroup orderByPD = new ButtonGroup();
	private final ButtonGroup desc_asc = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	private final String url = "jdbc:postgresql://localhost/projtest2";
    String user = "";
    String password = "";
    public Connection connect() throws SQLException{
    	Connection conn = null;
    	Scanner u = new Scanner(System.in);
    	Scanner p = new Scanner(System.in);
    	/*
    	System.out.println("Username: ");
    	user = u.next();
    	System.out.println(" ");

		System.out.println("Password: ");
		password = p.next();
    	System.out.println(" ");
    	*/
    	user = "admin";
    	password = "admin";
    	conn = DriverManager.getConnection(url, user, password);
    	//System.out.println("Connected to the PostgreSQL server successfully.");

        return conn;
    }
    
    public void duration(String cA, int cFn, Date cFd){
    	String SQL = "SELECT arrival_time-depart_time AS duration FROM flight where flight.airline_id = ? and flight.flight_num = ? and flight.f_date = ?";
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
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getPrice(String cA, int cFn, Date cFd){
    	String SQL = "Select ec_price,fc_price, ec_price+fc_price as total_price from price where airline_id = ? and flight_num = ? and f_date = ?";
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
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*Sorting use this sql Select *,arrival_time-depart_time as duration from flight natural join price order by duration desc;*/

    public void sortByPrice(int limit, String dea, String ga, String ad){ //Duration - H = Highest, L = Lowest
    	String SQL = "";
    	if(ad.compareToIgnoreCase("L")==0) {
    		SQL = "Select *,arrival_time-depart_time as duration, ec_price+fc_price as total_price from flight natural join price where depart_airport = ? and dest_airport = ? order by price asc Limit ?";
    	}else if(ad.compareToIgnoreCase("H")==0) {
    		SQL = "Select *,arrival_time-depart_time as duration, ec_price+fc_price as total_price from flight natural join price where depart_airport = ? and dest_airport = ? order by price desc Limit ?";
    	}else {//Should never come here, will output nothing
    		SQL = "Select *,arrival_time-depart_time as duration from flight natural join price where depart_airport = ? and dest_airport = ? Limit ?";
    	}


    	try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)){
    		//System.out.println("Here");

    		pstmt.setString(1, dea);
    		pstmt.setString(2, ga);
    		pstmt.setInt(3, limit);
    		ResultSet rs = pstmt.executeQuery();

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
    			str = str + "\nFlight Duration (HH:MM:SS) : "+rs.getString("duration");
    			str = str + "\nEconomic Seat Price: "+rs.getInt("ec_price");
    			str = str + "\nFirst Class Seat Price: "+rs.getInt("fc_price");
    			str = str + "\nTotal Price (Ec. Price + Fc. Price): "+rs.getInt("total_price");

    			System.out.println(str);
    			System.out.println("=======================================================");
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sortByDuration(int limit, String dea, String ga, String ad){ //Duration - S = shortest, L = Longest
    	String SQL = "";
    	if(ad.compareToIgnoreCase("S")==0) {
    		SQL = "Select *,arrival_time-depart_time as duration from flight natural join price where depart_airport = ? and dest_airport = ? order by duration asc Limit ?";
    	}else if(ad.compareToIgnoreCase("L")==0) {
    		SQL = "Select *,arrival_time-depart_time as duration from flight natural join price where depart_airport = ? and dest_airport = ? order by duration desc Limit ?";
    	}else {//Should never come here, will output nothing
    		SQL = "Select *,arrival_time-depart_time as duration from flight natural join price where depart_airport = ? and dest_airport = ? Limit ?";
    	}


    	try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)){
    		//System.out.println("Here");

    		pstmt.setString(1, dea);
    		pstmt.setString(2, ga);
    		pstmt.setInt(3, limit);
    		ResultSet rs = pstmt.executeQuery();

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
    			str = str + "\nFlight Duration (HH:MM:SS) : "+rs.getString("duration");

    			System.out.println(str);
    			getPrice(rs.getString("airline_id"), rs.getInt("flight_num"), rs.getDate("f_date"));
    			System.out.println("=======================================================");
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getAirport(){
    	String str = "\nIATA Code\tAirport Name\n---------\t------------\n";
    	String SQL = "Select airport_id, name from airport";
    	try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)){
    		ResultSet rs = pstmt.executeQuery();

    		//System.out.println("\nIATA Code\tAirport Name");
    		//System.out.println("---------\t------------");
    		while(rs.next()) {
    			//System.out.println("Error?");
    			
    			str = str + rs.getString("airport_id") + "\t\t" + rs.getString("name") + "\n";
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	return str;
    }


    public void searchFlights(int limit, String dea, String ga){
    	String SQL = "SELECT * from Flight WHERE depart_airport = ? and dest_airport = ? and (num_ec_seats != 0 or num_fc_seats != 0) Limit ?";

    	try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)){
    		//System.out.println("Here");

    		pstmt.setString(1, dea);
    		pstmt.setString(2, ga);
    		pstmt.setInt(3, limit);
    		ResultSet rs = pstmt.executeQuery();

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
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightConnections window = new FlightConnections();
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
	public FlightConnections() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(819, 0, 117, 33);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApp ga = new GUIApp();
				ga.NewScreen();
			}
		});
		frame.getContentPane().setLayout(null);
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnMainMenu);
		
		JLabel lblLimit = new JLabel("Limit: ");
		lblLimit.setBounds(651, 55, 46, 33);
		lblLimit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblLimit);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(707, 55, 55, 33);
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(spinner);
		int limit = (Integer) spinner.getValue();
		
		JLabel lblDepartAirport = new JLabel("Depart. Airport: ");
		lblDepartAirport.setBounds(651, 259, 121, 26);
		lblDepartAirport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDepartAirport);
		
		textDepartA = new JTextField();
		textDepartA.setBounds(651, 294, 121, 26);
		frame.getContentPane().add(textDepartA);
		textDepartA.setColumns(10);
		String dea = textDepartA.getText();
		
		JLabel lblArrivalAirport = new JLabel("Arrival Airport: ");
		lblArrivalAirport.setBounds(795, 259, 113, 26);
		lblArrivalAirport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblArrivalAirport);
		
		textArrivalA = new JTextField();
		textArrivalA.setBounds(795, 294, 113, 26);
		textArrivalA.setColumns(10);
		frame.getContentPane().add(textArrivalA);
		String ga = textArrivalA.getText();
				
		JLabel lblOrderBy = new JLabel("Order By: ");
		lblOrderBy.setBounds(651, 346, 82, 33);
		lblOrderBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblOrderBy);
		
		int[] pd = {0};
		JRadioButton rdbtnPrice = new JRadioButton("Price");
		rdbtnPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pd[0]+1;
			}
		});
		
		rdbtnPrice.setBounds(651, 385, 105, 21);
		orderByPD.add(rdbtnPrice);
		frame.getContentPane().add(rdbtnPrice);
		
		
		JRadioButton rdbtnDuration = new JRadioButton("Duration");
		rdbtnDuration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pd = 2;
			}
		});
		rdbtnDuration.setBounds(651, 416, 105, 21);
		orderByPD.add(rdbtnDuration);
		frame.getContentPane().add(rdbtnDuration);
		
		JLabel lblDescasc = new JLabel("Desc/Asc: ");
		lblDescasc.setBounds(776, 346, 82, 33);
		lblDescasc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDescasc);
		String ad = "";
		
		JRadioButton rdbtnDescending = new JRadioButton("Descending");
		rdbtnDescending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad = "D";
			}
		});
		rdbtnDescending.setBounds(776, 385, 105, 21);
		desc_asc.add(rdbtnDescending);
		frame.getContentPane().add(rdbtnDescending);
		
		JRadioButton rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setBounds(776, 416, 105, 21);
		desc_asc.add(rdbtnAscending);
		frame.getContentPane().add(rdbtnAscending);
		
		JLabel lblAvailableAirpots = new JLabel("Available Airpots:");
		lblAvailableAirpots.setBounds(651, 98, 182, 26);
		lblAvailableAirpots.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblAvailableAirpots);
		
		TextArea textAreaAA = new TextArea();
		textAreaAA.setBounds(651, 139, 257, 114);
		textAreaAA.setEditable(false);
		frame.getContentPane().add(textAreaAA);
		textAreaAA.setText(this.getAirport());
		
		JLabel lblReturnFlight = new JLabel("Return Flight?");
		lblReturnFlight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReturnFlight.setBounds(651, 442, 105, 33);
		frame.getContentPane().add(lblReturnFlight);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(753, 450, 55, 21);
		frame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(826, 450, 55, 21);
		frame.getContentPane().add(rdbtnNo);
		
		JLabel lblFlights = new JLabel("Flights:");
		lblFlights.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFlights.setBounds(84, 55, 88, 33);
		frame.getContentPane().add(lblFlights);
		
		TextArea textArea_Flights = new TextArea();
		textArea_Flights.setEditable(false);
		textArea_Flights.setBounds(77, 94, 440, 150);
		frame.getContentPane().add(textArea_Flights);
		
		JLabel lblReturnFlights = new JLabel("Return Flights:");
		lblReturnFlights.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReturnFlights.setBounds(84, 250, 117, 33);
		frame.getContentPane().add(lblReturnFlights);
		
		TextArea textArea_ReturnFlights = new TextArea();
		textArea_ReturnFlights.setEditable(false);
		textArea_ReturnFlights.setBounds(77, 289, 440, 150);
		frame.getContentPane().add(textArea_ReturnFlights);
	}

	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightConnections window = new FlightConnections();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
