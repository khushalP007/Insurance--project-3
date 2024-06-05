package com.example.insurence.billing.controller;

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

import com.example.insurence.billing.model.BillModel;
import com.example.insurence.billing.service.BillService;

@RestController
@RequestMapping("/billing")
public class BillController {
	 @Autowired
	    private BillService billService;

	    @GetMapping("/getAllBills")
	    public List<BillModel> getAllBills() {
	        return billService.findAll();
	    }

	    @GetMapping("getBillById/{id}")
	    public ResponseEntity<BillModel> getBillById(@PathVariable int id) {
	        Optional<BillModel> bill = billService.findById(id);
	        return bill.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping("/createBill")
	    public BillModel createBill(@RequestBody BillModel bill) {
	        return billService.save(bill);
	    }

	    @PutMapping("/updateBill/{id}")
	    public ResponseEntity<BillModel> updateBill(@PathVariable int id, @RequestBody BillModel billDetails) {
	        Optional<BillModel> bill = billService.findById(id);
	        if (bill.isPresent()) {
	        	BillModel updatedBill = bill.get();
	            updatedBill.setCustomerName(billDetails.getCustomerName());
	            updatedBill.setAmount(billDetails.getAmount());
	            billService.save(updatedBill);
	            return ResponseEntity.ok(updatedBill);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/deleteBill/{id}")
	    public ResponseEntity<Void> deleteBill(@PathVariable int id) {
	        if (billService.findById(id).isPresent()) {
	            billService.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
