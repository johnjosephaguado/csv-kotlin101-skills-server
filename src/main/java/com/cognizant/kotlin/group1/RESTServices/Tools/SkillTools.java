package com.cognizant.kotlin.group1.RESTServices.Tools;

import com.cognizant.kotlin.group1.RESTServices.model.SkillInfo;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.Skills;
import com.cognizant.kotlin.group1.RESTServices.services.SkillLevelService;
import com.cognizant.kotlin.group1.RESTServices.services.SkillTypeService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SkillTools {
    public static synchronized SkillInfo convert(SkillLevelService levelService, SkillTypeService typeService, Skills entity){
        return SkillInfo.builder()
                .skillId(entity.getSkillId())
                .skillTypeId(entity.getSkillTypeId())
                .skillName(typeService.getSkillType(entity.getSkillTypeId()).getDescription())
                .levelType(entity.getLevelType())
                .levelName(levelService.getSkillLevel(entity.getLevelType()).getDescription())
                .years(entity.getYears())
                .cognizantId(entity.getCognizantId())
                .build();

    }

    public static synchronized Skills convert(SkillInfo dto) {
        return Skills.builder()
                .skillId(dto.getSkillId())
                .skillTypeId(dto.getSkillTypeId())
                .levelType(dto.getLevelType())
                .years(dto.getYears())
                .cognizantId(dto.getCognizantId())
                .build();
    }

    public static synchronized List<SkillInfo> convert(SkillLevelService levelService, SkillTypeService typeService, List<Skills> entities) {
        return entities.stream().filter(data -> !Objects.isNull(data))
                .map(data->SkillTools.convert(levelService,typeService,data))
                .collect(Collectors.toList());

    }
}
