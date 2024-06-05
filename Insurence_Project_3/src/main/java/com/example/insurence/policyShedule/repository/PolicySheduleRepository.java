package com.example.insurence.policyShedule.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.insurence.policyShedule.model.PolicySheduleModel;
public interface PolicySheduleRepository extends JpaRepository <PolicySheduleModel, Long> {

}
