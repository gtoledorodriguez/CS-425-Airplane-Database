

import java.io.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.math.BigInteger;
public class App {


	private final static String url = "jdbc:postgresql://localhost/finalprojectdatab?user=postgres&password=Mee9623274900";
    static String user = "";
    static String password = "";
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
    	user = "postgres";
    	password = "Mee9623274900";
    	conn = DriverManager.getConnection(url, user, password);
    	/*System.out.println("Connected to the PostgreSQL server successfully.");*/

        return conn;

    }

    public void addcustomer(String uname, String pwd, int _age, String f_name, String m_name, String l_name) {
    	try (Connection conn = this.connect();
    			CallableStatement addcust1 = conn.prepareCall("call addcust(?, ?, ?, ?, ?, ?)")
    			)
    	{
    		addcust1.setString(1, uname);
    		addcust1.setString(2, pwd);
    		addcust1.setInt(3, _age);
    		addcust1.setString(4, f_name);
    		addcust1.setString(5, m_name);
    		addcust1.setString(6, l_name);
    		addcust1.execute();
    	}catch (SQLException e1) {
    		System.out.println(e1.getMessage());
    	}

    }

    public void addaddress(String uname, String str_num, String str_name, String ap_num, String l_city, String l_state, String zippcode) {
    	try (Connection conn = this.connect();
    			CallableStatement addaddr1 = conn.prepareCall("call addaddr(?, ?, ?, ?, ?, ?, ?)")
    			)
    	{
    		addaddr1.setString(1, uname);
    		addaddr1.setString(2, str_num);
    		addaddr1.setString(3, str_name);
    		addaddr1.setString(4, ap_num);
    		addaddr1.setString(5, l_city);
    		addaddr1.setString(6, l_state);
    		addaddr1.setString(7, zippcode);
    		addaddr1.execute();
    	}catch (SQLException e2) {
    		System.out.println(e2.getMessage());
    	}

    }

    public void addCredit(long ccnum, Integer CVV, Integer e_month, Integer e_year, String uname, String str_num, String str_name, String ap_num, String l_city, String l_state, String zippcode) {
    	try (Connection conn = this.connect();
    			CallableStatement addcred = conn.prepareCall("call addcc(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
    			)
    	{
    		addcred.setLong(1, ccnum);
    		addcred.setInt(2, CVV);
    		addcred.setInt(3, e_month);
    		addcred.setInt(4, e_year);
    		addcred.setString(5, uname);
    		addcred.setString(6, str_num);
    		addcred.setString(7, str_name);
    		addcred.setString(8, ap_num);
    		addcred.setString(9, l_city);
    		addcred.setString(10, l_state);
    		addcred.setString(11, zippcode);
    		addcred.execute();
    	}catch (SQLException e3) {
    		System.out.println(e3.getMessage());
    	}

    }

    public void changeaddress(String uname, String o_str_num, String o_str_name, String o_ap_num, String o_l_city, String o_l_state, String o_zippcode, String n_str_num, String n_str_name, String n_ap_num, String n_l_city, String n_l_state, String n_zippcode) {
    	try (Connection conn = this.connect();
    			CallableStatement chgaddr1 = conn.prepareCall("call changeaddr(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
    			)
    	{
    		chgaddr1.setString(1, uname);
    		chgaddr1.setString(2, o_str_num);
    		chgaddr1.setString(3, o_str_name);
    		chgaddr1.setString(4, o_ap_num);
    		chgaddr1.setString(5, o_l_city);
    		chgaddr1.setString(6, o_l_state);
    		chgaddr1.setString(7, o_zippcode);
    		chgaddr1.setString(8, n_str_num);
    		chgaddr1.setString(9, n_str_name);
    		chgaddr1.setString(10, n_ap_num);
    		chgaddr1.setString(11, n_l_city);
    		chgaddr1.setString(12, n_l_state);
    		chgaddr1.setString(13, n_zippcode);
    		chgaddr1.execute();
    	}catch (SQLException e4) {
    		System.out.println(e4.getMessage());
    	}

    }

    public void changecredit(String uname, long o_ccnum, Integer o_CVV, Integer o_e_month, Integer o_e_year, String o_str_num, String o_str_name, String o_ap_num, String o_l_city, String o_l_state, String o_zippcode, long n_ccnum, Integer n_CVV, Integer n_e_month, Integer n_e_year, String n_str_num, String n_str_name, String n_ap_num, String n_l_city, String n_l_state, String n_zippcode) {
    	try (Connection conn = this.connect();
    			CallableStatement chgcred1 = conn.prepareCall("call changecc(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
    			)
    	{
    		chgcred1.setString(1, uname);
    		chgcred1.setLong(2, o_ccnum);
    		chgcred1.setInt(3, o_CVV);
    		chgcred1.setInt(4, o_e_month);
    		chgcred1.setInt(5, o_e_year);
    		chgcred1.setString(6, o_str_num);
    		chgcred1.setString(7, o_str_name);
    		chgcred1.setString(8, o_ap_num);
    		chgcred1.setString(9, o_l_city);
    		chgcred1.setString(10, o_l_state);
    		chgcred1.setString(11, o_zippcode);
    		chgcred1.setLong(12, n_ccnum);
    		chgcred1.setInt(13, n_CVV);
    		chgcred1.setInt(14, n_e_month);
    		chgcred1.setInt(15, n_e_year);
    		chgcred1.setString(16, n_str_num);
    		chgcred1.setString(17, n_str_name);
    		chgcred1.setString(18, n_ap_num);
    		chgcred1.setString(19, n_l_city);
    		chgcred1.setString(20, n_l_state);
    		chgcred1.setString(21, n_zippcode);
    		chgcred1.execute();
    	}catch (SQLException e5) {
    		System.out.println(e5.getMessage());
    	}

    }

    public void remaddress(String uname, String str_num, String str_name, String ap_num, String l_city, String l_state, String zippcode) {
    	try (Connection conn = this.connect();
    			CallableStatement remaddr1 = conn.prepareCall("call removeaddr(?, ?, ?, ?, ?, ?, ?)")
    			)
    	{
    		remaddr1.setString(1, uname);
    		remaddr1.setString(2, str_num);
    		remaddr1.setString(3, str_name);
    		remaddr1.setString(4, ap_num);
    		remaddr1.setString(5, l_city);
    		remaddr1.setString(6, l_state);
    		remaddr1.setString(7, zippcode);
    		remaddr1.execute();
    	}catch (SQLException e6) {
    		System.out.println(e6.getMessage());
    	}

    }

    public void remCC(long ccnum) {
    	try (Connection conn = this.connect();
    			CallableStatement remCC = conn.prepareCall("call deleteCC(?)")
    			)
    	{
    		remCC.setLong(1, ccnum);
    		remCC.execute();
    	}catch (SQLException e7) {
    		System.out.println(e7.getMessage());
    	}

    }

    public void addhport(String uname, String hport) {
    	try (Connection conn = this.connect();
    			CallableStatement addhport1 = conn.prepareCall("call addhomeport(?, ?)")
    			)
    	{
    		addhport1.setString(1, uname);
    		addhport1.setString(2,  hport);
    		addhport1.execute();
    	}catch (SQLException e9) {
    		System.out.println(e9.getMessage());
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
        System.out.println("1.Add HomeAirport");
        System.out.println("2.Add Card or Address");
        System.out.println("3.Update Card or Address");
        System.out.println("4.LogOff");
        System.out.print(": ");

        String chooseE = optE.nextLine();
        System.out.println(" ");
        //optE.close();
        return chooseE;
    }

    public static String upperCaseFirst(String value) {

        // Convert String to char array.
        char[] array = value.toCharArray();
        // Modify first element in array.
        array[0] = Character.toUpperCase(array[0]);
        // Return string.
        return new String(array);
    }

    public static Boolean signin(String u_name, String p_pswd) {
    	String SQL = "SELECT email_id, password FROM customer where email_id = ? AND password = ?;";
    	try (Connection c = DriverManager.getConnection(url, user, password);
    			PreparedStatement ps = c.prepareStatement(SQL))
    			{
					Boolean getin = false;
					ps.setString(1, u_name);
					ps.setString(2, p_pswd);

					ResultSet lgin = ps.executeQuery();

					if(!lgin.next()) {
						System.out.println("Email/Password is Incorrect");
					} else {
						System.out.println("SignIn successful");
						getin = true;
					}
					return getin;
    			}
		catch (Exception e8) {
			System.out.println(e8.getMessage());
			return false;
		}
	}

    @SuppressWarnings("static-access")
	public static void main(String[] args) {
		App app = new App();

		System.out.println("Hello, Welcome to WeFly");

		System.out.println("Please Select What You Would Like to Do");
		System.out.println("1. SignIn");
		System.out.println("2. Register");
		System.out.println("3. Quit Application");
		Scanner ppage = new Scanner(System.in);
		int in_ppage = ppage.nextInt();

		while(!(in_ppage==1 || in_ppage==2 || in_ppage==3)) {
			System.out.println("Entry Invalid. Please try again.");
			System.out.println("Please Select What You Would Like to Do");
			System.out.println("1. SignIn");
			System.out.println("2. Register");
			System.out.println("3. Quit Application - Type Q");
            in_ppage = ppage.nextInt();
        }

		Scanner s = new Scanner(System.in);

		if(in_ppage==1) {
			System.out.println("Username: ");
			Scanner u = new Scanner(System.in);
			String username = u.next();

			System.out.println("Password: ");
			Scanner p = new Scanner(System.in);
			String pswd = p.next();

			Boolean accessed = false;

			accessed = signin(username, pswd);

			if (accessed == true) {
				System.out.println("Welcome " +username+ ",");

				int Echoice = Integer.parseInt(Eopts());
                while(Echoice!= 4)
                {
                    switch(Echoice)
                    {
                        case 1:
                        {
                        	System.out.println("What is your Home Airport (Please type the IATA Code like ORD, etc.):");
                            String hport_id = s.next().toUpperCase();
                            app.addhport(username, hport_id);
                            Echoice = Integer.parseInt(Eopts());
                            break;
                        }

                        case 2:
                        {
                        	System.out.println("Please Enter Your Username:");
                            String email = s.next();

                            System.out.println("Select The Action You Wish To Perform:");
                        	System.out.println("Add CreditCard - Type: AC");
                        	System.out.println("Add Address - Type: AA");
                        	String act = s.next().toUpperCase();

                        	while(!(act.compareToIgnoreCase("AC")==0 || act.compareToIgnoreCase("AA")==0)) {
                				System.out.println("Entry Invalid. Please try again.");
                				System.out.println("Select The Action You Wish To Perform:");
                            	System.out.println("Add CreditCard - Type: AC");
                            	System.out.println("Add Address - Type: AA");
                                act = s.next().toUpperCase();
                            }

                            // New-Address
                        	if(act.compareToIgnoreCase("AA")==0) {
                        		System.out.println("Residential AND Billing Addresses");
                        		System.out.println("Enter your Street Number:");
                        		String snum = s.next();
                        		System.out.println("Enter your Street Name:");
                        		String sname = app.upperCaseFirst(s.next());
                        		System.out.println("Enter your Apt. Num (if any):");
                        		String apt_no = s.next();
                        		System.out.println("Enter your City Name:");
                        		String city_name = app.upperCaseFirst(s.next());
                        		System.out.println("Enter your State Name:");
                        		String state_name = app.upperCaseFirst(s.next());
                        		System.out.println("Enter the ZipCode:");
                        		String zicode = s.next();

                        		System.out.println("Is this also a Billing Address for one of your Credit Card (Y/N) ?");
                        		String ba = s.next();

                        		while(!(ba.compareToIgnoreCase("Y")==0 || ba.compareToIgnoreCase("N")==0)) {
                        			System.out.println("Entry Invalid. Please try again.");
                        			System.out.println("Is this also a Billing Address for one of your Credit Card (Y/N) ?");
                        			ba = s.next().toUpperCase();
                        		}

                        		if(ba.compareToIgnoreCase("Y")==0) {
                        			System.out.println("Enter CreditCard Number:");
                        			Long ccnum = s.nextLong();
                        			System.out.println("Enter CVV:");
                        			int cc_cvv = s.nextInt();
                        			System.out.println("Enter Expiration Month (In Digits/Number):");
                        			int cc_expm = s.nextInt();
                        			System.out.println("Enter Expiration Year (4-digits XXXX):");
                        			int cc_expy = s.nextInt();
                        			app.addCredit(ccnum, cc_cvv, cc_expm, cc_expy, email, snum, sname, apt_no, city_name, state_name, zicode);
                        		}
                        		else {
                        			app.addaddress(email, snum, sname, apt_no, city_name, state_name, zicode);
                        		}
                        	}
                        	else {
                            //New-PaymentInfo
                        			System.out.println("Payment Information");
                        			System.out.println("Enter CreditCard Number:");
                        			Long ccnum = s.nextLong();
                        			System.out.println("Enter CVV:");
                        			int cc_cvv = s.nextInt();
                        			System.out.println("Enter Expiration Month (In Digits/Number):");
                        			int cc_expm = s.nextInt();
                        			System.out.println("Enter Expiration Year (4-digits XXXX):");
                        			int cc_expy = s.nextInt();
                        			System.out.println("Enter the Street Number for the Card:");
                        			String snum = s.next();
                        			System.out.println("Enter the Street Name for the Card:");
                        			String sname = app.upperCaseFirst(s.next());
                        			System.out.println("Enter the Apt. Num (if any):");
                        			String apt_no = s.next();
                        			System.out.println("Enter the City Name:");
                        			String city_name = app.upperCaseFirst(s.next());
                        			System.out.println("Enter the State Name:");
                        			String state_name = app.upperCaseFirst(s.next());
                        			System.out.println("Enter the ZipCode:");
                        			String zicode = s.next();
                        			app.addCredit(ccnum, cc_cvv, cc_expm, cc_expy, email, snum, sname, apt_no, city_name, state_name, zicode);
                        		}
                        	Echoice = Integer.parseInt(Eopts());
                            break;
                        }


                        case 3:
                        {
                        	//Update OR Deletion of Address or Credit Card
                        	System.out.println("Select The Action You Wish To Perform:");
                        	System.out.println("Update CreditCard - Type: UC");
                        	System.out.println("Update Address - Type: UA");
                        	System.out.println("Delete CreditCard - Type: DC");
                        	System.out.println("Delete Address - Type: DA");

                        	String act = s.next().toUpperCase();

                        	while(!(act.compareToIgnoreCase("UC")==0 || act.compareToIgnoreCase("UA")==0 || act.compareToIgnoreCase("DC")==0 || act.compareToIgnoreCase("DA")==0)) {
                				System.out.println("Entry Invalid. Please try again.");
                				System.out.println("Select The Action You Wish To Perform:");
                            	System.out.println("Update CreditCard - Type: UC");
                            	System.out.println("Update Address - Type: UA");
                            	System.out.println("Delete CreditCard - Type: DC");
                            	System.out.println("Delete Address - Type: DA");
                                act = s.next().toUpperCase();
                            }

                        	if(act.compareToIgnoreCase("UC")==0) {
                        		System.out.println("Please Enter Your Username/Email:");
                        		String email = s.next();
                        		System.out.println("Enter Your OLD CreditCard Number:");
                				Long o_ccnum = s.nextLong();
                				System.out.println("Enter the OLD CVV:");
                				int o_cvv = s.nextInt();
                				System.out.println("Enter OLD Expiration Month (In Digits/Number):");
                				int o_expm = s.nextInt();
                				System.out.println("Enter OLD Expiration Year (4-digits XXXX):");
                				int o_expy = s.nextInt();
                				System.out.println("Enter the OLD Street Number for the Card:");
                                String o_snum = s.next();
                                System.out.println("Enter the OLD Street Name for the Card:");
                                String o_sname = app.upperCaseFirst(s.next());
                                System.out.println("Enter the OLD Apt. Num (if any):");
                                String o_apt_no = s.next();
                                System.out.println("Enter the OLD City Name:");
                                String o_city_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the OLD State Name:");
                                String o_state_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the OLD ZipCode:");
                                String o_zicode = s.next();
                                System.out.println("Enter Your NEW CreditCard Number:");
                				Long n_ccnum = s.nextLong();
                				System.out.println("Enter the NEW CVV:");
                				int n_cvv = s.nextInt();
                				System.out.println("Enter NEW Expiration Month (In Digits/Number):");
                				int n_expm = s.nextInt();
                				System.out.println("Enter NEW Expiration Year (4-digits XXXX):");
                				int n_expy = s.nextInt();
                				System.out.println("Enter the NEW Street Number for the Card:");
                                String n_snum = s.next();
                                System.out.println("Enter the NEW Street Name for the Card:");
                                String n_sname = app.upperCaseFirst(s.next());
                                System.out.println("Enter the NEW Apt. Num (if any):");
                                String n_apt_no = s.next();
                                System.out.println("Enter the NEW City Name:");
                                String n_city_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the NEW State Name:");
                                String n_state_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the NEW ZipCode:");
                                String n_zicode = s.next();
                                app.changecredit(email, o_ccnum, o_cvv, o_expm, o_expy, o_snum, o_sname, o_apt_no, o_city_name, o_state_name, o_zicode, n_ccnum, n_cvv, n_expm, n_expy, n_snum, n_sname, n_apt_no, n_city_name, n_state_name, n_zicode);
                        	}
                        	else if(act.compareToIgnoreCase("UA")==0) {
                        		System.out.println("Please Enter Your Username/Email:");
                        		String email = s.next();
                        		System.out.println("Enter the OLD Street Number:");
                                String o_snum = s.next();
                                System.out.println("Enter the OLD Street Name:");
                                String o_sname = app.upperCaseFirst(s.next());
                                System.out.println("Enter the OLD Apt. Num (if any):");
                                String o_apt_no = s.next();
                                System.out.println("Enter the OLD City Name:");
                                String o_city_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the OLD State Name:");
                                String o_state_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the OLD ZipCode:");
                                String o_zicode = s.next();
                                System.out.println("Enter the NEW Street Number:");
                                String n_snum = s.next();
                                System.out.println("Enter the NEW Street Name:");
                                String n_sname = app.upperCaseFirst(s.next());
                                System.out.println("Enter the NEW Apt. Num (if any):");
                                String n_apt_no = s.next();
                                System.out.println("Enter the NEW City Name:");
                                String n_city_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the NEW State Name:");
                                String n_state_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the NEW ZipCode:");
                                String n_zicode = s.next();
                                app.changeaddress(email, o_snum, o_sname, o_apt_no, o_city_name, o_state_name, o_zicode, n_snum, n_sname, n_apt_no, n_city_name, n_state_name, n_zicode);
                        	}
                        	else if(act.compareToIgnoreCase("DC")==0) {
                        		System.out.println("Enter Your CreditCard Number that you wish to be DELETED:");
                				Long ccnum = s.nextLong();
                				app.remCC(ccnum);
                        	}
                        	else {
                        		System.out.println("Please Enter Your Username/Email:");
                        		String email = s.next();
                        		System.out.println("Enter the Street Number");
                                String snum = s.next();
                                System.out.println("Enter the Street Name");
                                String sname = app.upperCaseFirst(s.next());
                                System.out.println("Enter the Apt. Num (if any):");
                                String apt_no = s.next();
                                System.out.println("Enter the City Name:");
                                String city_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the State Name:");
                                String state_name = app.upperCaseFirst(s.next());
                                System.out.println("Enter the ZipCode:");
                                String zicode = s.next();
                                app.remaddress(email, snum, sname, apt_no, city_name, state_name, zicode);
                        	}
                            Echoice = Integer.parseInt(Eopts());
                            break;
                        }
                        case 4:
                        {
                        	System.out.println("Thanks for visiting. Rerun to start again!");
                            break;
                        }
                        default:
                        {
                            System.out.println("Option Not Recognized.");
                            Echoice = Integer.parseInt(Eopts());
                            break;
                        }
                        }
                    u.close();
                    p.close();
			}
			} else {
				System.out.println("Email and Password pairs do not exist");
				System.out.println("Perhaps, you might want to Signup?(Y/N)");
				String ns = s.next().toUpperCase();
				while(!(ns.compareToIgnoreCase("Y")==0 || ns.compareToIgnoreCase("N")==0)) {
    				System.out.println("Entry Invalid. Please try again.");
    				System.out.println("Do You Want to SignUp? (Y/N)");
                    ns = s.next().toUpperCase();
                }
				if(ns.compareToIgnoreCase("Y")==0) {
					System.out.println("We will first ask you some General Information about yourself");
	                System.out.println("Enter your choice of username:");
	                String email = s.next();
	                System.out.println("Enter your choice of password:");
	                String passwd = s.next();
	                System.out.println("Enter your age:");
	                int age = s.nextInt();
	                System.out.println("Enter your First Name:");
	                String fname = app.upperCaseFirst(s.next());
	                System.out.println("Enter your Middle Name (if any):");
	                String mname = app.upperCaseFirst(s.next());
	                System.out.println("Enter your Last Name:");
	                String lname = app.upperCaseFirst(s.next());
	                app.addcustomer(email, passwd, age, fname, mname, lname);
	                System.out.println("Thank You For Signing Up");
				} else {
					System.out.println("Have a Nice Day. See You Next Time.");
				}


			}}

			else if (in_ppage==2) {
				System.out.println("We will first ask you some General Information about yourself");
                System.out.println("Enter your choice of username:");
                String email = s.next();
                System.out.println("Enter your choice of password:");
                String passwd = s.next();
                System.out.println("Enter your age:");
                int age = s.nextInt();
                System.out.println("Enter your First Name:");
                String fname = app.upperCaseFirst(s.next());
                System.out.println("Enter your Middle Name (if any):");
                String mname = app.upperCaseFirst(s.next());
                System.out.println("Enter your Last Name:");
                String lname = app.upperCaseFirst(s.next());
                app.addcustomer(email, passwd, age, fname, mname, lname);
                System.out.println("Thank You For Signing Up");
			}

			else {
				System.out.println("Have a Nice Day. See You Next Time.");
			}
		s.close();
		ppage.close();
    }}
