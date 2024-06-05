package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PremiumDetail;
import com.example.demo.model.User;
import com.example.demo.repository.PremiumDetailrepository;
import com.example.demo.repository.Userrepository;

@Service
public class Userservice {
	@Autowired
	private Userrepository userrepository;
	@Autowired
    private PremiumDetailrepository premiumDetailRepository;

	
	 public User createUser(User user) {
	        return userrepository.save(user);
	    }
	 public User getUserById(Long id) {
	        return userrepository.findById(id).orElse(null);
	    }
	 public Optional<PremiumDetail> createPremiumDetail(PremiumDetail premiumDetail) {
	        if (premiumDetail.getUser() != null && premiumDetail.getUser().getId() != null) {
	            Optional<User> user = userrepository.findById(premiumDetail.getUser().getId());
	            if (user.isPresent()) {
	                premiumDetail.setUser(user.get());
	                PremiumDetail savedPremiumDetail = premiumDetailRepository.save(premiumDetail);
	                return Optional.of(savedPremiumDetail);
	            } else {
	                return Optional.empty();
	            }
	        } else {
	            return Optional.empty();
	        }
	 }
	 public Optional<PremiumDetail> getPremiumDetailById(Long id) {
	        return premiumDetailRepository.findById(id);
	    }
	 

}
