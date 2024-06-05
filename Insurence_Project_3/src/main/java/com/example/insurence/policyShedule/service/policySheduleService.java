package com.example.insurence.policyShedule.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurence.policyShedule.model.PolicySheduleModel;
import com.example.insurence.policyShedule.repository.PolicySheduleRepository;



@Service
public class policySheduleService {
	@Autowired PolicySheduleRepository policyscheduleRepository;
	
	 public PolicySheduleModel createUser (PolicySheduleModel policyschedule) {
	        return policyscheduleRepository.save(policyschedule);
	    }
	 public PolicySheduleModel getScheduleById(Long id) {
	        return policyscheduleRepository.findById(id).orElse(null);
	    }
	 
	 
}
