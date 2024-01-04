package com.umc.sopi.converter;

import com.umc.sopi.domain.UserBlood;
import com.umc.sopi.web.dto.UserBloodRequest;
import com.umc.sopi.web.dto.UserBloodResponse;

import java.time.LocalDateTime;

public class UserBloodConverter {
    public static UserBlood toUserBlood(UserBloodRequest.RegisterDTO request){
        return UserBlood.builder()
                .number(request.getNumber())
                .location(request.getLocation())
                .date(request.getDate())
                .type(request.getType())
                .build();
    }
    public static UserBloodResponse.RegisterUserBloodResultDTO toRegisterUserBloodResultDTO(UserBlood userBlood){
        return UserBloodResponse.RegisterUserBloodResultDTO.builder()
                .date(userBlood.getDate())
                .location(userBlood.getLocation())
                .number(userBlood.getNumber())
                .type(userBlood.getType())
                .build();
    }
}
