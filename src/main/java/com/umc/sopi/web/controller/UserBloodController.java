package com.umc.sopi.web.controller;

import com.umc.sopi.apiPayload.ApiResponse;
import com.umc.sopi.converter.UserBloodConverter;
import com.umc.sopi.domain.UserBlood;
import com.umc.sopi.service.userBloodService.UserBloodService;
import com.umc.sopi.web.dto.UserBloodRequest;
import com.umc.sopi.web.dto.UserBloodResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bloodcard")
@CrossOrigin(origins = "http://localhost:3000")
public class UserBloodController {
    private final UserBloodService userBloodService;
    @PostMapping("/")
    public ApiResponse<UserBloodResponse.RegisterUserBloodResultDTO> createReview(@RequestBody UserBloodRequest.RegisterDTO request){
        UserBlood userBlood = userBloodService.registerBlood(request);
        return ApiResponse.onSuccess(UserBloodConverter.toRegisterUserBloodResultDTO(userBlood));
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserBloodResponse.UserBloodListDTO> createReview(@PathVariable(name = "userId") Long userId){
        List<UserBlood> userBloodList = userBloodService.userBloodList(userId);
        return ApiResponse.onSuccess(UserBloodConverter.userBloodListDTO(userBloodList));
    }

    @GetMapping("/left-day/{userId}")
    public ApiResponse<UserBloodResponse.DayDTO> leftDay(@PathVariable(name = "userId") Long userId) {
        Integer days = userBloodService.leftDayBlood(userId);
        return ApiResponse.onSuccess(UserBloodConverter.dayDTO(days));
    }
}
