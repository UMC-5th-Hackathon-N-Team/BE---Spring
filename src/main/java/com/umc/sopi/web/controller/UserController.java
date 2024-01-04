package com.umc.sopi.web.controller;

import com.umc.sopi.apiPayload.ApiResponse;
import com.umc.sopi.converter.UserConverter;
import com.umc.sopi.service.userService.UserService;
import com.umc.sopi.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final UserService userService;

    @GetMapping("/count/whole")
    public ApiResponse<UserResponse.CountDTO> getWhole(){
        return ApiResponse.onSuccess(UserConverter.toCountResultDTO(userService.getWhole()));
    }
    @GetMapping("/count/merit")
    public ApiResponse<UserResponse.CountDTO> getMerit(){
        return ApiResponse.onSuccess(UserConverter.toCountResultDTO(userService.getMerit()));
    }
    @GetMapping("/count/ingredient")
    public ApiResponse<UserResponse.CountDTO> getIngredient(){
        return ApiResponse.onSuccess(UserConverter.toCountResultDTO(userService.getIngredient()));
    }
    @GetMapping("/count/year")
    public ApiResponse<UserResponse.CountDTO> getYear(){
        return ApiResponse.onSuccess(UserConverter.toCountResultDTO(userService.getIngredient() + userService.getWhole()));
    }

    @GetMapping("/MyPage")
    public ApiResponse<UserResponse.MyPageDTO> getMyPage(){
        return ApiResponse.onSuccess(userService.myPage());

    }
}
