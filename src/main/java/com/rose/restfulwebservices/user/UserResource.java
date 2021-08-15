package com.rose.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserResource {
	@Autowired
	private  UserDaoService service;
	
	@GetMapping("/users")
	public @ResponseBody List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public @ResponseBody User retrieveUser(@PathVariable int id) {
		User usr= service.findOne(id);
		if (usr==null) throw new UserNotFoundException("User Id=" + id + " is not found");
		return usr;
	}
	
	@PostMapping("/users")
	public @ResponseBody User createUser(@RequestBody User user) {
		return service.save(user);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable int id) {
		if (service.delete(id)==false)
			throw new UserNotFoundException("User ID=" + id + " is not found.");
		return;
	}
	
	@GetMapping(path="/test")
	public @ResponseBody String testUser() {
		return "Hello World! I am alive!";
	}
}
