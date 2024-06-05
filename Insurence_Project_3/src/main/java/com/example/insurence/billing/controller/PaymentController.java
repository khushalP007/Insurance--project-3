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

import com.example.insurence.billing.model.PaymentDetailsModel;
import com.example.insurence.billing.service.PaymentService;

@RestController
@RequestMapping("/payementDeatils")
public class PaymentController {
	 @Autowired
	    private PaymentService paymentService;

	    @GetMapping("/getAllPayments")
	    public List<PaymentDetailsModel> getAllPayments() {
	        return paymentService.findAll();
	    }

	    @GetMapping("/getPaymentById/{id}")
	    public ResponseEntity<PaymentDetailsModel> getPaymentById(@PathVariable int id) {
	        Optional<PaymentDetailsModel> payment = paymentService.findById(id);
	        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping("/createPayment")
	    public PaymentDetailsModel createPayment(@RequestBody PaymentDetailsModel payment) {
	        return paymentService.save(payment);
	    }

	    @PutMapping("/updatePayment/{id}")
	    public ResponseEntity<PaymentDetailsModel> updatePayment(@PathVariable int id, @RequestBody PaymentDetailsModel paymentDetails) {
	        Optional<PaymentDetailsModel> payment = paymentService.findById(id);
	        if (payment.isPresent()) {
	        	PaymentDetailsModel updatedPayment = payment.get();
	            updatedPayment.setAmount(paymentDetails.getAmount());
	            updatedPayment.setPaymentMethod(paymentDetails.getPaymentMethod());
	            paymentService.save(updatedPayment);
	            return ResponseEntity.ok(updatedPayment);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/deletePayment/{id}")
	    public ResponseEntity<Void> deletePayment(@PathVariable int id) {
	        if (paymentService.findById(id).isPresent()) {
	            paymentService.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
