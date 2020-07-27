package in.coder.foodplaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility 
{
	public static Connection getDBConnection()
	{	
		Connection con=null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplaza_deepak106?useSSL=false","root","Deepak25888");
			} 
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return con;
		
	}

}
