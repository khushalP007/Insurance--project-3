package com.example.insurence.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurence.billing.model.BillModel;
import com.example.insurence.billing.repositry.BillRepository;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {
	@Autowired
    private BillRepository billRepository;

    public List<BillModel> findAll() {
        return billRepository.findAll();
    }

    public Optional<BillModel> findById(int id) {
        return billRepository.findById(id);
    }

    public BillModel save(BillModel bill) {
        return billRepository.save(bill);
    }

    public void deleteById(int id) {
        billRepository.deleteById(id);
    }
}
