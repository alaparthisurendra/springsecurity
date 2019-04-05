package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String username);

}
