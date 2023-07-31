package com.cognizant.kotlin.group1.RESTServices.services;

import com.cognizant.kotlin.group1.RESTServices.repository.entity.Skills;

import java.util.List;

public interface SkillsService {
    List<Skills> getSkills(Integer cognizantId);

    Skills save(Skills entity);
    Skills update(Skills entity);
    void delete(Skills entity);
}
