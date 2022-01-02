package com.customer.module;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService 
{
	@Autowired
	private SuperAdminRepository sar;
	
	@Autowired
	EntityManager entityManager;
	
	public void addingSuperAdminValues()
	{
		SuperAdmin val = new SuperAdmin();
		val.setId(1);
		val.setUsername("Valentina");
		val.setPassword("Sdp3AF");
		sar.save(val);
		
		SuperAdmin jah = new SuperAdmin();
		jah.setId(2);
		jah.setUsername("Jahnavi");
		jah.setPassword("Sdp3AF");
		sar.save(jah);
		
		SuperAdmin mot = new SuperAdmin();
		mot.setId(3);
		mot.setUsername("Mothilal");
		mot.setPassword("Sdp3AF");
		sar.save(mot);
	}
	
	
	
	/*public List<SuperAdmin> Superlogin(String username,String password)
	 {
	   Query query = entityManager.createQuery("select u SuperAdminTable u where u.username=:username and u.password=:password");
	    query.setParameter("username",username);
	    query.setParameter("password", password);
	      List<SuperAdmin> users = query.getResultList();
	      return users;
	 }*/
	
	
	public boolean SuperLoginCheck(String username, String password)
	{
		List<SuperAdmin> admins= (List<SuperAdmin>)sar.findAll();
		
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

}
