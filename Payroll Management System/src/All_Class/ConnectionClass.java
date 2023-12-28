package All_Class;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionClass {
 public Statement stm;
 Connection con;
 
 public ConnectionClass() throws Exception{
	 
 con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "Admin123$");
	stm = con.createStatement();
	if (con.isClosed()) {
		System.out.println("Connection is closed");
	} else {
		System.out.println("Connection is OPen!!!!");
	}

 }

	public static void main(String[] args) throws Exception {

		new ConnectionClass();
	}

}
