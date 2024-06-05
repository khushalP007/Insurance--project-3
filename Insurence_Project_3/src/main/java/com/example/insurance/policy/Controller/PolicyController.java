package com.example.insurance.policy.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.insurance.policy.Service.PolicyService;
import com.example.insurance.policy.model.Policy;


@RestController
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	PolicyService policyservice;

	@PostMapping("/savepolicy")
	public ResponseEntity<Policy> savePolicy(@RequestBody Policy policy) {
		Policy policy1 = policyservice.savePolicy(policy);

		return ResponseEntity.ok().body(policy1);
	}

	@GetMapping("/getpolicy/{policyId}")
	public ResponseEntity<Optional<Policy>> getPolicybyId(@PathVariable int policyId) {
		Optional<Policy> policy1 = policyservice.getPolicyById(policyId);
		return ResponseEntity.ok().body(policy1);
	}

	@PutMapping("/updatepolicy/{premiumId}")
	public String updatePolicyById(@RequestBody Policy policy) {
	    return policyservice.updatePolicyById(policy);     
	
	}
     @DeleteMapping("/delete/{premiumId}")
	public void deletPolicyById(@PathVariable int policyId) {
		policyservice.deletePolicyById(policyId);
	}
}
