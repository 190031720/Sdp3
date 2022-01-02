package com.customer.module;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;




@Service
public class CustomerService 
{
	@Autowired
	 EntityManager entityManager;
	
	@Autowired
	CustomerRepository customerrepository;
	
	@Autowired
	DonationRepository dr;
	
	
	
	public void addCustomerRecord(Customer cust)
	{
		System.out.println(cust.getUserid());
		customerrepository.save(cust);
	}
	
//	public List<Customer> login(String username,String password)
//	 {
//	   Query query = entityManager.createQuery("select u from Customers u where u.username=:username and u.password=:password");
//	    query.setParameter("username",username);
//	    query.setParameter("password", password);
//	      List<Customer> users = query.getResultList();
//	      return users;
//	 }
	
	public boolean login(String username, String password)
	{
		List<Customer> admins= (List<Customer>)customerrepository.findAll();
		
		for(int i=0;i<admins.size();i++)
		{
			String stru=admins.get(i).getUsername();
			String strp=admins.get(i).getPassword();
			if(stru.equals(username) && strp.equals(password))
			{
				return true;
			}
			
		}
		
		return false;
	}
	
	public void addData(DonationDetails d)
	{
		System.out.println(d.getId());
		dr.save(d);
	} 
	
	

}
