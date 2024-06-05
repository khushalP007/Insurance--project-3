package com.example.insurence.billing.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insurence.billing.model.BillModel;
@Repository
public interface BillRepository extends JpaRepository<BillModel, Integer>{

}
