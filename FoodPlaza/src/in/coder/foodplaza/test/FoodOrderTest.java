package in.coder.foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.coder.foodplaza.dao.CartDaoImpl;
import in.coder.foodplaza.dao.FoodOrderDaoImpl;
import in.coder.foodplaza.pojo.FoodOrder;

public class FoodOrderTest {

	public static void main(String[] args) throws IOException {
		long orderId;
		String custUserName;
		double totalBill;
		String orderStatus;
		String orderDate;

		Scanner sc=new Scanner(System.in);
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		FoodOrderDaoImpl orderDao=new FoodOrderDaoImpl();
		FoodOrder order=new  FoodOrder();
		List<FoodOrder> orderList=new ArrayList<>();
		int ch = 0;
		boolean status;
		do
		{
			System.out.println("1.Place Order\n2.Check Order Status");
			System.out.println("3.View Order\n4.Search Order");
			System.out.println("5.Exit");
			System.out.println("Enter your choice::");
			ch=sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter UserName:");
				custUserName=br.readLine();

				totalBill=orderDao.getTotalBill(custUserName);
				orderStatus="placed";

				order.setCustUserName(custUserName);
				order.setTotalBill(totalBill);
				order.setOrderStatus(orderStatus);

				if(totalBill!=0)
				{
					orderId=orderDao.placeOrder(order);	
					if(orderId!=0)
						System.out.println("Your Order is placed Successfully with Order Id "+orderId);
					else
						System.out.println("Order Not Placed");
				}
				else
				{
					System.out.println("Cart is empty");
				}
				break;
			case 2:
				System.out.println("Enter Order Id:");
				orderId=sc.nextLong();
				orderStatus=orderDao.checkOrderStatus(orderId);
				System.out.println("Your Order status :"+orderStatus);

				break;
			case 3:

				System.out.println("Enter UserName:");
				custUserName=br.readLine();						
				orderList=orderDao.getAllOrders(custUserName);
				for (FoodOrder foodOrder : orderList) {
					System.out.println(foodOrder);
				}

				break;
			case 4:
				System.out.println("Enter Order id");
				orderId=sc.nextLong();
				order=orderDao.getOrderById(orderId);

				if(order!=null)
					System.out.println(order);
				else
					System.out.println("Order Not Found");

				break;
			case 5:
				System.exit(0);
				break;

			default:
				break;
			}			 
		}while(ch>0);
	}

}
