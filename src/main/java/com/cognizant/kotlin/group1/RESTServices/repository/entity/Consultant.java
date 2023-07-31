package com.cognizant.kotlin.group1.RESTServices.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Consultant {

    @Id
    private Integer cognizantId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String designation;
    private String emailAddress;
    private boolean bench;
    private String password;
    private String statusCode;
    private boolean manager;
    private String avatar;
}