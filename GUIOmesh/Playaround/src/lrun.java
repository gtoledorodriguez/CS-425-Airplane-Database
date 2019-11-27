import java.awt.event.InputMethodEvent;
import java.io.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.swing.JTextField;

import java.math.BigInteger;

public class lrun {
	private final static String url = "jdbc:postgresql://localhost/finalprojectdatab?user=postgres&password=Mee9623274900";
    static String user = "";
    static String password = "";
    public Connection connect() throws SQLException{
    	Connection conn = null;
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
    
    public static void addcustomer(String uname, String pwd, int _age, String f_name, String m_name, String l_name) {
    	try (Connection c = DriverManager.getConnection(url, user, password);
    			CallableStatement addcust1 = c.prepareCall("call addcust(?, ?, ?, ?, ?, ?)")	
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
    
    public static void addaddress(String uname, String str_num, String str_name, String ap_num, String l_city, String l_state, String zippcode) {
    	try (Connection c = DriverManager.getConnection(url, user, password);
    			CallableStatement addaddr1 = c.prepareCall("call addaddr(?, ?, ?, ?, ?, ?, ?)")	
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
    
    public static void addCredit(long ccnum, Integer CVV, Integer e_month, Integer e_year, String uname, String str_num, String str_name, String ap_num, String l_city, String l_state, String zippcode) {
    	try (Connection c = DriverManager.getConnection(url, user, password);
    			CallableStatement addcred = c.prepareCall("call addcc(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")	
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
    
    public static void changeaddress(String uname, String o_str_num, String o_str_name, String o_ap_num, String o_l_city, String o_l_state, String o_zippcode, String n_str_num, String n_str_name, String n_ap_num, String n_l_city, String n_l_state, String n_zippcode) {
    	try (Connection c = DriverManager.getConnection(url, user, password);
    			CallableStatement chgaddr1 = c.prepareCall("call changeaddr(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")	
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
    
    public static void changecredit(String uname, long o_ccnum, Integer o_CVV, Integer o_e_month, Integer o_e_year, String o_str_num, String o_str_name, String o_ap_num, String o_l_city, String o_l_state, String o_zippcode, long n_ccnum, Integer n_CVV, Integer n_e_month, Integer n_e_year, String n_str_num, String n_str_name, String n_ap_num, String n_l_city, String n_l_state, String n_zippcode) {
    	try (Connection c = DriverManager.getConnection(url, user, password);
    			CallableStatement chgcred1 = c.prepareCall("call changecc(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")	
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
    
    public static void remaddress(String uname, String str_num, String str_name, String ap_num, String l_city, String l_state, String zippcode) {
    	try (Connection c = DriverManager.getConnection(url, user, password);
    			CallableStatement remaddr1 = c.prepareCall("call removeaddr(?, ?, ?, ?, ?, ?, ?)")	
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
    
    public static void remCC(long ccnum) {
    	try (Connection c = DriverManager.getConnection(url, user, password);
    			CallableStatement remCC = c.prepareCall("call deleteCC(?)")	
    			)
    	{
    		remCC.setLong(1, ccnum);
    		remCC.execute();
    	}catch (SQLException e7) {
    		System.out.println(e7.getMessage());
    	}
    			 
    }
    
    public static void addhport(String uname, String hport) {
    	try (Connection c = DriverManager.getConnection(url, user, password);
    			CallableStatement addhport1 = c.prepareCall("call addhomeport(?, ?)")	
    			)
    	{
    		addhport1.setString(1, uname);
    		addhport1.setString(2,  hport);
    		addhport1.execute();
    	}catch (SQLException e9) {
    		System.out.println(e9.getMessage());
    	}
    			 
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
						getin = false;
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
    
    public static String listaddr(String au_name) {
    	String SQL = "SELECT street_number, street_name, apt_number, city, state, zipcode FROM lives where email_id = ?;";
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

						      r = r + rs.getString(i) + "              ";
						}
						r = r +"\n";
						//return rs.getString(columnsNumber);
						  System.out.println();
						    }
    			}
		catch (Exception e9) {
			System.out.println(e9.getMessage());
		}
		return r;
	}
    
    public static String listCCinfo(String au_name) {
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
    
    public static void main(String[] args) {
		lrun app = new lrun();
    }
}
