package com.cs.spring.controller;

 



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class MainController {
	
	//index
	@RequestMapping(value = "/",produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
    
	
	 
}
