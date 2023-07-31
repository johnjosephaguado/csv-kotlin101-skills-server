package com.cognizant.kotlin.group1.RESTServices.model;

import lombok.*;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private Integer cognizantId;
    private String password;
    private String accessCode;
    private String message;
    private ConsultantInfo consultantInfo;
}
