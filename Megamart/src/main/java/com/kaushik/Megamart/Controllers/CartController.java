package com.kaushik.Megamart.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kaushik.Megamart.Service.ProductService;
import com.kaushik.Megamart.model.Products;


@Controller
public class CartController {

	@Autowired
	private ProductService productservice;
	
		}

