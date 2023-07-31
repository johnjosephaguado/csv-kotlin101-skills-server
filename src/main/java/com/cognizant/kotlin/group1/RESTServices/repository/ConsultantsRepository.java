package com.cognizant.kotlin.group1.RESTServices.repository;

import com.cognizant.kotlin.group1.RESTServices.repository.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantsRepository extends JpaRepository<Consultant, Integer> {
}
