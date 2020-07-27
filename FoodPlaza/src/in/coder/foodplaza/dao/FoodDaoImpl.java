package in.coder.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.foodplaza.pojo.Food;
import in.coder.foodplaza.utility.DBUtility;


public class FoodDaoImpl implements FoodDao{

	@Override
	public boolean addFood(Food food) {
		boolean b=false;
		Connection con=null;
		try {
			con=DBUtility.getDBConnection();
			String sql="insert into food(foodName, foodType, foodPrice) values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			//pstmt.setInt(1, food.getFoodId());
			pstmt.setString(1,food.getFoodName());
			pstmt.setString(2, food.getFoodType());
			pstmt.setDouble(3, food.getFoodPrice());
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				b=true;
			}
			else
			{
				b=false;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean updateFood(Food food) {
		boolean b=false;
		Connection con=null;

		try {
			con=DBUtility.getDBConnection();
			String sql="update food set foodName=?,foodType=?,foodPrice=? where foodId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);		
			pstmt.setString(1,food.getFoodName());
			pstmt.setString(2, food.getFoodType());
			pstmt.setDouble(3, food.getFoodPrice());
			pstmt.setInt(4, food.getFoodId());
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
	public boolean deleteFood(int foodId) {
		boolean b=false;
		Connection con=null;
		try {
			con=DBUtility.getDBConnection();
			String sql="delete from food where foodId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, foodId);	
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
	public Food getFoodById(int foodId) {
		Connection con=null;
		Food food = null ;
		try {
			con=DBUtility.getDBConnection();
			String sql="select * from food where foodId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, foodId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				food=new Food();
				foodId=rs.getInt("foodId");
				food.setFoodId(foodId);
				food.setFoodName(rs.getString("foodName"));
				food.setFoodType(rs.getString("foodType"));
				food.setFoodPrice(rs.getDouble("foodPrice"));				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return food;
	}

	@Override
	public List<Food> getAllFoods() {
		Connection con=null;
		Food food;
		List<Food> foodList=new ArrayList<>();
		try {
			con=DBUtility.getDBConnection();
			String sql="select * from food";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				food=new Food();
				int foodId=rs.getInt("foodId");
				food.setFoodId(foodId);//"foodId" table field
				food.setFoodName(rs.getString("foodName"));
				food.setFoodType(rs.getString("foodType"));
				food.setFoodPrice(rs.getDouble("foodPrice"));
				foodList.add(food);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return foodList;
	}

	@Override
	public List<Food> getFoodByFoodName(String foodName) {
		Connection con=null;
		Food food = null ;
		List<Food> foodList=new ArrayList<Food>();
		try {
			con=DBUtility.getDBConnection();
			String sql="select * from food where foodName like ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+foodName+"%");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				food=new Food();
				food.setFoodId(rs.getInt("foodId"));
				food.setFoodName(rs.getString("foodName"));
				food.setFoodType(rs.getString("foodType"));
				food.setFoodPrice(rs.getDouble("foodPrice"));
				foodList.add(food);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodList;
	}
}
