package com.example.insurence.trafficviolation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurence.trafficviolation.model.Trafficviolation;
import com.example.insurence.trafficviolation.repository.TrafficViolationRepository;

@Service
public class TrafficViolationService {

	@Autowired
	private TrafficViolationRepository trafRepo; 
	
    public Trafficviolation saveTrafficViolationData(Trafficviolation traf) {
        return trafRepo.save(traf);
    }

    
    public List<Trafficviolation> getAllTrafficviolations() {
        return trafRepo.findAll();
    }

    public Optional<Trafficviolation> getTrafficviolationById(int id) {
        return trafRepo.findById(id);
    }
    
    public Trafficviolation updateTrafficViolationData(Trafficviolation traf) {
        return trafRepo.save(traf);
    }

    public Optional<Trafficviolation> updateTrafficViolationById(int id, Trafficviolation traf) {
        return trafRepo.findById(id).map(existingTraf -> {
            existingTraf.setViolationtype(traf.getViolationtype());
            existingTraf.setVehicleNumber(traf.getVehicleNumber());
            existingTraf.setDriverName(traf.getDriverName());
            existingTraf.setDate(traf.getDate());
            existingTraf.setFineAmount(traf.getFineAmount());
            return trafRepo.save(existingTraf);
        });
    }
    
    public void deleteAllTrafficviolations() {
        trafRepo.deleteAll();
    }

    public void deleteTrafficViolationById(int id) {
        trafRepo.deleteById(id);
    }
}
