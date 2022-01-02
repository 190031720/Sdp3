package com.customer.module;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController 
{
	@Autowired
    private CustomerRepository userRepository;


    @Autowired
    private CustomerConfirmationTokenRepository confirmationTokenRepository;
    
    @Autowired
    private SuperAdminRepository sar;
    
    @Autowired
    private NgoRepository nr;

    @Autowired
    private CustomerService cs;
    
    public JavaMailSender javaMailSender;
    
    @Autowired
    private EmailService es = new EmailService(javaMailSender);
    
    @Autowired
    private NgoService ngos;
    
    
    
    @GetMapping(value="/index")
	public String display2() 
	{
		return "index";
	}
    
    @RequestMapping(value="/register") public String displayRegistration() { return "signup"; }
    @RequestMapping(value="/login") public String displayLogin() { return "login"; }
    @RequestMapping(value="/home") public String displayHome() { return "home"; }
    @RequestMapping(value="/blog") public String display3() { return "blog"; }
	@RequestMapping(value="/abt") public String display4() { return "about_us"; }
	@RequestMapping(value="/contact") public String display5() { return "contact_us"; }
	@RequestMapping(value="/gallery") public String display6() { return "gallery"; }
	@RequestMapping(value="/service") public String display7() { return "services"; }
	@RequestMapping(value="/donationform") public String display8() { return "donationform"; }
    
	
	 @RequestMapping(value="/register", method = RequestMethod.GET) public
	 ModelAndView displayRegistration(@ModelAttribute("user")Customer userEntity)
	 { 
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("userEntity", userEntity);
		 modelAndView.setViewName("signup"); return modelAndView; 
	}
	 
    
    
    
    @RequestMapping(value="/registerdetails", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("user") Customer userEntity)
    {
    	ModelAndView modelAndView = new ModelAndView();

    	Customer existingUser = userRepository.findByEmailIgnoreCase(userEntity.getEmail());
    	System.out.print(userEntity.getUserid());
        if(existingUser != null)
        {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error");
        }
        else
        {
            userRepository.save(userEntity);

            CustomerConfirmationToken confirmationToken = new CustomerConfirmationToken(userEntity);

            confirmationTokenRepository.save(confirmationToken);
           

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(userEntity.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("valentinavelaga@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
            +"http://aaradhana.herokuapp.com//confirm-account?token="+confirmationToken.getConfirmationToken());

            es.sendEmail(mailMessage);

            modelAndView.addObject("emailId", userEntity.getEmail());

            modelAndView.setViewName("successfulRegistration");
            System.out.println("fff");
        }

        return modelAndView;
    }
    

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        CustomerConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
        	Customer user = userRepository.findByEmailIgnoreCase(token.getCust().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            modelAndView.setViewName("login");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }

    @PostMapping("/userlogin")
	public String userlogin(@ModelAttribute("username")String username,@ModelAttribute("password")String password,HttpServletRequest req)
	{  ModelAndView mv=new ModelAndView();
	    boolean res = cs.login(username, password);
	    if(!res)
	    {
	      mv.setViewName("error");
	        return "error";
	    }
	    System.out.println(username+" "+password);
	    HttpSession sess=req.getSession();
	    sess.setAttribute("username",username);
	    sess.setAttribute("name",username);
	    mv.setViewName("home");
	  return "redirect:/home";
	}
    
    @GetMapping("/userlogout")
    public String userlogout(HttpServletRequest req)
    {
        HttpSession sess=req.getSession(false);
    	System.out.println(sess.getAttribute("name"));
    	sess.removeAttribute("name");
    	sess.removeAttribute("email");
    	System.out.println(sess.getAttribute("name"));
    	return "redirect:/index";
    }
    
    @RequestMapping(value="/donationdetails", method = RequestMethod.POST)
    public ModelAndView Donation(@ModelAttribute("data") DonationDetails dd)
    {
    	ModelAndView mv= new ModelAndView();
    	cs.addData(dd);
    	System.out.println("Data Added!");
    	mv.setViewName("displayfilteredorganisations");
    	return mv;
    	
    }
    
    
    
    
    
    
    
    
    //---------------------------------------------------------------NGO Module Controller-------------------------------------------------------------//
    
    @Autowired
	NgoService ns;
    
    
    @RequestMapping(value="/NgoLogin") public String displayNgoLogin() { return "NgoLogin"; }
	@RequestMapping(value="/NgoRegister") public String displayNgoRegister() { return "NgoRegister"; }
	@RequestMapping(value="/NgoHome") public String displayNgoHome() { return "NgoHome"; }
	@RequestMapping(value="/NgoForm") public String displayNgoForm() { return "NgoForm"; }
	
	

	 
	 

	@GetMapping("/addNgo")
	public ModelAndView addNgo()
	{
		return new ModelAndView("adduser","ngo",new Ngo());
	}
	
	@PostMapping("/submitNgoData")
	   public ModelAndView submitcustomerdata(@ModelAttribute("ngo") Ngo ngo) // you can take any method name
	   {
	     ns.addNgoRecord(ngo);
	     
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("NgoLogin");
	     //mv.addObject("name",cust.getUsername());
	     
	     return mv;
	   }
	
	@PostMapping("/NgoUserlogin")
	public String Ngologin(@ModelAttribute("username")String username,@ModelAttribute("password")String password,HttpServletRequest req)
	{  ModelAndView mv=new ModelAndView();
	    List<Ngo> ng = ns.Ngologin(username, password);
	    if(ng.isEmpty())
	    {
	      mv.setViewName("error");
	        return "error";
	    }
	    System.out.println(username+" "+password);
	    HttpSession sess=req.getSession();
	    sess.setAttribute("username",username);
	    sess.setAttribute("name",ng.get(0).getUsername());
	    mv.setViewName("NgoHome");
	  return "redirect:/NgoHome";
	}
	
	@GetMapping("/NgoLogout")
    public String Ngologout(HttpServletRequest req)
    {
        HttpSession sess=req.getSession(false);
    	System.out.println(sess.getAttribute("name"));
    	sess.removeAttribute("name");
    	sess.removeAttribute("email");
    	System.out.println(sess.getAttribute("name"));
    	return "redirect:/index";
    }
	
	
	
	
	//---------------------------------------------Super Admin------------------------------------------------------------------------//
	
	@Autowired
	SuperAdminService sa;
	
	@RequestMapping(value="/Superlogin") public String displaySuperLogin() { 
		sa.addingSuperAdminValues();
		return "superadminlogin"; }
	@RequestMapping(value="/SuperHome") public String displaySuperHome() { return "SuperHome"; }
	
	/*@PostMapping("/superuserlogin")
	public String Superlogin(@ModelAttribute("username")String username,@ModelAttribute("password")String password,HttpServletRequest req)
	{  
		
		ModelAndView mv=new ModelAndView();
	    List<SuperAdmin> sal = sa.Superlogin(username, password);
	    if(sal.isEmpty())
	    {
	      mv.setViewName("error");
	        return "error";
	    }
	    System.out.println(username+" "+password);
	    HttpSession sess=req.getSession();
	    sess.setAttribute("username",username);
	    sess.setAttribute("name",sal.get(0).getUsername());
	    mv.setViewName("SuperHome");
	  return "redirect:/SuperHome";
	}*/
	@PostMapping("/superuserlogin")
	public String Superlogin(@ModelAttribute("username")String username,@ModelAttribute("password")String password,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		String us=username.replaceAll("\\s", "");
		String ps=password.replaceAll("\\s", "");
		boolean ans=sa.SuperLoginCheck(us, ps);
		System.out.print(ans);
		if(ans==false)
		{
			mv.setViewName("error");
	        return "error";
		}
		//System.out.println(username+" "+password);
	    HttpSession sess=req.getSession();
	    sess.setAttribute("username",username);
	    sess.setAttribute("name",username);
	    mv.setViewName("SuperHome");
	  return "redirect:/SuperHome";
		
	}
	
	
	

}
