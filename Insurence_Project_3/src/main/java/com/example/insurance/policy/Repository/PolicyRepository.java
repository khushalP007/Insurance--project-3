package com.example.insurance.policy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.insurance.policy.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

	Policy save(Policy policy);

}
