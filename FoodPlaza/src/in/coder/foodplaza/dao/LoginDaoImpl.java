package in.coder.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.coder.foodplaza.utility.DBUtility;


public class LoginDaoImpl implements LoginDao
{

	@Override
	public boolean adminLogin(String userName, String password) 
	{
		boolean b=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			con=DBUtility.getDBConnection();
			
			String sql="select adminUserName,adminPassword from admin where adminUserName=? and adminPassword=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.setString(2,password);
			
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				if(userName.equals(rs.getString("adminUserName"))&&password.equals(rs.getString("adminPassword")));
				{
					b=true;
				}
			}
		}  
		
		catch (SQLException e) 
		{
			b=false;
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return b;
	}

	@Override
	public boolean userLogin(String userName, String password)
	{
		boolean b=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			con=DBUtility.getDBConnection();
			
			String sql="select custUserName,custPassword from customer where custUserName=? and custPassword=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.setString(2,password);
			
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				if(userName.equals(rs.getString("custUserName"))&&password.equals(rs.getString("custPassword")));
				{
					b=true;
				}
			}
		}  
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return b;
	}

	@Override
	public boolean adminChangePassword(String userName, String newPassword) 
	{
		boolean b=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try
		{
			con=DBUtility.getDBConnection();
			
			String sql="update admin set adminPassword=? where adminUserName=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(2,userName);
			pstmt.setString(1,newPassword);
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				b=true;
			}
		} 
	
		catch (SQLException e) 
		{
			b=false;
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return b;
	}

	@Override
	public boolean userChangePassword(String userName, String newPassword) {
		boolean b=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try
		{
			con=DBUtility.getDBConnection();
			
			String sql="update Customer set custPassword=? where custUserName=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(2,userName);
			pstmt.setString(1,newPassword);
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				b=true;
			}
		} 
	
		catch (SQLException e) 
		{
			b=false;
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	
}
