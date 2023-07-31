package com.cognizant.kotlin.group1.RESTServices.services;

import com.cognizant.kotlin.group1.RESTServices.repository.entity.SkillType;

import java.util.List;

public interface SkillTypeService {
    public List<SkillType> getSkillTypes();
    public SkillType getSkillType(Long id);
}
