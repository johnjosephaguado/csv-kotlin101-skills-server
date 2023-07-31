package com.cognizant.kotlin.group1.RESTServices.services;

import com.cognizant.kotlin.group1.RESTServices.repository.SkillsRepository;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsRepository repo;

    @Override
    public List<Skills> getSkills(Integer cognizantId) {

        return repo.findAllByCognizantId(cognizantId);
    }

    @Override
    public Skills save(Skills entity) {
        return repo.save(entity);
    }

    @Override
    public Skills update(Skills entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(Skills entity) {
         repo.delete(entity);
    }
}
