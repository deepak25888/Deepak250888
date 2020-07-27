package in.coder.foodplaza.dao;

public interface LoginDao 
{
	boolean adminLogin(String userName,String password);
	boolean userLogin(String userName,String password);
	boolean adminChangePassword(String userName,String newPassword);
	boolean userChangePassword(String userName,String newPassword);
}
