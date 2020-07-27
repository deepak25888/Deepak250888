package in.coder.foodplaza.pojo;

public class Customer {
	private int custId;
	private String custName;
	private String custAddress;
	private String custEmailId;
	private String custContactNumber;
	private String custUserName;
	private String custPassword;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
		
	public String getCustEmailId() {
		return custEmailId;
	}
	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}
	public String getCustContactNumber() {
		return custContactNumber;
	}
	public void setCustContactNumber(String custContactNumber) {
		this.custContactNumber = custContactNumber;
	}
	public String getCustUserName() {
		return custUserName;
	}
	public void setCustUserName(String custUserName) {
		this.custUserName = custUserName;
	}
	
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
//	public Customer() {
//		
//	}
//	public Customer(String custName, String custAddress, String custEmailId,
//			String custContactNumber, String custUserName, String custPassword) {
//	
//		this.custName = custName;
//		this.custAddress = custAddress;
//		this.custEmailId = custEmailId;
//		this.custContactNumber = custContactNumber;
//		this.custUserName = custUserName;
//		this.custPassword = custPassword;
//	}
//	public Customer(int custId, String custName, String custAddress,
//			String custEmailId, String custContactNumber, String custUserName,
//			String custPassword) {
//		this.custId=custId;
//		this.custName = custName;
//		this.custAddress = custAddress;
//		this.custEmailId = custEmailId;
//		this.custContactNumber = custContactNumber;
//		this.custUserName = custUserName;
//		this.custPassword = custPassword;
//	}
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custAddress=" + custAddress + ", custEmailId=" + custEmailId
				+ ", custContactNumber=" + custContactNumber + ", custUserName="
				+ custUserName + ", custPassword=" + custPassword + "]";
	}

}
