package in.coder.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.foodplaza.pojo.Customer;
import in.coder.foodplaza.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public boolean addCustomer(Customer customer) {
		boolean b=false;
		Connection con=null;
		try {
			con=DBUtility.getDBConnection();
			String sql="insert into customer(custName, custAddress, custEmailId, custContactNumber, custUserName, custPassword)"
					+ " values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,customer.getCustName());
			pstmt.setString(2, customer.getCustAddress());
			pstmt.setString(3, customer.getCustEmailId());
			pstmt.setString(4, customer.getCustContactNumber());
			pstmt.setString(5, customer.getCustUserName());
			pstmt.setString(6, customer.getCustPassword());

			int i=pstmt.executeUpdate();
			if(i>0)
			{
				b=true;
			}
			else
			{
				b=false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		boolean b=false;
		Connection con=null;

		try {
			con=DBUtility.getDBConnection();
			String sql="update customer set custName=?, custAddress=?, custEmailId=?, custContactNumber=? where custId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,customer.getCustName());
			pstmt.setString(2, customer.getCustAddress());
			pstmt.setString(3, customer.getCustEmailId());
			pstmt.setString(4, customer.getCustContactNumber());
			pstmt.setInt(5, customer.getCustId());
			
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				b=true;
			}
			else
			{
				b=false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public boolean deleteCustomer(int custId) {
		boolean b=false;
		Connection con=null;

		try {
			con=DBUtility.getDBConnection();
			String sql="delete from customer where custId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, custId);	
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				b=true;
			}
			else
			{
				b=false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public Customer getCustomerByUserName(String custUserName) {
		Connection con=null;
		Customer customer = null ;
		try {
			con=DBUtility.getDBConnection();
			String sql="select * from customer where custUserName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, custUserName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				customer=new Customer();
				customer.setCustId(rs.getInt("custId"));
				customer.setCustName(rs.getString("custName"));
				customer.setCustAddress(rs.getString("custAddress"));
				customer.setCustEmailId(rs.getString("custEmailId"));
				customer.setCustContactNumber(rs.getString("custContactNumber"));
				customer.setCustUserName(rs.getString("custUserName"));
				customer.setCustPassword(rs.getString("CustPassword"));
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return customer;
	}
	@Override
	public List<Customer> getAllCustomer() {
		Connection con=null;
		Customer customer;
		List<Customer> customerList=new ArrayList<>();
		try {
			con=DBUtility.getDBConnection();
			String sql="select * from customer";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				customer=new Customer();
				customer.setCustId(rs.getInt("custId"));
				customer.setCustName(rs.getString("custName"));
				customer.setCustAddress(rs.getString("custAddress"));
				customer.setCustEmailId(rs.getString("custEmailId"));
				customer.setCustContactNumber(rs.getString("custContactNumber"));
				customer.setCustUserName(rs.getString("custUserName"));
				customer.setCustPassword(rs.getString("CustPassword"));
				customerList.add(customer);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}


	@Override
	public Customer getCustomerById(int custId) {
		Connection con=null;
		Customer customer = null ;
		try {
			con=DBUtility.getDBConnection();
			String sql="select * from customer where custId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, custId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				customer=new Customer();
				customer.setCustId(rs.getInt("custId"));
				customer.setCustName(rs.getString("custName"));
				customer.setCustAddress(rs.getString("custAddress"));
				customer.setCustEmailId(rs.getString("custEmailId"));
				customer.setCustContactNumber(rs.getString("custContactNumber"));
				customer.setCustUserName(rs.getString("custUserName"));
				customer.setCustPassword(rs.getString("CustPassword"));
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return customer;
	}
}
