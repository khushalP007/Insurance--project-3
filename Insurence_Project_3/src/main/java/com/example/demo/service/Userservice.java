package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.Userrepository;

@Service
public class Userservice {
	@Autowired
	private Userrepository userrepository;
	
	 public User createUser(User user) {
	        return userrepository.save(user);
	    }
	 public User getUserById(Long id) {
	        return userrepository.findById(id).orElse(null);
	    }

}
