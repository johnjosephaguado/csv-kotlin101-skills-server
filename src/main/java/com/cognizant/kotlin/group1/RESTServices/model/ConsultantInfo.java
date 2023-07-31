package com.cognizant.kotlin.group1.RESTServices.model
        ;

import lombok.*;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultantInfo {
    private Integer cognizantId;

    private String avatar;
    private String lastName;
    private String firstName;
    private String middleName;
    private String designation;
    private String emailAddress;
    private boolean bench;
    private boolean manager;
    private String password;
}
