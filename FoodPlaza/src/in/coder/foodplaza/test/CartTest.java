package in.coder.foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.coder.foodplaza.dao.CartDao;
import in.coder.foodplaza.dao.CartDaoImpl;
import in.coder.foodplaza.pojo.Cart;
import in.coder.foodplaza.pojo.Food;


public class CartTest {

	public static void main(String[] args) throws IOException {
		int cartId;
		int foodId;
		int quantity;
		String custUserName;	
		Scanner sc=new Scanner(System.in);
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		Cart cart=new Cart();
		CartDao cartDao=new CartDaoImpl();
		List<Cart> cartList=new ArrayList<Cart>();
		List<Food> foodList=new ArrayList<Food>();
		int ch = 0;
		boolean status;
		do
		{
			System.out.println("1.Add To Cart\n2.Update Cart");
			System.out.println("3.Delete Food from Cart\n4.Delete Cart\n5.Show Food\n6.Clear Cart");
			System.out.println("7.Search Cart\n8.Show Cart\n9.Exit");
			System.out.println("Enter your choice::");
			ch=sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter Food Id:");
				foodId=sc.nextInt();
				System.out.println("Enter food quantity:");
				quantity=sc.nextInt();
				System.out.println("Enter UserName:");
				custUserName=br.readLine();
					
				cart.setFoodId(foodId);
				cart.setQuantity(quantity);
				cart.setCustUserName(custUserName);
				
				status=cartDao.addToCart(cart);			
				if(status==true)
					System.out.println("Cart created Successfully");
				else
					System.out.println("Cart Not Created ");

				break;
			case 2:
				System.out.println("Enter existing Cart Id:");
				cartId=sc.nextInt();
				System.out.println("Enter Food new Id:");
				foodId=sc.nextInt();
				System.out.println("Enter new Quantity:");
				quantity=sc.nextInt();
							
				cart.setCartId(cartId);
				cart.setFoodId(foodId);
				cart.setQuantity(quantity);			
				
				status=cartDao.updateCart(cart);
				if(status==true)
					System.out.println("Cart Updated Successfully");
				else
					System.out.println("Cart Not Updated ");

				break;
			case 3:
				System.out.println("Enter Food id");
				foodId=sc.nextInt();
				System.out.println("Enter UserName:");
				custUserName=br.readLine();						

				status=cartDao.deleteFromCart(foodId, custUserName);
				if(status==true)
					System.out.println("Food Deleted Successfully");
				else
					System.out.println("Food Not Deleted ");

				break;
			case 4:
				System.out.println("Enter Cart id");
				cartId=sc.nextInt();
				
				status=cartDao.deleteCart(cartId);
				if(status==true)
					System.out.println("Cart Deleted Successfully");
				else
					System.out.println("Cart Not Deleted ");

				break;
			case 5:
				System.out.println("Enter UserName");
				custUserName=br.readLine();
				foodList=cartDao.showFoods(custUserName);
				for (Food food : foodList) {
					System.out.println(food);
				}
				break;
			case 6:
				System.out.println("Enter UserName");
				custUserName=br.readLine();
				status=cartDao.clearCart(custUserName);
				
				if(status==true)
					System.out.println("Cart Cleared Successfully");
				else
					System.out.println("Cart Not Cleared ");

				break;
			case 7:
				System.out.println("Enter Cart id");
				cartId=sc.nextInt();
				
				cart=cartDao.getCartById(cartId);
				if(cart!=null)
					System.out.println(cart);
				else
					System.out.println("Cart Not Found");
				break;
				
			case 8:
				System.out.println("Enter UserName");
				custUserName=br.readLine();
				cartList=cartDao.showCart(custUserName);
				for (Cart cart1 : cartList) {
					System.out.println(cart1);
				}
				break;
				
			case 9:
				System.exit(0);
			default:
				break;
			}			 
		}while(ch>0);

	}

}
