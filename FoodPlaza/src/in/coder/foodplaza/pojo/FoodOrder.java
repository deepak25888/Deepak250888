package in.coder.foodplaza.pojo;

public class FoodOrder {
	private long orderId;
	private String custUserName;
	private double totalBill;
	private String orderStatus;
	private String orderDate;
	
	
//	public FoodOrder() {
//		
//	}
//	public FoodOrder(String custUserName, double totalBill, String orderStatus) {
//		orderId++;
//		this.custUserName = custUserName;
//		this.totalBill = totalBill;
//		this.orderStatus = orderStatus;
//	}
//	public FoodOrder(int orderId, String custUserName, double totalBill,
//			String orderStatus) {
//		super();
//		this.orderId = orderId;
//		this.custUserName = custUserName;
//		this.totalBill = totalBill;
//		this.orderStatus = orderStatus;
//	}
//	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getCustUserName() {
		return custUserName;
	}
	public void setCustUserName(String custUserName) {
		this.custUserName = custUserName;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "FoodOrder [orderId=" + orderId + ", custUserName=" + custUserName
				+ ", totalBill=" + totalBill + ", orderStatus=" + orderStatus
				+ "]";
	}

}
