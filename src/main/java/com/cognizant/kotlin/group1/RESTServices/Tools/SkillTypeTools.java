package com.cognizant.kotlin.group1.RESTServices.Tools;

import com.cognizant.kotlin.group1.RESTServices.model.Types;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.SkillType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SkillTypeTools {
    public static synchronized Types convert(SkillType entity) {
        return Types.builder()
                .typeId(entity.getTypeId())
                .description(entity.getDescription())
                .build();
    }

    public static synchronized List<Types> convert(List<SkillType> entities) {
        return entities.stream().filter(data -> !Objects.isNull(data))
                .map(SkillTypeTools::convert)
                .collect(Collectors.toList());
    }


}
