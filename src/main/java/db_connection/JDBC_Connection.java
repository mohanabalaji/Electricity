package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class JDBC_Connection {
	
	static Connection con = null;
	public static Connection db()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eb","root","Sakthimaha@13");

		    }catch(Exception e) 
		{
			System.out.println(e);
		}
		return con;
	}

}
