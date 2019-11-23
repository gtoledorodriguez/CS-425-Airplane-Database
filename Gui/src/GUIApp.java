import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class GUIApp {
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
    	System.out.println("Connected to the PostgreSQL server successfully.");

        return conn;
    }
	public static void main(String[] args) {
		GUIApp app = new GUIApp();

	}

}
