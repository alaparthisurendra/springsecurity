package com.springsecurity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.exception.UserNotFoundException;
import com.springsecurity.model.User;
import com.springsecurity.service.UserService;

@Controller
@RequestMapping("/users")
public class Controllerex {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/home")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage()
	{
		return "logout.jsp";
	}

	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) 
	{
		User adduser = userService.adduser(user);
		if(adduser==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(adduser);
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() throws UserNotFoundException
	{
		List<User> allUsers = userService.getAllUsers();
		if(allUsers==null)
		{
			throw new UserNotFoundException("No Users in DB");
		}
		return ResponseEntity.ok(allUsers);
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<User>> getById(@PathVariable("id") Long uid) throws UserNotFoundException
	{
		Optional<User> userById = userService.getUserById(uid);
		if(userService==null)
		{
			throw new UserNotFoundException("User Id NotFound");
		}
		
		return ResponseEntity.ok(userById);
		
	}
	
}
