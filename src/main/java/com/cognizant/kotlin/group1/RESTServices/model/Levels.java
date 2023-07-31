package com.cognizant.kotlin.group1.RESTServices.model;

import lombok.*;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Levels {
    private Long levelId;

    private String description;
}
