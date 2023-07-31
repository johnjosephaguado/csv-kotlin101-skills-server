package com.cognizant.kotlin.group1.RESTServices.services;

import com.cognizant.kotlin.group1.RESTServices.repository.entity.SkillLevel;

import java.util.List;

public interface SkillLevelService {
    List<SkillLevel> getSkillLevels();
    SkillLevel getSkillLevel(Long id);
}
