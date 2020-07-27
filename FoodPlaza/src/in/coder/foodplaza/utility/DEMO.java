package in.coder.foodplaza.utility;

import java.sql.*;
import java.util.Properties;


public class DEMO {

	public static void main(String[] args) {
		Connection con;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
//			Driver d=new com.mysql.jdbc.Driver();
//			DriverManager.registerDriver(d);
//			Properties p=new Properties();
//			p.put("user", "root");
//			p.put("pwd", "root");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodDB","root","root");
			
			String sql="select * from food";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			ResultSet rs=stmt.executeQuery();
			
			con.close();
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
