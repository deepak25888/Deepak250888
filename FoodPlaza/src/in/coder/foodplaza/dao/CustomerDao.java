package in.coder.foodplaza.dao;

import java.util.List;
import in.coder.foodplaza.pojo.Customer;

public interface CustomerDao {
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int custId);
	Customer getCustomerByUserName(String custUserName);
	Customer getCustomerById(int custId);
	List<Customer> getAllCustomer();
}

//in db,make custUserName field as unique key using alter 