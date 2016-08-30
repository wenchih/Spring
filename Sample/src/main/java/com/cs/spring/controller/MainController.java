package com.cs.spring.controller;

 



import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.spring.model.User;
@Controller
@RequestMapping("/")
public class MainController  extends ControllerExtend{
	//index
	@RequestMapping(value = "",produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
    
	@RequestMapping(value="json/{userid}" ,produces = "application/json",method=RequestMethod.GET)      
    @ResponseBody
    public   List<User> json4( ) throws JsonGenerationException, JsonMappingException, IOException {
	   List<User>    p = this.userService.list();
		   
	 return p;      
    }
	 
	
	
}
