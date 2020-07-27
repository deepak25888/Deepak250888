package in.coder.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.coder.foodplaza.pojo.FoodOrder;
import in.coder.foodplaza.utility.DBUtility;

public class FoodOrderDaoImpl implements FoodOrderDao{
	@Override
	public double getTotalBill(String custUserName) {
		Connection con=null;
		double totalBill=0;
		try
		{
			con=DBUtility.getDBConnection();
			String sql="select foodPrice*quantity as amount from food as f inner join"
					+ " cart as c on f.foodId=c.foodId"
					+ " where c.custUserName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, custUserName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				double amount=rs.getDouble("amount");
				totalBill=totalBill+amount;
			}
			CartDaoImpl c=new CartDaoImpl();		
			boolean a=c.clearCart(custUserName);
			System.out.println(a);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return totalBill;
	}
	public long placeOrder(FoodOrder foodOrder) {
		boolean b=false;
		long orderId=0;
		Connection con=null;
		try
		{
			con=DBUtility.getDBConnection();
			String orderDate=LocalDate.now().toString();
			String sql="insert into foodorder(custUserName,totalBill,orderStatus,orderDate) values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, foodOrder.getCustUserName());
			pstmt.setDouble(2,foodOrder.getTotalBill());
			pstmt.setString(3, foodOrder.getOrderStatus());
			pstmt.setString(4,orderDate);
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				String sql1="select orderId from foodOrder where custUserName=? and orderDate=?";
				pstmt=con.prepareStatement(sql1);
				pstmt.setString(1, foodOrder.getCustUserName());
				pstmt.setString(2,orderDate);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					orderId=rs.getLong("orderId");
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return orderId;		
	}

	@Override
	public String checkOrderStatus(long orderId) {
		Connection con=null;
		String orderStatus=null;
		try
		{
			con=DBUtility.getDBConnection();
			String sql="select orderStatus from foodorder where orderId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, orderId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				orderStatus=rs.getString("orderStatus");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderStatus;
	}

	@Override
	public List<FoodOrder> getAllOrders(String custUserName) {
		Connection con=null;
		FoodOrder foodorder = null ;
		List<FoodOrder> orderList=new ArrayList<>();
		try {
			con=DBUtility.getDBConnection();
			String sql="select * from foodorder where custUserName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,custUserName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				foodorder=new FoodOrder();
				foodorder.setOrderId(rs.getInt("orderId"));
				foodorder.setCustUserName(rs.getString("custUserName"));
				foodorder.setTotalBill(rs.getDouble("totalBill"));
				foodorder.setOrderStatus(rs.getString("orderStatus"));
				foodorder.setOrderDate(rs.getString("orderDate"));

				orderList.add(foodorder);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public FoodOrder getOrderById(long orderId) {
		Connection con=null;
		FoodOrder foodorder = null ;

		try {
			con=DBUtility.getDBConnection();
			String sql="select * from foodorder where orderId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setLong(1,orderId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				foodorder=new FoodOrder();
				foodorder.setOrderId(rs.getInt("orderId"));
				foodorder.setCustUserName(rs.getString("custUserName"));
				foodorder.setTotalBill(rs.getDouble("totalBill"));
				foodorder.setOrderStatus(rs.getString("orderStatus"));
				foodorder.setOrderDate(rs.getString("orderDate"));

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return foodorder;
	}

}
