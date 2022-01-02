package com.customer.module;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class NgoService 
{
	@Autowired
	NgoRepository customerrepository;
	
	@Autowired
	 EntityManager entityManager;
	
	@Autowired
		NgoDataRepository ndr;
	
	public void addNgoRecord(Ngo ngo)
	{
		System.out.println(ngo.getId());
		customerrepository.save(ngo);
	}
	
	public List<Ngo> Ngologin(String username,String password)
	 {
	   Query query = entityManager.createQuery("select u from Ngo u where u.username=:username and u.password=:password");
	    query.setParameter("username",username);
	    query.setParameter("password", password);
	      List<Ngo> users = query.getResultList();
	      return users;
	 }
	public ModelAndView getAllDonationData(String type)
	  {
		List<NgoData> subject=(List<NgoData>)ndr.findAll();
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("displayfilteredorganisations");
	    List<NgoData> temp=new ArrayList<NgoData>();
	    for(NgoData x:subject)
	    {
	      if(x.getOrgtype().equals(type))
	      {
	        temp.add(x);
	      }
	    }
	    mv.addObject("name",temp);
	    return mv;
	  }
	public List<NgoData> getallsubjects()
	  {
	    return (List<NgoData>)ndr.findAll();
	  }

}
