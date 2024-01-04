package com.umc.sopi.web.controller;

import com.umc.sopi.apiPayload.ApiResponse;
import com.umc.sopi.converter.UserConverter;
import com.umc.sopi.service.userService.UserService;
import com.umc.sopi.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/count")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;

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


}
