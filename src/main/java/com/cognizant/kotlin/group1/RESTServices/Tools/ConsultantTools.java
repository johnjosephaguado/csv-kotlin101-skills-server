package com.cognizant.kotlin.group1.RESTServices.Tools;

import com.cognizant.kotlin.group1.RESTServices.model.ConsultantInfo;
import com.cognizant.kotlin.group1.RESTServices.repository.entity.Consultant;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConsultantTools {

    public synchronized static ConsultantInfo convertToModel(Consultant consultant) {
        if (Objects.isNull(consultant)) return ConsultantInfo.builder().build();
        return ConsultantInfo.builder()
                .cognizantId(consultant.getCognizantId())
                .lastName(consultant.getLastName())
                .firstName(consultant.getFirstName())
                .middleName(consultant.getMiddleName())
                .avatar(consultant.getAvatar())
                .emailAddress(consultant.getEmailAddress())
                .designation(consultant.getDesignation())
                .manager(consultant.isManager())
                .bench(consultant.isBench())
                .password(consultant.getPassword())
                .build();
    }
    public synchronized static List<ConsultantInfo> convertToModel(List<Consultant> consultants){

        return consultants.stream().filter(data -> !Objects.isNull(data))
                .map(ConsultantTools::convertToModel)
                .collect(Collectors.toList());
    }

    public synchronized static void update(Consultant entity, ConsultantInfo dto) {
        entity.setAvatar(dto.getAvatar());
        entity.setBench(dto.isBench());
        entity.setDesignation(dto.getDesignation());
        entity.setEmailAddress(dto.getEmailAddress());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setPassword(dto.getPassword());
    }


}
