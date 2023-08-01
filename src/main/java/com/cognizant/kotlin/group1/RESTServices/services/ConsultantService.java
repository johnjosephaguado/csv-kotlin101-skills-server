package com.cognizant.kotlin.group1.RESTServices.services;

import com.cognizant.kotlin.group1.RESTServices.repository.entity.Consultant;

import java.util.List;

public interface ConsultantService {

    Consultant saveConsultant(Consultant consultant);
    Consultant updateConsultant(Consultant consultant);
    Consultant getConsultant(Integer id);
    List<Consultant> getConsultants();
    List<Consultant> searchBySkillName(String skillName);

}
