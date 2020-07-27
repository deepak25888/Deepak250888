package in.coder.foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import in.coder.foodplaza.dao.FoodDaoImpl;
import in.coder.foodplaza.pojo.Food;

public class FoodTest 
{
	public static void main(String[] args) throws IOException
	{
		 int foodId;
		 String foodName;
		 String foodType;
		 double foodPrice;
		 Scanner sc=new Scanner(System.in);
		 InputStreamReader isr=new InputStreamReader(System.in);
		 BufferedReader br=new BufferedReader(isr);
		 Food food=new Food();
		 FoodDaoImpl fdao=new FoodDaoImpl();
		 List<Food> foodList=new ArrayList<Food>();
		 int ch = 0;
		 boolean status;
		 do
		 {
			 System.out.println("1.Add Food\n2.Update Food\n3.Delete Food");
			 System.out.println("4.Search Food\n5.Search Food by Name\n6.Display Food\n7.Exit");
			 System.out.println("Enter your choice::");
			 ch=sc.nextInt();
			 
			 switch (ch) {
			case 1:		
				System.out.println("Enter food name");
				foodName=br.readLine();
				System.out.println("Enter food type");
				foodType=br.readLine();
				System.out.println("Enter food price");
				foodPrice=sc.nextDouble();
				
				food.setFoodName(foodName);
				food.setFoodType(foodType);
				food.setFoodPrice(foodPrice);
				
				//System.out.println(food);
				
				status=fdao.addFood(food);
				if(status==true)
					System.out.println("Food Added Successfully");
				else
					System.out.println("Food Not Added ");
				
				break;
			case 2:
				System.out.println("Enter existing food id");
				foodId=sc.nextInt();
				System.out.println("Enter new food name");
				foodName=br.readLine();
				System.out.println("Enter new food type");
				foodType=br.readLine();
				System.out.println("Enter new food price");
				foodPrice=sc.nextDouble();	
				
				food.setFoodId(foodId);
				food.setFoodName(foodName);
				food.setFoodType(foodType);
				food.setFoodPrice(foodPrice);
				//System.out.println(food);
				
				status=fdao.updateFood(food);
				if(status==true)
					System.out.println("Food Updated Successfully");
				else
					System.out.println("Food Not Updated");			
				break;
			case 3:
				System.out.println("Enter food id");
				foodId=sc.nextInt();
				status=fdao.deleteFood(foodId);
				if(status==true)
					System.out.println("Food Deleted Successfully");
				else
					System.out.println("Food Not Deleted ");				
				break;
			case 4:
				System.out.println("Enter food id");
				foodId=sc.nextInt();

				food=fdao.getFoodById(foodId);
				if(food!=null)
					System.out.println(food);
				else
					System.out.println("Food Not Found");
				break;
			case 5:
				System.out.println("Enter food name");
				foodName=br.readLine();
				foodList=fdao.getFoodByFoodName(foodName);
				if(foodList!=null)
				{
					for (Food food2 : foodList) {
						System.out.println(food2);
					}
				}
				else
					System.out.println("Food Not Found");
				break;
			case 6:
				foodList=fdao.getAllFoods();
				for (Food food2 : foodList) {
					System.out.println(food2);
				}
				break;
			case 7:
				System.exit(0);
			default:
				break;
			}			 
		 }while(ch>0);
	}

}
