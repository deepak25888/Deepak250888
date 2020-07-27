package in.coder.foodplaza.dao;

import java.util.List;
import in.coder.foodplaza.pojo.Cart;
import in.coder.foodplaza.pojo.Food;

public interface CartDao {
	boolean addToCart(Cart cart);
	boolean updateCart(Cart cart);
	boolean deleteFromCart(int foodId,String custUserName);
	boolean deleteCart(int cartId);
	List<Food> showFoods(String custUserName);
	boolean clearCart(String custUserName);
	List<Cart> showCart(String custUserName);
	Cart getCartById(int cartId);
}
