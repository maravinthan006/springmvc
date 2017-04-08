package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.RegisterDAO;
import com.niit.model.Register;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterDAO registerdao;

	@RequestMapping(value="Register", method=RequestMethod.GET)
    public ModelAndView sendregister(@ModelAttribute("register") Register register) // (@PathVariable("user") String user, @PathVariable("password") String password)
	{																					//  (@RequestParam("user") String user
		ModelAndView mv=new ModelAndView("Register");
		return mv;
	}
	
	
	@RequestMapping(value="registersave", method=RequestMethod.POST)
    public String getRegister(Register register)
	{
		
		registerdao.addRegister(register);
	/*ModelAndView mv = new ModelAndView("Login", "register", new Register());
		return mv;		
	*/	
		
		return "Login";
	}
	
	@RequestMapping("validate")
	public ModelAndView validateCredentials(Register register, @RequestParam("username") String id, @RequestParam("password") String pwd)
	{
		
		ModelAndView  mv = new ModelAndView("Home");
		List<Register> registerList=registerdao.validate(register);
		if(registerList.size()==0)
		{
			mv.addObject("loginmsg", "Valid Credentials");
			
		}
		else
		{
			mv.addObject("loginmsg", "Invalid Credentials...please try again");
		}
		 return mv;
		}

	
	
}
