package com.example.insurence.trafficviolation.repository;

import org.springframework.stereotype.Repository;

import com.example.insurence.trafficviolation.model.Trafficviolation;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TrafficViolationRepository extends JpaRepository<Trafficviolation,Integer> {

}
