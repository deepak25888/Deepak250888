package in.coder.foodplaza.pojo;

public class Cart
{
	private int cartId;
	private int foodId;
	private int quantity;
	private String custUserName;
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCustUserName() {
		return custUserName;
	}

	public void setCustUserName(String custUserName) {
		this.custUserName = custUserName;
	}

	public Cart() {
		
	}

	public Cart(int foodId, int quantity, String custUserName) {
		
		this.foodId = foodId;
		this.quantity = quantity;
		this.custUserName = custUserName;
	}

	public Cart(int cartId, int foodId, int quantity, String custUserName) {
		this.cartId=cartId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.custUserName = custUserName;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", quantity="
				+ quantity + ", custUserName=" + custUserName + "]";
	}
	
	
	

}
