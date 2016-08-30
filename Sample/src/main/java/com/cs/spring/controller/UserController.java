package com.cs.spring.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.spring.model.User;

@Controller
@RequestMapping("/user")
public class UserController extends ControllerExtend {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUser", this.userService.list());
		System.out.println("list user.");
		return "User";
	}

	// For add and update person both
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("user") User p) {
		Date timestamp = new Date();

		try {

			p.setTimestamp(timestamp);

		} catch (Exception e) {

		}

		if (p.getId() == 0) {
			// new person, add it
			this.userService.add(p);

		} else {
			// existing person, call update
			this.userService.update(p);

		}
		return "redirect:/user";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.getById(id));
		model.addAttribute("listUser", this.userService.list());
		return "User";
	}

	@RequestMapping("/delete/{id}")
	public String removeUser(@PathVariable("id") int id) {
		this.userService.removeById(id);
		return "redirect:/user";
	}

	@RequestMapping(value = "/removeall", method = RequestMethod.GET)
	@ResponseBody
	public String deleteall() {

		this.userService.removeAll();
		return "success";
	}

	// json example
	@RequestMapping(value = "json1/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String json1(@PathVariable("userid") int userid) {
		User p = this.userService.getById(userid);
		return p.toString();
	}

	@RequestMapping(value = "json2/{id}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public String json2(@PathVariable("userid") int userid)
			throws JsonGenerationException, JsonMappingException, IOException {
		User p = this.userService.getById(userid);
		ObjectMapper mapper = new ObjectMapper();
		// Object to JSON in String
		String jsonInString = mapper.writeValueAsString(p);
		return jsonInString;
	}

	@RequestMapping(value = "json3/{id}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public User json3(@PathVariable("userid") int userid)
			throws JsonGenerationException, JsonMappingException, IOException {
		User p = this.userService.getById(userid);
		return p;
	}

	@RequestMapping(value = "json4/list", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public List<User> json4() throws JsonGenerationException, JsonMappingException, IOException {
		List<User> p = this.userService.list();

		return p;
	}

	@RequestMapping(value = "json4/{userid}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getbyuserid(@PathVariable("userid") int userid)throws JsonGenerationException, JsonMappingException, IOException {
		List<User> p = this.userService.getByUserid(userid);

		return p;
	}

}
