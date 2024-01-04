package com.umc.sopi.converter;

import com.umc.sopi.web.dto.UserResponse;

public class UserConverter {
    public static UserResponse.CountDTO toCountResultDTO(Long count){
        return UserResponse.CountDTO.builder()
                .count(count)
                .build();
    }
}
