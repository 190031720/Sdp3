package com.customer.module;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NgoDataController {
	@Autowired
	private NgoDataRepository ndr;
	@Autowired
	private NgoService ns;
	
	 @RequestMapping(value="/submitNgoForm", method = RequestMethod.POST) public
	 ModelAndView displayRegistration(@RequestParam("orgname")String name,@RequestParam("orgurl")String url,@RequestParam("orgemail")String email,@RequestParam("orgname")String mobile,@RequestParam("orgdesc")String desc,@RequestParam("orgfunds")double funds,@RequestParam("orgtype")String type,@RequestParam("orglogo") MultipartFile logo ,@RequestParam("orgcertificate")MultipartFile certificate)
	 { 
		 ModelAndView modelAndView = new ModelAndView();
		 NgoData d=new NgoData();

			String fileName = StringUtils.cleanPath(logo.getOriginalFilename());
			String fileName2 = StringUtils.cleanPath(certificate.getOriginalFilename());
			if(fileName.contains(".."))
			{
				System.out.println("not a a valid file");
			}
			try {
				d.setOrglogo(Base64.getEncoder().encodeToString(logo.getBytes()));
				d.setOrgcertificate(Base64.getEncoder().encodeToString(certificate.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			d.setVerify(false);
			d.setOrgmobile(mobile);
			d.setOrgname(name);
			d.setOrgemail(email);
			d.setOrgfunds(funds);
			d.setOrgurl(url);
			d.setOrgtype(type);
			d.setOrgdesc(desc);
		 //modelAndView.addObject("userEntity", userEntity);
		 ndr.save(d);
		 modelAndView.addObject("message","Added Successfully!");
		 modelAndView.setViewName("NgoForm");
		 return modelAndView; 
	}
	 
	 @PostMapping("/donationdetail")
	  public ModelAndView displaysub(@ModelAttribute("Dtype")String name)
	  {
	    List<NgoData> subject=ns.getallsubjects();
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("displayfilteredorganisations");
	    List<NgoData> temp=new ArrayList<NgoData>();
	    System.out.println(name.getClass());
	    for(NgoData x:subject)
	    {
	      if(x.getOrgtype().equals(name))
	      {
	        temp.add(x);
	      }
	    }
	    mv.addObject("name",temp);
	    return mv;
	  }
	 

}
