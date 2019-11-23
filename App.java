package com.airplane;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class App {


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

    public void getAirport(){
    	String SQL = "Select airport_id, name from airport";
    	try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)){
    		ResultSet rs = pstmt.executeQuery();

    		System.out.println("\nIATA Code\tAirport Name");
    		System.out.println("---------\t------------");
    		while(rs.next()) {
    			//System.out.println("Error?");
    			String str = "";
    			str = str + rs.getString("airport_id") + "\t\t" + rs.getString("name");

    			System.out.println(str);
    		}
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchFlights(int limit, String dea, String ga){
    	String SQL = "SELECT * from Flight WHERE depart_airport = ? and dest_airport = ? Limit ?";

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


	public static String Eopts()
    {
		Scanner optE = new Scanner(System.in);
		try {
			if(System.in.available()==0) {
				System.out.println("\nDon't worry your still connected to the server!\n");
			}else {
				System.out.println("\nSorry we are having trouble connecting :(\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Please select from the following options by entering the number next to it: ");
        System.out.println("1.Registration");
        System.out.println("2.Payment and Address");
        System.out.println("3.Search For Flight Connections");
        System.out.println("4.Booking Flights");
        System.out.println("5.Manage Bookings");
        System.out.println("6.Log Off");
        System.out.print(": ");

        String chooseE = optE.nextLine();
        System.out.println(" ");
        //optE.close();
        return chooseE;
    }

	public static void main(String[] args) {
		App app = new App();

		Scanner u=new Scanner(System.in);
        Scanner p=new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        String user = "";
        String password = "";
        int accessed=0;
        while(accessed==0)
        {

            //System.out.println("Welcome! Are you a returning customer or employee?");

        	//Enter Username and Password
            System.out.println("Username: ");
        	user = u.next();
        	System.out.println(" ");

    		System.out.println("Password: ");
    		password = p.next();
        	System.out.println(" ");


            if(user.equals("jane")&password.equals("123"))
            {
                accessed=1;
                System.out.println("Welcome "+user+": ");
                int Echoice = Integer.parseInt(Eopts());
                while(Echoice!= 6)
                {
                    switch(Echoice)
                    {
                        case 1:
                        {
                            //Registration
                            System.out.println("Not implemented Yet");
                            Echoice = Integer.parseInt(Eopts());
                            break;
                        }
                        case 2:
                        {
                            //Payment Information and Addresses

                            System.out.println("Not implemented Yet");
                            Echoice = Integer.parseInt(Eopts());
                            break;
                        }
                        case 3:
                        {
                            //Search for Flights

                        	System.out.println("Would you like to look at flights? (Y/N)");
                    		String fq = s.next();

                    		if(fq.compareToIgnoreCase("Y")==0) {
                    			System.out.println("Would you to limit the amount of flights seen? (Y/N)");
                    			String lq = s.next();
                    			int l = 10;
                    			if(lq.compareToIgnoreCase("Y")==0) {
                    				System.out.println("How many flights would you like to see? (Make sure it's less than or equal to 10):");
                    				l = s.nextInt();
                    			}

                    			System.out.println("\nWhich airport are you departing from?");
                    			app.getAirport();
                    			System.out.println("\nPlease type the IATA Code (E.g., ORD): ");
                    			String dea = s.next().toUpperCase();

                    			System.out.println("\nWhich airport are you going to?");
                    			app.getAirport();
                    			System.out.println("\nPlease type the IATA Code (E.g., ORD): ");
                    			String ga = s.next().toUpperCase();

                    			app.searchFlights(l,dea,ga); //limit, departure airport, destination airport

                    			System.out.println("Would you like to look at return flights? (Y/N)");
                    			String rfq = s.next();
                    			if(rfq.compareToIgnoreCase("Y")==0) {
                    				app.searchFlights(l,ga,dea); //switched departure and destination airport: limit, destination airport, departure airport
                    			}else {
                    				System.out.println("Fine. We didn't like you anyways.");
                    			}

                    		}else {
                    			System.out.println("No? Alright, your loss.");
                    		}

                            Echoice = Integer.parseInt(Eopts());
                            break;
                        }
                        case 4:
                        {
                            //Booking Flights

                            System.out.println("Not implemented Yet");
                            Echoice = Integer.parseInt(Eopts());
                            break;
                        }
                        case 5:
                        {
                            //Manage Bookings

                            System.out.println("Not implemented Yet");
                            Echoice = Integer.parseInt(Eopts());
                            break;
                        }
                        default:
                        {
                            System.out.println("Option Not Recognized.");
                            Echoice = Integer.parseInt(Eopts());
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Thanks for visiting. Rerun to start again!");
	}

}
