package com.airplane;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class App {



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
    
    public void BookFlights(int f_date, int flight_num, String airline_id, int no_seatsE, int no_seatsF){
    	String SQL = "SELECT *"
    			+ "FROM Flight"
    			+ "WHERE airline_id ='?'"
    			+ "and flight_num = '?'"
    			+ "and f_date = '?' " ;
    	
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
    		    		
    		    		ResultSet rs2 = mystmt2.executeQuery();

    		    		
    		    		
    		    	} catch (SQLException e) {
    		            System.out.println(e.getMessage());
    		        }
    		
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    
    public void CancelFlights(int f_date, int flight_num, String airline_id){
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
    		ResultSet rs2 = mystmt2.executeQuery();

    		
    		
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }

} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EconomicFirst(int num_ec_seats,int f_date, int flight_num, String airline_id, int no_ec_seats, int no_fc_seats){
    	String SQL ="Update Flight  "
    			+ "SET num_ec_seats = 'num_ec_seats-?',num_fc_seats = 'num_fc_seats-?"
    			+ "WHERE airline_id ='?'" 
    			+ "and flight_num = '?'"  
    		    + "and f_date = '?' ";

    	try(Connection conn = this.connect(); 
    	PreparedStatement mystmt = conn.prepareStatement(SQL)){
    		mystmt.setInt(1, no_ec_seats);
    		mystmt.setInt(2, no_fc_seats);
    		mystmt.setInt(5, f_date);
    		mystmt.setInt(4, flight_num);
    		mystmt.setString(3, airline_id);
    		
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    	
 
    public int MileageProgram(Date f_date, int flight_num, String airline_id, String email_id,int bonus_miles){
    	String SQL = "SELECT extract(hour from arrival_time - depart_time)*60 as bonus_miles FROM Flight"
    			+ "WHERE airline_id ='?'" 
    			+ "and flight_num = '?'"  
    		    + "and f_date = '?' "
    		    + "and email_id ='?' ";
    	
    	int miles =0;
    	try(Connection conn = this.connect();
    		PreparedStatement mystmt = conn.prepareStatement(SQL)){
    		ResultSet rs = mystmt.executeQuery();
    		
    		miles = rs.getInt("bonus_miles");
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	return miles;
    }
   // int i = this.MilegaeProgram(...);
   // mileageprogramupdate(11-11-11, 1, A, gto, i)
   public void MileageProgramUpdate(Date f_date, int flight_num, String airline_id, String email_id,int bonus_miles){
    	String SQL1 = "INSERT into MileageProgram(email_id, airline_id, bonus_miles) "
    			+ "VALUES(?,?,?)";
    	
    	String SQL2 = "SELECT SUM(bonus_miles)"
				+ "FROM MileageProgram";
    	
    	try(Connection conn = this.connect();
    		PreparedStatement mystmt = conn.prepareStatement(SQL1)){
    		
    		mystmt.setString(2, airline_id);
    		
    		mystmt.setString(1, email_id);
    		
    		mystmt.setInt(3, bonus_miles);
    		
    	
    	try(PreparedStatement mystmt3 = conn.prepareStatement(SQL2)){
    	    	
    		ResultSet rs1 = mystmt3.executeQuery();
    		System.out.println("Bonus Miles : "+ rs1.getInt("bonus_mile"));
    	  
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    	}catch (SQLException e) {
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

                    			System.out.println("\nWould you like to sort the flights by price or duration?(Y/N)");
                    			String spd = s.next();

                    			while(!(spd.compareToIgnoreCase("Y")==0 || spd.compareToIgnoreCase("N")==0)) {
                    				System.out.println("Do not recognize option, try again.");
                    				System.out.println("Would you like to sort the flights by price or duration?(Y/N)");
                    				spd = s.next().toUpperCase();
                    			}

                    			if(spd.compareToIgnoreCase("Y")==0) {
                    				System.out.println("Do you want to sort by price (P) or duration (D)? (P/D)");
                    				String pd = s.next().toUpperCase();
                    				//System.out.println((pd.compareToIgnoreCase("P")==0)); //Checks the condition of while loop

                    				while(!(pd.compareToIgnoreCase("P")==0 || pd.compareToIgnoreCase("D")==0)) {
                    					System.out.println("Do not recognize option, try again.");
                    					System.out.println("Do you want to sort by price (P) or duration (D)? (P/D)");
                    					pd = s.next().toUpperCase();
                    				}

                    				if(pd.compareToIgnoreCase("P")==0) {
                    					System.out.println("Going to sort by price.");
                    					System.out.println("Would you like to see from highest to lowest price (H) or  lowest to highest price (L)? (H/L)");
                    					String plh = s.next().toUpperCase();
                    					while(!(plh.compareToIgnoreCase("H")==0||plh.compareToIgnoreCase("L")==0)) {
                    						System.out.println("Do not recognize option, try again.");
                    						System.out.println("Would you like to see from highest to lowest price (H) or  lowest to highest price (L)? (H/L)");
                    						plh = s.next().toUpperCase();
                    					}

                    					app.sortByPrice(l,dea,ga,plh);

                    					System.out.println("\nWould you like to look at return flights? (Y/N)");
                    					String rfq = s.next();
                    					while(!(rfq.compareToIgnoreCase("Y")==0 || rfq.compareToIgnoreCase("N")==0)) {
                    						System.out.println("Do not recognize option, try again.");
                    						System.out.println("Would you like to look at return flights? (Y/N)");
                    						rfq = s.next().toUpperCase();
                    					}
                    					if(rfq.compareToIgnoreCase("Y")==0) {
                    						app.sortByPrice(l,ga,dea,plh);//switched departure and destination airport: limit, destination airport, departure airport
                    					}else {
                    						System.out.println("Fine. We didn't like you anyways.");
                    					}

                    				}else if(pd.compareToIgnoreCase("D")==0){
                    					System.out.println("Going to sort by duration.");
                    					System.out.println("Would you like to see from longest to shortest duration (L) or  shortest to longest duration (S)? (L/S)");
                    					String dsl = s.next().toUpperCase();
                    					while(!(dsl.compareToIgnoreCase("L")==0||dsl.compareToIgnoreCase("S")==0)) {
                    						System.out.println("Do not recognize option, try again.");
                    						System.out.println("Would you like to see from longest to shortest duration (L) or  shortest to longest duration (S)? (L/S)");
                    						dsl = s.next().toUpperCase();
                    					}

                    					app.sortByDuration(l,dea,ga,dsl);

                    					System.out.println("\nWould you like to look at return flights? (Y/N)");
                    					String rfq = s.next();
                    					while(!(rfq.compareToIgnoreCase("Y")==0 || rfq.compareToIgnoreCase("N")==0)) {
                    						System.out.println("Do not recognize option, try again.");
                    						System.out.println("Would you like to look at return flights? (Y/N)");
                    						rfq = s.next().toUpperCase();
                    					}
                    					if(rfq.compareToIgnoreCase("Y")==0) {
                    						app.sortByDuration(l,ga,dea,dsl);//switched departure and destination airport: limit, destination airport, departure airport
                    					}else {
                    						System.out.println("Fine. We didn't like you anyways.");
                    					}
                    				}
                    			}
                    			else {

                    				app.searchFlights(l,dea,ga); //limit, departure airport, destination airport

                    				System.out.println("\nWould you like to look at return flights? (Y/N)");
                    				String rfq = s.next();
                    				while(!(rfq.compareToIgnoreCase("Y")==0 || rfq.compareToIgnoreCase("N")==0)) {
                    					System.out.println("Do not recognize option, try again.");
                    					System.out.println("Would you like to look at return flights? (Y/N)");
                    					rfq = s.next().toUpperCase();
                    				}
                    				if(rfq.compareToIgnoreCase("Y")==0) {
                    					app.searchFlights(l,ga,dea); //switched departure and destination airport: limit, destination airport, departure airport
                    				}else {
                    					System.out.println("Fine. We didn't like you anyways.");
                    				}
                    			}
                    			/*Sorting use this sql Select *,arrival_time-depart_time as duration from flight natural join price order by duration desc;*/

                    			System.out.println("Search completes. Did you find the flights you were looking for?(Y/N)");
                    			String okay = s.next().toUpperCase();
                    			if(okay.compareToIgnoreCase("Y")==0) {
                    				System.out.println("That amazing! Remember to note down the Airline, Flight No., and Flight Date of the flight(s) you are going to book!");
                    			}else if(okay.compareTo("N")==0) {
                    				System.out.println("I'm sorry. We currently do not a flight for that destination.");
                    			}else {
                    				System.out.println("What's so hard about typing Y or N?\nGoodbye.");
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
