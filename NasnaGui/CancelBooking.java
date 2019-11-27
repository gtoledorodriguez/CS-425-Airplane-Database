import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class CancelBooking {

	private JFrame frame;
	private JTextField FDateText;

	/**
	 * Launch the application.
	 */
	private final String url = "jdbc:postgresql://localhost/demo";
    String user = "";
    String password = "";
    String title = "Confirmation";
    private JTextField AirlineText;
    private JTextField FlightNumTxt;
    public Connection connect() throws SQLException{
    	Connection conn = null;
    	Scanner u = new Scanner(System.in);
    	Scanner p = new Scanner(System.in);
    	
    	user = "admin";
    	password = "admin";
    	conn = DriverManager.getConnection(url, user, password);
    	
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
    
    public String setPrintFlights(int f_date, int flight_num, String airline_id){
    
    String SQL ="SELECT * FROM booked_flight  "
			+ "WHERE airline_id ='?'"
			+ "and flight_num = '?'"
			+ "and f_date = '?' ";
    String str = "\n=======================================================";
    try(Connection conn = this.connect(); 
        	PreparedStatement mystmt = conn.prepareStatement(SQL)){
        		//System.out.println("Here");

        		mystmt.setInt(3, f_date);
        		mystmt.setInt(2, flight_num);
        		mystmt.setString(1, airline_id);
        		ResultSet rs = mystmt.executeQuery();
        		while(rs.next()) {
        			//System.out.println("Error?");
        			

        			str = str + "\nAirline: " + rs.getString("airline_id");
        			str = str + "\nFlight No.: " + rs.getInt("flight_num");
        			str = str + "\nFlight Date: " + rs.getDate("f_date");
        			str = str + "\nDepart Airport: " + rs.getString("depart_airport");
        			str = str + "\nDestination Airport: " + rs.getString("dest_airport");
        			str = str + "\nDeparture: " + rs.getTime("depart_time");
        			str = str + "\nArrival: " + rs.getTime("arrival_time");
        			str = str + "\nEconomic Seats: " + rs.getInt("no_seatsE");
        			str = str + "\nFirst Class Seats: " + rs.getInt("no_seatsF");

        			System.out.println(str);
        			duration(rs.getString("airline_id"), rs.getInt("flight_num"), rs.getDate("f_date"));
        			getPrice(rs.getString("airline_id"), rs.getInt("flight_num"), rs.getDate("f_date"));
        			System.out.println("=======================================================");
        		}
        		
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
	
    return str;
    
    }
	public void setCancelFlights(int f_date, int flight_num, String airline_id){
		
    	String SQL ="DELETE FROM booked_flight  "
    			+ "WHERE airline_id ='?'"
				+ "and flight_num = '?'"
				+ "and f_date = '?' ";
    	String SQL1 ="Update Flight  "
    			+ "SET num_ec_seats = 'num_ec_seats+?',num_fc_seats = 'num_fc_seats+?"
    			+ "WHERE airline_id ='?'" 
    			+ "and flight_num = '?'"  
    		    + "and f_date = '?' ";

    	try(Connection conn = this.connect(); 
    	PreparedStatement mystmt = conn.prepareStatement(SQL)){
    		//System.out.println("Here");

    		mystmt.setInt(3, f_date);
    		mystmt.setInt(2, flight_num);
    		mystmt.setString(1, airline_id);
    		
    		

  
    	try(PreparedStatement mystmt2 = conn.prepareStatement(SQL1)){
    		//System.out.println("Here");
    		mystmt2.setInt(3, f_date);
    		mystmt2.setInt(2, flight_num);
    		mystmt2.setString(1, airline_id);
    	
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }

} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelBooking window = new CancelBooking();
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
	public CancelBooking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterDateOf = new JLabel("Enter Date of Flight:");
		lblEnterDateOf.setBounds(31, 33, 141, 26);
		frame.getContentPane().add(lblEnterDateOf);
		
		FDateText = new JTextField();
		FDateText.setBounds(184, 33, 130, 26);
		frame.getContentPane().add(FDateText);
		FDateText.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(43, 210, 433, 153);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(359, 158, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(FDateText.getText());
				int b = Integer.parseInt(FlightNumTxt.getText());
				textArea.setText(setPrintFlights(a,b,AirlineText.getText()));
			
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel Booking");
		btnNewButton_1.setBounds(83, 375, 141, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(FDateText.getText());
				int b = Integer.parseInt(FlightNumTxt.getText());
				setCancelFlights(a,b,AirlineText.getText());
				
			JOptionPane.showMessageDialog(null,  "Booking Cancelled! " ,title, JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnBack = new JButton("Main Menu");
		btnBack.setBounds(248, 375, 141, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApp ga = new GUIApp();
				ga.NewScreen();
			}
		});
		frame.getContentPane().add(btnBack);
		
		AirlineText = new JTextField();
		AirlineText.setBounds(184, 158, 130, 26);
		frame.getContentPane().add(AirlineText);
		AirlineText.setColumns(10);
		
		FlightNumTxt = new JTextField();
		FlightNumTxt.setBounds(184, 98, 130, 26);
		frame.getContentPane().add(FlightNumTxt);
		FlightNumTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Flight Number:");
		lblNewLabel.setBounds(31, 103, 130, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Airline ID:");
		lblNewLabel_1.setBounds(31, 163, 123, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
