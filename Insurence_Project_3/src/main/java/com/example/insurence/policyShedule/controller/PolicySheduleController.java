package com.example.insurence.policyShedule.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.insurence.policyShedule.model.PolicySheduleModel;
import com.example.insurence.policyShedule.service.policySheduleService;






@RestController
@RequestMapping("/policy")

public class PolicySheduleController {
	@Autowired
	private  policySheduleService  policyscheduleService;
	 @PostMapping("/shcedule")
	    public PolicySheduleModel createUser(@RequestBody  PolicySheduleModel  policyschedule) {
	        return policyscheduleService.createUser(policyschedule);
	    }
	 @GetMapping("/getpolicyschedule/{id}")
	    public ResponseEntity<PolicySheduleModel> getScheduleById(@PathVariable Long id) {
		 PolicySheduleModel policyschedule = policyscheduleService.getScheduleById(id);
	        if (policyschedule != null) {
	            return ResponseEntity.ok(policyschedule);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
}
}
