package com.cognizant.kotlin.group1.RESTServices.services;

import com.cognizant.kotlin.group1.RESTServices.repository.ConsultantsRepository;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.Consultant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantServiceImpl implements ConsultantService{

    @Autowired
    private ConsultantsRepository repo;

    @Override
    public Consultant saveConsultant(Consultant consultant) {
        return repo.save(consultant);
    }

    @Override
    public Consultant updateConsultant(Consultant consultant) {
        return repo.save(consultant);
    }

    @Override
    public Consultant getConsultant(Integer id) {
        return repo.findById(id).orElse(Consultant.builder().build());
    }

    @Override
    public List<Consultant> getConsultants() {
        return repo.findAll();
    }
}
