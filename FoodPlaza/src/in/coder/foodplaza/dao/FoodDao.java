package in.coder.foodplaza.dao;

import java.util.List;
import in.coder.foodplaza.pojo.Food;


public interface FoodDao
{
	boolean addFood(Food food);
	boolean updateFood(Food food);
	boolean deleteFood(int foodId);
	Food getFoodById(int foodId);
	List<Food> getFoodByFoodName(String foodName);
	List<Food> getAllFoods();
}
