package com.cognizant.kotlin.group1.RESTServices.Tools;

import com.cognizant.kotlin.group1.RESTServices.model.Levels;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.SkillLevel;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SkillLevelTools {

    public static synchronized Levels convert(SkillLevel entity) {
        return  Levels.builder()
                .levelId(entity.getLevelId())
                .description(entity.getDescription())
                .build();
    }
    public static synchronized List<Levels> convert(List<SkillLevel> entities) {
        return entities.stream().filter(data -> !Objects.isNull(data))
                .map(SkillLevelTools::convert)
                .collect(Collectors.toList());
    }
}
