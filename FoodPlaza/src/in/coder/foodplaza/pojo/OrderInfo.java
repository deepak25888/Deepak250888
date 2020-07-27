package in.coder.foodplaza.pojo;

public class OrderInfo {
	private int id;
	private int orderId;
	private int foodId;
	private int quantity;
	
	
	public OrderInfo() {
		
	}
	public OrderInfo(int orderId, int foodId, int quantity) {
		id++;
		this.orderId = orderId;
		this.foodId = foodId;
		this.quantity = quantity;
	}
	public OrderInfo(int id, int orderId, int foodId, int quantity) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.foodId = foodId;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", orderId=" + orderId + ", foodId="
				+ foodId + ", quantity=" + quantity + "]";
	}
	
	
	

}
