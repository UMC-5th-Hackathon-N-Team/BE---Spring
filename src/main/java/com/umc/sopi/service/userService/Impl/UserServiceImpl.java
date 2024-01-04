package com.umc.sopi.service.userService.Impl;

import com.umc.sopi.domain.User;
import com.umc.sopi.repository.UserRepository;
import com.umc.sopi.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    @Transactional
    public void updateWhole() {
        User user = userRepository.findById(1L).orElseThrow(()->
                new IllegalStateException("해당 유저가 존재하지 않습니다."));
        user.wholeAdd();
    }

    @Override
    @Transactional
    public void updateMerit() {
        User user = userRepository.findById(1L).orElseThrow(()->
                new IllegalStateException("해당 유저가 존재하지 않습니다."));
        user.meritAdd();
    }

    @Override
    @Transactional
    public void updateIngredient() {
        User user = userRepository.findById(1L).orElseThrow(()->
                new IllegalStateException("해당 유저가 존재하지 않습니다."));
        user.ingredientAdd();
    }

    @Override
    public Long getWhole(){
        User user = userRepository.findById(1L).orElseThrow(()->
                new IllegalStateException("해당 유저가 존재하지 않습니다."));
        return user.getWhole().longValue();
    }
    @Override
    public Long getMerit(){
        User user = userRepository.findById(1L).orElseThrow(()->
                new IllegalStateException("해당 유저가 존재하지 않습니다."));
        return user.getMerit().longValue();
    }

    @Override
    public Long getIngredient(){
        User user = userRepository.findById(1L).orElseThrow(()->
                new IllegalStateException("해당 유저가 존재하지 않습니다."));
        return user.getIngredient().longValue();
    }
}