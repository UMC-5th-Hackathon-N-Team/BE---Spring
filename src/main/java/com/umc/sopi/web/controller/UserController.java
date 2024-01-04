package com.umc.sopi.web.controller;

import com.umc.sopi.apiPayload.ApiResponse;
import com.umc.sopi.converter.UserBloodConverter;
import com.umc.sopi.converter.UserConverter;
import com.umc.sopi.domain.UserBlood;
import com.umc.sopi.service.userBloodService.UserBloodService;
import com.umc.sopi.service.userService.UserService;
import com.umc.sopi.web.dto.UserBloodRequest;
import com.umc.sopi.web.dto.UserBloodResponse;
import com.umc.sopi.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/count")
public class UserController {
    private final UserService userService;
    private final UserBloodService userBloodService;
    @GetMapping("/whole")
    public ApiResponse<UserResponse.CountDTO> getWhole(){
        return ApiResponse.onSuccess(UserConverter.toCountResultDTO(userService.getWhole()));
    }
    @GetMapping("/merit")
    public ApiResponse<UserResponse.CountDTO> getMerit(){
        return ApiResponse.onSuccess(UserConverter.toCountResultDTO(userService.getMerit()));
    }
    @GetMapping("/ingredient")
    public ApiResponse<UserResponse.CountDTO> getIngredient(){
        return ApiResponse.onSuccess(UserConverter.toCountResultDTO(userService.getIngredient()));
    }
    @GetMapping("/year")
    public ApiResponse<UserResponse.CountDTO> getYear(){
        return ApiResponse.onSuccess(UserConverter.toCountResultDTO(userService.getIngredient() + userService.getWhole()));
    }

    @PostMapping("/bloodcard")
    public ApiResponse<UserBloodResponse.RegisterUserBloodResultDTO> createReview(@RequestBody UserBloodRequest.RegisterDTO request){
        UserBlood userBlood = userBloodService.registerBlood(request);
        return ApiResponse.onSuccess(UserBloodConverter.toRegisterUserBloodResultDTO(userBlood));
    }
}
