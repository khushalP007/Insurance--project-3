package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.Userservice;

@RestController
@RequestMapping("/users")
public class Usercontroller {
	
	@Autowired
	private Userservice userservice;
	
	   @PostMapping("/saveuser")
	    public User createUser(@RequestBody User user) {
	        return userservice.createUser(user);
	    }
	    @GetMapping("/getuser/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        User user = userservice.getUserById(id);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
