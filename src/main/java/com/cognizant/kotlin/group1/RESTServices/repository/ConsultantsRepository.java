package com.cognizant.kotlin.group1.RESTServices.repository;

import com.cognizant.kotlin.group1.RESTServices.repository.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultantsRepository extends JpaRepository<Consultant, Integer> {
    @Query(value = "SELECT * FROM CONSULTANT CONSULTANT WHERE COGNIZANT_ID IN (SELECT COGNIZANT_ID FROM SKILLS WHERE SKILL_TYPE_ID  IN (SELECT TYPE_ID FROM SKILL_TYPE WHERE UPPER(DESCRIPTION) LIKE :skillName))", nativeQuery = true)
    List<Consultant> findAllBySkillName(@Param("skillName") String skillName);

}
