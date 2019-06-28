package com.kaushik.Megamart.Controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kaushik.Megamart.Service.ProductService;
import com.kaushik.Megamart.model.Item;
import com.kaushik.Megamart.model.ProductModel;
import com.kaushik.Megamart.model.Products;


@Controller
public class ProductsController {

	@Autowired
	private ProductService productservice;

	@RequestMapping("/shop")
	public ModelAndView home() {
		List<Products> listProduct = productservice.listAll();
		ModelAndView mav = new ModelAndView("shop.jsp");
		mav.addObject("listProduct", listProduct);
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
	    List<Products> result = productservice.search(keyword);
	    ModelAndView mav = new ModelAndView("search.jsp");
	    mav.addObject("result", result);
	 
	    return mav;    
	}
	@RequestMapping(value = "/cart/buy/{id}",method = RequestMethod.GET)
	public String index() {
		return "cart.jsp";
	}

}

