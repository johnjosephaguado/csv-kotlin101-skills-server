package com.cognizant.kotlin.group1.RESTServices.services;

import com.cognizant.kotlin.group1.RESTServices.repository.SkillTypeRepository;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.SkillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillTypeServiceImpl implements SkillTypeService {
    @Autowired
    private SkillTypeRepository repo;

    @Override
    public List<SkillType> getSkillTypes() {
        return repo.findAll();
    }

    @Override
    public SkillType getSkillType(Long id) {
        return repo.findById(id).orElse(SkillType.builder().typeId(0l).description("UNKNOWN").build());
    }
}
