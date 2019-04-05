package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.model.User;
import com.springsecurity.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	//UserDetails is an Interface
	//create class which will implement UserSetails Interface
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("user not found"); 
		}
		return new UserDetailImplementation(user);
	}

}
