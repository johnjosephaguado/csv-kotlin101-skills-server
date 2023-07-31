package com.cognizant.kotlin.group1.RESTServices.services;

import com.cognizant.kotlin.group1.RESTServices.repository.SkillLevelRepository;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.SkillLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillLevelServiceImpl implements SkillLevelService {

    @Autowired
    private SkillLevelRepository repo;
    @Override
    public List<SkillLevel> getSkillLevels() {
        return repo.findAll();
    }

    @Override
    public SkillLevel getSkillLevel(Long id) {
        return repo.findById(id).orElse(SkillLevel.builder().levelId(0L).description("UNKNOWN").build());
    }
}
