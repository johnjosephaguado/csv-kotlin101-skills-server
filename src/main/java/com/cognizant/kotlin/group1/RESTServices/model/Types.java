package com.cognizant.kotlin.group1.RESTServices.model;

import lombok.*;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Types {
    private Long typeId;

    private String description;
}

