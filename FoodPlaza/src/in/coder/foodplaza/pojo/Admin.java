package in.coder.foodplaza.pojo;

public class Admin {
	private String adminName;
	private String adminUsername;
	private String adminPassword;
	
	
	public Admin() {
		
	}
	public Admin(String adminName, String adminUsername, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminUsername="
				+ adminUsername + ", adminPassword=" + adminPassword + "]";
	}
	
	
   	
}
