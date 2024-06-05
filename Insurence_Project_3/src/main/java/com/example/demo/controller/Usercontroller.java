package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PremiumDetail;
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
	    @PostMapping("/premiumDetails")
	    public ResponseEntity<PremiumDetail> createPremiumDetail(@RequestBody PremiumDetail premiumDetail) {
	        Optional<PremiumDetail> createdPremiumDetail = userservice.createPremiumDetail(premiumDetail);
	        return createdPremiumDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
	    }
	   

	    @GetMapping("/premiumDetails/{id}")
	    public ResponseEntity<PremiumDetail> getPremiumDetailById(@PathVariable Long id) {
	        Optional<PremiumDetail> premiumDetail = userservice.getPremiumDetailById(id);
	        return premiumDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

}
