package com.example.insurance.policy.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.policy.Repository.PolicyRepository;
import com.example.insurance.policy.model.Policy;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository policyrepo;

	public Policy savePolicy(Policy policy) {

		return policyrepo.save(policy);
	}

	public Optional<Policy> getPolicyById(int policyId) {

		return policyrepo.findById(policyId);
	}

	public String updatePolicyById(Policy policy) {
		Policy existingPolicy= policyrepo.findById(policy.getPolicyId()).orElse(null);
		
		if(existingPolicy==null) {
		  return "not found ";
		}else {
			existingPolicy.setPolicyName(policy.getPolicyName());
			existingPolicy.setStartDate(policy.getStartDate());
			existingPolicy.setEndDate(policy.getEndDate());
			existingPolicy.setNomineeName(policy.getNomineeName());
			existingPolicy.setMaturityDate(policy.getMaturityDate());
			existingPolicy.setPremium(policy.getPremium());
			
			policyrepo.save(existingPolicy);
			
			return "successfully update>>";
		}
	}

	public void deletePolicyById(int policyId) {
		policyrepo.deleteById(policyId);
	}
}
