package com.example.insurence.trafficviolation.controller;

import java.util.List;
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

import com.example.insurence.trafficviolation.model.Trafficviolation;
import com.example.insurence.trafficviolation.service.TrafficViolationService;

@RestController
@RequestMapping("/traffic")
public class TrafficviolationController {

	@Autowired
	private TrafficViolationService trafServ;

	@PostMapping("/save")
	public ResponseEntity<Trafficviolation>  saveTrafficviolation(@RequestBody Trafficviolation traf ) {
		System.out.println("HII");
		Trafficviolation saveTraf = trafServ.saveTrafficViolationData(traf);
		return ResponseEntity.ok().body(saveTraf);
	}
	
	
    @GetMapping("/getAll")
    public ResponseEntity<List<Trafficviolation>> getAllTrafficviolations() {
    	System.out.println("HII");
        List<Trafficviolation> traffics = trafServ.getAllTrafficviolations();
        return ResponseEntity.ok().body(traffics);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Trafficviolation> getTrafficviolationById(@PathVariable int id) {
    	System.out.println("HII");
        Optional<Trafficviolation> traffic = trafServ.getTrafficviolationById(id);
        return traffic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
    @PutMapping("/updateTrafficviolationDetails")
    public ResponseEntity<Trafficviolation> updateTrafficviolation(@RequestBody Trafficviolation traf) {
        Trafficviolation updateTraf = trafServ.updateTrafficViolationData(traf);
        return ResponseEntity.ok().body(updateTraf);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Trafficviolation> updateTrafficviolationById(@PathVariable int id, @RequestBody Trafficviolation traf) {
        Optional<Trafficviolation> updatedTraf = trafServ.updateTrafficViolationById(id, traf);
        return updatedTraf.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllTrafficviolations() {
        trafServ.deleteAllTrafficviolations();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteTrafficviolationById(@PathVariable int id) {
        trafServ.deleteTrafficViolationById(id);
        return ResponseEntity.ok().build();
    }
}
