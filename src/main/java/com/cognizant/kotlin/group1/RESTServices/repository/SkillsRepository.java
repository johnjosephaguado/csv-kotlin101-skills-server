package com.cognizant.kotlin.group1.RESTServices.repository;

import com.cognizant.kotlin.group1.RESTServices.repository.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {

    List<Skills> findAllByCognizantId(Integer cognizantId);
}
