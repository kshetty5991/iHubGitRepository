package com.kaushik.Megamart.Controllers;

//import java.awt.PageAttributes.MediaType;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kaushik.Megamart.model.Register;
import com.kaushik.Megamart.password.PasswordValidator;
import com.kaushik.Megamart.repository.RegisterRepository;


@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private RegisterRepository repository;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new PasswordValidator());
    }
	@RequestMapping(method = RequestMethod.GET)
	public String homepage()

	{
		System.out.println("In Home page");
		return "home.jsp";
	}
	
	/*@GetMapping(value = "/shop")
	public ModelAndView login() {
	    return new ModelAndView("shop.jsp");
	}*/


	@GetMapping("/register")
	public String registerpage(@ModelAttribute("register") Register reg,ModelMap model)
	{
		System.out.println("In register page");
		//model.addAttribute("command", new Register());
		return "regist.jsp";
	}
	@PostMapping(path ="/regi")
	public String savedata(@Valid Register register,BindingResult result,ModelMap model) {
		if (result.hasErrors()) {

			return "regist.jsp";
		}else
		{

			repository.save(register);

			System.out.println("Entered function");
			model.addAttribute("register",register);
			return "success.jsp";
		}
	}
	
	
}
