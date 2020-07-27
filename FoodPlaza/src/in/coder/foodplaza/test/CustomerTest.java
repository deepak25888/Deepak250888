package in.coder.foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.coder.foodplaza.dao.CustomerDao;
import in.coder.foodplaza.dao.CustomerDaoImpl;
import in.coder.foodplaza.dao.FoodDaoImpl;
import in.coder.foodplaza.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) throws IOException 
	{
		int custId;
		String custName;
		String custAddress;
		String custEmailId;
		String custContactNumber;
		String custUserName;
		String custPassword;
		Scanner sc=new Scanner(System.in);
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		Customer cust=new Customer();
		CustomerDao cdao=new CustomerDaoImpl();
		List<Customer> custList=new ArrayList<Customer>();
		int ch = 0;
		boolean status;
		do
		{
			System.out.println("1.Add Customer\n2.Update Customer");
			System.out.println("3.Delete Customer\n4.Search Customer\n5.Display Customer\n6.Exit");
			System.out.println("Enter your choice::");
			ch=sc.nextInt();

			switch (ch) {
			case 1:
				
				System.out.println("Enter Customer Name:");
				custName=br.readLine();
				System.out.println("Enter Customer Address:");
				custAddress=br.readLine();
				System.out.println("Enter Customer EmailId:");
				custEmailId=br.readLine();
				System.out.println("Enter Customer Contact Number:");
				custContactNumber=br.readLine();
				System.out.println("Enter Customer UserName:");
				custUserName=br.readLine();
				System.out.println("Enter Customer Password:");
				custPassword=br.readLine();

				cust.setCustName(custName);
				cust.setCustAddress(custAddress);
				cust.setCustContactNumber(custContactNumber);
				cust.setCustEmailId(custEmailId);
				cust.setCustUserName(custUserName);
				cust.setCustPassword(custPassword);
				
				status=cdao.addCustomer(cust);				
				if(status==true)
					System.out.println("Customer Added Successfully");
				else
					System.out.println("Customer Not Added ");

				break;
			case 2:
				System.out.println("Enter existing Customer Id:");
				custId=sc.nextInt();
				System.out.println("Enter Customer new Name:");
				custName=br.readLine();
				System.out.println("Enter Customer new Address:");
				custAddress=br.readLine();
				System.out.println("Enter Customer new EmailId:");
				custEmailId=br.readLine();
				System.out.println("Enter Customer new Contact Number:");
				custContactNumber=br.readLine();
			
				cust.setCustId(custId);
				cust.setCustName(custName);
				cust.setCustAddress(custAddress);
				cust.setCustContactNumber(custContactNumber);
				cust.setCustEmailId(custEmailId);
						
				status=cdao.updateCustomer(cust);		
				if(status==true)
					System.out.println("Customer Updated Successfully");
				else
					System.out.println("Customer Not Updated ");

				break;
			case 3:
				System.out.println("Enter customer id");
				custId=sc.nextInt();

				status=cdao.deleteCustomer(custId);
				if(status==true)
					System.out.println("Customer Deleted Successfully");
				else
					System.out.println("Customer Not Deleted ");

				break;
			case 4:
				System.out.println("1.Search By Id\n2.Search By UserName");
				
				System.out.println("Enter your choice:");
				int s=sc.nextInt();
				if(s==1)
				{
					System.out.println("Enter Customer Id");
					custId=sc.nextInt();
					cust=cdao.getCustomerById(custId);
					if(cust!=null)
						System.out.println(cust);
					else
						System.out.println("Customer Not Found");
				}
				else if(s==2)
				{
					System.out.println("Enter Customer UserName");
					custUserName=br.readLine();
					cust=cdao.getCustomerByUserName(custUserName);
					if(cust!=null)
						System.out.println(cust);
					else
						System.out.println("Customer Not Found");	
				}
				else
				{
					System.out.println("You have enter 1 or 2 only...");
				}
				
				break;

			case 5:
				custList=cdao.getAllCustomer();
				for (Customer customer : custList) {
					System.out.println(customer);
				}
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid Choice!!!");
				break;
			}			 
		}while(ch>0);
	}
}