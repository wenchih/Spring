package com.cs.spring.controller;


import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.spring.model.User;
import com.cs.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUser", this.userService.listPersons());
		System.out.println("list user."); 
		return "User";
	}
	
	//For add and update person both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("user") User p){
		
		if(p.getId() == 0){
			//new person, add it
			this.userService.addPerson(p);
			
		}else{
			//existing person, call update
			this.userService.updatePerson(p);
			
		}		
		return "redirect:/user";
	}	
	

	@RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getPersonById(id));
        model.addAttribute("listUser", this.userService.listPersons());
        return "User";
    }
	
	@RequestMapping("/delete/{id}")
    public String removeUser(@PathVariable("id") int id){		
        this.userService.removePerson(id);
        return "redirect:/user";    
	}
	
	//json example
    @RequestMapping(value="json1/{userid}" ,produces = "application/json;charset=UTF-8",method=RequestMethod.GET)
    @ResponseBody
    public  String json1(@PathVariable("userid") int userid ) {
	   User    p = this.userService.getPersonById(userid);
	 return p.toString();      
    }
    
    
    @RequestMapping(value="json2/{userid}" ,produces = "application/json",method=RequestMethod.GET)      
    @ResponseBody
    public   String json2(@PathVariable("userid") int userid ) throws JsonGenerationException, JsonMappingException, IOException {
	   User    p = this.userService.getPersonById(userid);
	   
	   
	   ObjectMapper mapper = new ObjectMapper();   

	   //Object to JSON in String
	   String jsonInString = mapper.writeValueAsString(p);
	   
	 return jsonInString;      
    }
    
    @RequestMapping(value="json3/{userid}" ,produces = "application/json",method=RequestMethod.GET)      
    @ResponseBody
    public   User json3(@PathVariable("userid") int userid ) throws JsonGenerationException, JsonMappingException, IOException {
	   User    p = this.userService.getPersonById(userid);
		   
	 return p;      
    }
        
    @RequestMapping(value="json4/{userid}" ,produces = "application/json",method=RequestMethod.GET)      
    @ResponseBody
    public   List<User> json4( ) throws JsonGenerationException, JsonMappingException, IOException {
	   List<User>    p = this.userService.listPersons();
		   
	 return p;      
    }
    
   
    
    
    
    
    
    
	 
}
