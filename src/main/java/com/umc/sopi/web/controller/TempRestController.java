package com.umc.sopi.web.controller;

import com.umc.sopi.apiPayload.ApiResponse;
import com.umc.sopi.web.converter.TempConverter;
import com.umc.sopi.web.dto.TempResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TempRestController {

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/health")
    public String healthChck() {
        return "health check!";
    }
}