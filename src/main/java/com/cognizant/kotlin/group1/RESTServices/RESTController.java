package com.cognizant.kotlin.group1.RESTServices;

import com.cognizant.kotlin.group1.RESTServices.Tools.ConsultantTools;
import com.cognizant.kotlin.group1.RESTServices.Tools.SkillLevelTools;
import com.cognizant.kotlin.group1.RESTServices.Tools.SkillTools;
import com.cognizant.kotlin.group1.RESTServices.Tools.SkillTypeTools;
import com.cognizant.kotlin.group1.RESTServices.model.*;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.Consultant;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.Skills;
import com.cognizant.kotlin.group1.RESTServices.services.ConsultantService;
import com.cognizant.kotlin.group1.RESTServices.services.SkillLevelService;
import com.cognizant.kotlin.group1.RESTServices.services.SkillTypeService;
import com.cognizant.kotlin.group1.RESTServices.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class RESTController {

    @Autowired
    private ConsultantService consultantService;

    @Autowired
    private SkillLevelService skillLevelService;

    @Autowired
    private SkillTypeService skillTypeService;

    @Autowired
    private SkillsService skillsService;

    @GetMapping("/sanity")
    public String sanity() {
        return "Server is up and running";
    }

    @GetMapping("/demo/getLogin")
    public LoginInfo getLogin() {
        return LoginInfo.builder().cognizantId(2269180).password("test").build();
    }

    @GetMapping("/demo/getSkillInfo")
    public SkillInfo getSkillInfo() {
        return SkillInfo.builder().cognizantId(2269180).build();
    }

    @GetMapping("/api/getLevels")
    public ResponseEntity<List<Levels>> getLevels() {
        return new ResponseEntity<>(SkillLevelTools.convert(skillLevelService.getSkillLevels()), HttpStatus.OK);
    }

    @GetMapping("/api/getSkillTypes")
    public ResponseEntity<List<Types>> getSkillTypes() {
        return new ResponseEntity<>(SkillTypeTools.convert(skillTypeService.getSkillTypes()), HttpStatus.OK);
    }


    @GetMapping("/api/getConsultant/{id}")
    public ResponseEntity<ConsultantInfo> getConsultant(@PathVariable Integer id) {
        return new ResponseEntity<>(ConsultantTools.convertToModel(consultantService.getConsultant(id)), HttpStatus.OK);
    }

    @GetMapping("/api/getConsultant/{id}/skills")
    public ResponseEntity<List<SkillInfo>> getConsultantSkills(@PathVariable Integer id) {
        return new ResponseEntity<>(SkillTools.convert(skillLevelService, skillTypeService, skillsService.getSkills(id)), HttpStatus.OK);
    }

    @GetMapping("/api/getConsultants")
    public ResponseEntity<List<ConsultantInfo>> getConsultants() {
        return new ResponseEntity<>(ConsultantTools.convertToModel(consultantService.getConsultants()), HttpStatus.OK);
    }

    @PutMapping("/api/addConsultant")
    public ResponseEntity<ConsultantInfo> addConsultant(@RequestBody ConsultantInfo info) {
        Consultant newEntity = Consultant.builder().cognizantId(info.getCognizantId()).build();
        ConsultantTools.update(newEntity, info);
        return new ResponseEntity<>(ConsultantTools.convertToModel(consultantService.saveConsultant(newEntity)), HttpStatus.OK);
    }

    @PostMapping("/api/updateConsultant")
    public ResponseEntity<ConsultantInfo> updateConsultant(@RequestBody ConsultantInfo info) {
        Consultant newEntity = consultantService.getConsultant(info.getCognizantId());
        ConsultantTools.update(newEntity, info);
        return new ResponseEntity<>(ConsultantTools.convertToModel(consultantService.updateConsultant(newEntity)), HttpStatus.OK);
    }

    @PostMapping("/api/login")
    public ResponseEntity<LoginInfo> login(@RequestBody LoginInfo login) {
        Consultant consultant = consultantService.getConsultant(login.getCognizantId());
        if (Objects.isNull(consultant)) {
            return new ResponseEntity<>(LoginInfo.builder().accessCode("DENIED").message("INVALID LOGIN ID").cognizantId(login.getCognizantId()).password(login.getPassword()).build(), HttpStatus.FORBIDDEN);
        } else if (consultant.getPassword().compareTo(login.getPassword()) != 0) {
            return new ResponseEntity<>(LoginInfo.builder().accessCode("DENIED").message("INVALID PASSWORD").cognizantId(login.getCognizantId()).password(login.getPassword()).build(), HttpStatus.FORBIDDEN);
        } else if (consultant.getStatusCode().compareTo("A") != 0) {
            return new ResponseEntity<>(LoginInfo.builder().accessCode("DENIED").message("ACCOUNT INACTIVE").cognizantId(login.getCognizantId()).password(login.getPassword()).build(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(LoginInfo.builder().accessCode("GRANTED").message("ACCESS GRANTED").cognizantId(login.getCognizantId()).password(login.getPassword()).consultantInfo(ConsultantTools.convertToModel(consultant)).build(), HttpStatus.OK);
    }

    @PutMapping("/api/addConsultant/skill")
    public ResponseEntity<SkillInfo> addConsultantSkill(@RequestBody SkillInfo info) {
        Skills skills = skillsService.save(SkillTools.convert(info));
        return new ResponseEntity<>(SkillTools.convert(skillLevelService,skillTypeService,skills),HttpStatus.OK);
    }


}
