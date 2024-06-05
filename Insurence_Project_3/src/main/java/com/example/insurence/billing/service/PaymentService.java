package com.example.insurence.billing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurence.billing.model.PaymentDetailsModel;
import com.example.insurence.billing.repositry.PaymentRepository;

@Service
public class PaymentService {
	  @Autowired
	    private PaymentRepository paymentRepository;

	    public List<PaymentDetailsModel> findAll() {
	        return paymentRepository.findAll();
	    }

	    public Optional<PaymentDetailsModel> findById(int id) {
	        return paymentRepository.findById(id);
	    }

	    public PaymentDetailsModel save(PaymentDetailsModel payment) {
	        return paymentRepository.save(payment);
	    }

	    public void deleteById(int id) {
	        paymentRepository.deleteById(id);
	    }
}
