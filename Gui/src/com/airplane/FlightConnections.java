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
import java.text.SimpleDateFormat;

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
    private JTextField f_date;
    private JTextField flight_num;
    private JTextField Airline_Id;
    private JTextField no_seatsE;
    private JTextField no_seatsF;
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
    			System.out.println("Flight Duration (HH:MM:SS): "+rs.getString("duration"));
    			str = str + "Flight Duration (HH:MM:SS): "+rs.getString("duration");
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
    			str = str + "Economic Seat Price: "+rs.getInt("ec_price") + "\n";
    			str = str + "First Class Seat Price: "+rs.getInt("fc_price") + "\n";
    			str = str + "Total Price (Ec. Price + Fc. Price): "+rs.getInt("total_price") + "\n";
    			
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	return str;
    }
    /*Sorting use this sql Select *,arrival_time-depart_time as duration from flight natural join price order by duration desc;*/

    public String sortByPrice(int limit, String dea, String ga, String ad){ //Duration - H = Highest, L = Lowest
    	String SQL = "";
    	String str = "";
    	String[] r = new String[11];
    	if(ad.compareToIgnoreCase("A")==0) {
    		SQL = "Select *,arrival_time-depart_time as duration, ec_price+fc_price as total_price from flight natural join price where depart_airport = ? and dest_airport = ? order by price asc Limit ?";
    	}else if(ad.compareToIgnoreCase("D")==0) {
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
    		int i = 0;
    		while(rs.next()) {
    			//System.out.println("Error?");
    			str = "\n=======================================================";

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
    			str = str + "\n=======================================================";
    			//
    			r[i] = str;
    			i++;
    		}
    		i = 0;
    		str = "";
    		for(i = 0; i<r.length;i++) {
    			str = str + r[i];
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(str);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    	return str;
    }

    public String sortByDuration(int limit, String dea, String ga, String ad){ //Duration - S = shortest, L = Longest
    	String SQL = "";
    	String str = "";
    	String[] r = new String[11];
    	if(ad.compareToIgnoreCase("A")==0) {
    		SQL = "Select *,arrival_time-depart_time as duration from flight natural join price where depart_airport = ? and dest_airport = ? order by duration asc Limit ?";
    	}else if(ad.compareToIgnoreCase("D")==0) {
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
    		int i = 0;
    		while(rs.next()) {
    			//System.out.println("Error?");
    			str = "\n=======================================================";

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
    			str = str + getPrice(rs.getString("airline_id"), rs.getInt("flight_num"), rs.getDate("f_date"));
    			System.out.println("=======================================================");
    			str = str + "\n=======================================================";

    			r[i] = str;
    			i++;
    		}
    		i = 0;
    		str = "";
    		for(i = 0; i<r.length;i++) {
    			str = str + r[i];
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	return str;
    }

    public String getAirport(){
    	String str = "\nIATA Code\tAirport Name\n------------\t------------\n";
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


    public String searchFlights(int limit, String dea, String ga){
    	String SQL = "SELECT * from Flight WHERE depart_airport = ? and dest_airport = ? and (num_ec_seats != 0 or num_fc_seats != 0) Limit ?";
    	String str = "";
    	String[]r = new String[11];
    	try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)){
    		//System.out.println("Here");

    		pstmt.setString(1, dea);
    		pstmt.setString(2, ga);
    		pstmt.setInt(3, limit);
    		ResultSet rs = pstmt.executeQuery();
    		
    		int i = 0;
    		while(rs.next()) {
    			//System.out.println("Error?");
    			str = "\n=======================================================";

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
    			str = str + duration(rs.getString("airline_id"), rs.getInt("flight_num"), rs.getDate("f_date"));
    			str = str + getPrice(rs.getString("airline_id"), rs.getInt("flight_num"), rs.getDate("f_date"));
    			//System.out.println("=======================================================");
    			str = str + "\n=======================================================";

    			r[i] = str;
    			i++;
    		}
    		i = 0;
    		str = "";
    		for(i = 0; i<r.length;i++) {
    			str = str + r[i];
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
		frame.setBounds(100, 100, 1162, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(0, 0, 117, 33);
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
		lblLimit.setBounds(863, 55, 46, 33);
		lblLimit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblLimit);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(919, 55, 55, 33);
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(spinner);
		
		
		JLabel lblDepartAirport = new JLabel("Depart. Airport: ");
		lblDepartAirport.setBounds(853, 258, 121, 26);
		lblDepartAirport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDepartAirport);
		
		textDepartA = new JTextField();
		textDepartA.setText("IATA Code");
		textDepartA.setToolTipText("");
		textDepartA.setBounds(853, 294, 121, 26);
		frame.getContentPane().add(textDepartA);
		textDepartA.setColumns(10);
		
		
		JLabel lblArrivalAirport = new JLabel("Arrival Airport: ");
		lblArrivalAirport.setBounds(988, 259, 113, 26);
		lblArrivalAirport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblArrivalAirport);
		
		textArrivalA = new JTextField();
		textArrivalA.setText("IATA Code");
		textArrivalA.setBounds(988, 294, 113, 26);
		textArrivalA.setColumns(10);
		frame.getContentPane().add(textArrivalA);
		
				
		JLabel lblOrderBy = new JLabel("Order By: ");
		lblOrderBy.setBounds(863, 346, 82, 33);
		lblOrderBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblOrderBy);
		
		int pd = 0;
		JRadioButton rdbtnPrice = new JRadioButton("Price");
		rdbtnPrice.setBounds(863, 393, 105, 21);
		orderByPD.add(rdbtnPrice);
		frame.getContentPane().add(rdbtnPrice);
		if(rdbtnPrice.isSelected()) {
			pd = 1;
		}
		
		JRadioButton rdbtnDuration = new JRadioButton("Duration");
		rdbtnDuration.setBounds(863, 416, 105, 21);
		orderByPD.add(rdbtnDuration);
		frame.getContentPane().add(rdbtnDuration);
		if(rdbtnDuration.isSelected()) {
			pd = 2;
		}
		
		JLabel lblDescasc = new JLabel("Desc/Asc: ");
		lblDescasc.setBounds(1002, 346, 82, 33);
		lblDescasc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDescasc);
		String ad = "";
		
		JRadioButton rdbtnDescending = new JRadioButton("Descending");
		rdbtnDescending.setBounds(996, 385, 105, 21);
		desc_asc.add(rdbtnDescending);
		frame.getContentPane().add(rdbtnDescending);
		if(rdbtnDescending.isSelected()) {
			ad = "D";
		}
		
		JRadioButton rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setBounds(996, 416, 105, 21);
		desc_asc.add(rdbtnAscending);
		frame.getContentPane().add(rdbtnAscending);
		if(rdbtnAscending.isSelected()) {
			ad = "A";
		}
		
		JLabel lblAvailableAirpots = new JLabel("Available Airpots:");
		lblAvailableAirpots.setBounds(838, 98, 182, 26);
		lblAvailableAirpots.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblAvailableAirpots);
		
		TextArea textAreaAA = new TextArea();
		textAreaAA.setBounds(844, 139, 257, 114);
		textAreaAA.setEditable(false);
		frame.getContentPane().add(textAreaAA);
		textAreaAA.setText(this.getAirport());
		
		JLabel lblReturnFlight = new JLabel("Return Flight?");
		lblReturnFlight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReturnFlight.setBounds(854, 443, 105, 33);
		frame.getContentPane().add(lblReturnFlight);
		boolean rf = false;
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(965, 450, 55, 21);
		frame.getContentPane().add(rdbtnYes);
		if(rdbtnYes.isSelected()) {
			rf = true;
		}
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(1046, 450, 55, 21);
		frame.getContentPane().add(rdbtnNo);
		if(rdbtnNo.isSelected()) {
			rf = false;
		}
		
		JLabel lblFlights = new JLabel("Flights:");
		lblFlights.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFlights.setBounds(39, 55, 88, 33);
		frame.getContentPane().add(lblFlights);
		
		TextArea textArea_Flights = new TextArea();
		textArea_Flights.setEditable(false);
		textArea_Flights.setBounds(39, 98, 407, 150);
		frame.getContentPane().add(textArea_Flights);
		
		
		JLabel lblReturnFlights = new JLabel("Return Flights:");
		lblReturnFlights.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReturnFlights.setBounds(39, 256, 117, 33);
		frame.getContentPane().add(lblReturnFlights);
		
		TextArea textArea_ReturnFlights = new TextArea();
		textArea_ReturnFlights.setEditable(false);
		textArea_ReturnFlights.setBounds(39, 287, 399, 150);
		frame.getContentPane().add(textArea_ReturnFlights);
		
		
		
		JButton btnSubmit = new JButton("Search Flights");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Debugging");
				int limit = (Integer) spinner.getValue();
				String ad = "";
				if(rdbtnAscending.isSelected()) {
					ad = "A";
				}else if(rdbtnDescending.isSelected()) {
					ad = "D";
				}
				String dea = textDepartA.getText().toUpperCase();
				String ga = textArrivalA.getText().toUpperCase();
				
				if(rdbtnPrice.isSelected()) {//price
					System.out.println("Flights");
					textArea_Flights.setText(sortByPrice(limit,dea,ga,ad));
					//System.out.println("Flights:\n"+sortByPrice(limit,dea,ga,ad));
					//System.out.println("Hello");
				}else if (rdbtnDuration.isSelected()) {//duration
					
					textArea_Flights.setText(sortByDuration(limit,dea,ga,ad));
				}else {
					textArea_Flights.setText(searchFlights(limit,dea,ga));
				}
				
				if(rdbtnYes.isSelected()) {
					if(rdbtnPrice.isSelected()) {//price
						System.out.println("Return Flights");
						textArea_ReturnFlights.setText(sortByPrice(limit,ga,dea,ad));
					}else if (rdbtnDuration.isSelected()) {//duration
						
						textArea_ReturnFlights.setText(sortByDuration(limit,ga,dea,ad));
					}else {
						textArea_ReturnFlights.setText(searchFlights(limit,ga,dea));
					}
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(863, 12, 221, 33);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblEnterFlightDate = new JLabel("Enter Flight Date:");
		lblEnterFlightDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterFlightDate.setBounds(477, 111, 113, 33);
		frame.getContentPane().add(lblEnterFlightDate);
		
		JLabel lblEnterFlightNo = new JLabel("Enter Flight No.:");
		lblEnterFlightNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterFlightNo.setBounds(477, 154, 113, 26);
		frame.getContentPane().add(lblEnterFlightNo);
		
		JLabel lblEnterAirlineId = new JLabel("Enter Airline ID:");
		lblEnterAirlineId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterAirlineId.setBounds(477, 190, 113, 26);
		frame.getContentPane().add(lblEnterAirlineId);
		
		JLabel lblEnterNoOf = new JLabel("Enter No. of Economic Seats:");
		lblEnterNoOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterNoOf.setBounds(477, 238, 182, 17);
		frame.getContentPane().add(lblEnterNoOf);
		
		JLabel lblEnterNoOf_1 = new JLabel("Enter No. of First Class Seats:");
		lblEnterNoOf_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterNoOf_1.setBounds(477, 282, 182, 21);
		frame.getContentPane().add(lblEnterNoOf_1);
		
		f_date = new JTextField();
		f_date.setBounds(614, 119, 96, 19);
		frame.getContentPane().add(f_date);
		f_date.setColumns(10);
		
		flight_num = new JTextField();
		flight_num.setBounds(614, 154, 96, 19);
		frame.getContentPane().add(flight_num);
		flight_num.setColumns(10);
		
		Airline_Id = new JTextField();
		Airline_Id.setBounds(614, 195, 96, 19);
		frame.getContentPane().add(Airline_Id);
		Airline_Id.setColumns(10);
		
		no_seatsE = new JTextField();
		no_seatsE.setBounds(658, 238, 96, 19);
		frame.getContentPane().add(no_seatsE);
		no_seatsE.setColumns(10);
		
		no_seatsF = new JTextField();
		no_seatsF.setBounds(658, 284, 96, 19);
		frame.getContentPane().add(no_seatsF);
		no_seatsF.setColumns(10);
		
		JButton btnBookFlight = new JButton("Book Flight");
		btnBookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sf_date = f_date.getText();
				Date df_date = Date.valueOf(sf_date);
				int b = Integer.parseInt(flight_num.getText());
				int c = Integer.parseInt(no_seatsE.getText());
				int d = Integer.parseInt(no_seatsF.getText());
				setBookFlights(df_date, StartApp.uname.getText(),b, Airline_Id.getText(), c, d);
				setEconomicFirst(df_date,b,Airline_Id.getText(),c,d);
				
				Payment mf = new Payment();
				mf.NewScreen(); 
			}

			private void setBookFlights(Date f_date, String email_id,int flight_num, String airline_id, int no_seatsE, int no_seatsF) {
				    	String SQL1 ="INSERT INTO booked_flights Values (?,?,?,?,?,?)";
				    	
				    	
				    	try(Connection conn = connect(); 
				    	PreparedStatement mystmt = conn.prepareStatement(SQL1)){
				    		
				    		mystmt.setString(1, airline_id);
				    		mystmt.setString(2, email_id);
				    		mystmt.setInt(3, flight_num);
				    		mystmt.setDate(4, f_date);
				    		mystmt.setInt(5, no_seatsE);
				    		mystmt.setInt(6, no_seatsF);
				    		
				    		
				    	
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
				    		
				    	} catch (SQLException e) {
				            System.out.println(e.getMessage());
				        }
				    }
			
			
			  public void setEconomicFirst(Date f_date, int flight_num, String airline_id, int no_ec_seats, int no_fc_seats){
			    	String SQL ="Update Flight  "
			    			+ "SET num_ec_seats = num_ec_seats-?,num_fc_seats = num_fc_seats-? "
			    			+ "WHERE airline_id = ? " 
			    			+ "and flight_num = ? "  
			    		    + "and f_date = ? ";

			    	try(Connection conn =connect(); 
			    	PreparedStatement mystmt = conn.prepareStatement(SQL)){
			    		mystmt.setInt(1, no_ec_seats);
			    		mystmt.setInt(2, no_fc_seats);
			    		mystmt.setString(3, airline_id);
			    		mystmt.setInt(4, flight_num);
			    		mystmt.setDate(5, f_date);
			    		
			    		
			    	} catch (SQLException e) {
			            System.out.println(e.getMessage());
			        }
			    }
			
		});
		btnBookFlight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBookFlight.setBounds(508, 342, 194, 44);
		frame.getContentPane().add(btnBookFlight);
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
