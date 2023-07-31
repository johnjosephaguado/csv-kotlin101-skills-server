package com.cognizant.kotlin.group1.RESTServices.model;

import lombok.*;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkillInfo {
    private Long skillId;

    private Integer cognizantId;
    private Long skillTypeId;
    private String skillName;
    private Integer years;
    private Long levelType;
    private String levelName;
}
