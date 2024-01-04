package com.umc.sopi.service.userBloodService.Impl;

import com.umc.sopi.converter.UserBloodConverter;
import com.umc.sopi.domain.User;
import com.umc.sopi.domain.UserBlood;
import com.umc.sopi.repository.UserBloodRepository;
import com.umc.sopi.repository.UserRepository;
import com.umc.sopi.service.userBloodService.UserBloodService;
import com.umc.sopi.web.dto.UserBloodRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserBloodServiceImpl implements UserBloodService {
    private final UserRepository userRepository;
    private final UserBloodRepository userBloodRepository;

    @Transactional
    public UserBlood registerBlood(UserBloodRequest.RegisterDTO registerDTO){
        UserBlood userBlood = UserBloodConverter.toUserBlood(registerDTO);
        User user = userRepository.findById(1L).get();
        userBlood.setUser(user);
        if(userBlood.getType().equals("전혈")){
            user.wholeAdd();
        } else if (userBlood.getType().equals("성분")) {
            user.ingredientAdd();
        }
        user.meritAdd();
        userRepository.save(user);
        return userBloodRepository.save(userBlood);
    }
}
