package com.umc.sopi.service.userBloodService;

import com.umc.sopi.domain.UserBlood;
import com.umc.sopi.web.dto.UserBloodRequest;

public interface UserBloodService {
    UserBlood registerBlood(UserBloodRequest.RegisterDTO registerDTO);
}
