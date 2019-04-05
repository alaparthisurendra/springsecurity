package com.springsecurity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springsecurity.model.User;
import com.springsecurity.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;

	}
	
	public Optional<User> getUserById(Long uid)
	{
		return userRepository.findById(uid);
		
	}
	
	public User adduser(User user)
	{
		return userRepository.save(user);
	}
	
	public void delete(long uid)
	{
		userRepository.deleteById(uid);
	}

}
