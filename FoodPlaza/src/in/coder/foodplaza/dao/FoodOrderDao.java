package in.coder.foodplaza.dao;

import java.util.List;
import in.coder.foodplaza.pojo.FoodOrder;

public interface FoodOrderDao {
	
	double getTotalBill(String custUserName);
	long placeOrder(FoodOrder foodOrder);
	String checkOrderStatus(long orderId);
	List<FoodOrder> getAllOrders(String custUserName);
	FoodOrder getOrderById(long orderId);
}
