package in.coder.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.foodplaza.pojo.Cart;
import in.coder.foodplaza.pojo.Food;
import in.coder.foodplaza.utility.DBUtility;

public class CartDaoImpl implements CartDao{
	@Override
	public boolean addToCart(Cart cart) {
		boolean b=false;
		Connection con=null;
		try {
			con=DBUtility.getDBConnection();
			String sql="insert into cart(foodId,quantity,custUserName) values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,cart.getFoodId());
			pstmt.setInt(2, cart.getQuantity());
			pstmt.setString(3, cart.getCustUserName());
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
	public boolean updateCart(Cart cart) {
		boolean b=false;
		Connection con=null;

		try {
			con=DBUtility.getDBConnection();
			String sql="update cart set foodId=?,quantity=? where cartId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(3, cart.getCartId());
			pstmt.setInt(1,cart.getFoodId());
			pstmt.setInt(2, cart.getQuantity());

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
	public boolean deleteFromCart(int foodId, String custUserName) {
		boolean b=false;
		Connection con=null;		
		try {
			con=DBUtility.getDBConnection();
			String sql="delete from cart where foodId=? and custUserName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, foodId);
			pstmt.setString(2, custUserName);
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
	public boolean deleteCart(int cartId) {
		boolean b=false;
		Connection con=null;

		try {
			con=DBUtility.getDBConnection();
			String sql="delete from cart where cartId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cartId);	
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
	public List<Food> showFoods(String custUserName) {
		Connection con=null;
		Food food;
		List<Food> cartList=new ArrayList<>();
		try {
			con=DBUtility.getDBConnection();
			String sql="select f.foodId,foodName,foodType,foodPrice from food as f inner join"
					+ " cart as c on f.foodId=c.foodId where c.custUserName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,custUserName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				food=new Food();
				food.setFoodId(rs.getInt("foodId"));
				food.setFoodName(rs.getString("foodName"));
				food.setFoodType(rs.getString("foodType"));
				food.setFoodPrice(rs.getDouble("foodPrice"));
				cartList.add(food);	
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return cartList;
	}

	@Override
	public boolean clearCart(String custUserName) {
		boolean b=false;
		Connection con=null;

		try {
			con=DBUtility.getDBConnection();
			String sql="delete from cart where custUserName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, custUserName);	
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
	public Cart getCartById(int cartId) {
		Connection con=null;
		Cart cart = null ;
		try {
			con=DBUtility.getDBConnection();
			String sql="select * from cart where cartId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cartId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cart=new Cart();
				cart.setCartId(rs.getInt("cartId"));
				cart.setFoodId(rs.getInt("foodId"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setCustUserName(rs.getString("custUserName"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;

	}
	@Override
	public List<Cart> showCart(String custUserName) {
		Connection con=null;
		Cart cart = null ;
		List<Cart> cartList=new ArrayList<>();
		try {
			con=DBUtility.getDBConnection();
			String sql="select * from cart where custUserName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,custUserName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cart=new Cart();
				cart.setCartId(rs.getInt("cartId"));
				cart.setFoodId(rs.getInt("foodId"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setCustUserName(rs.getString("custUserName"));
				cartList.add(cart);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cartList;
	}
}
