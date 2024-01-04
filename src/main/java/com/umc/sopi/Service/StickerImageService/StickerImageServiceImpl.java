package com.umc.sopi.Service.StickerImageService;

import com.umc.sopi.converter.StickerConverter;
import com.umc.sopi.domain.StickerImage;
import com.umc.sopi.domain.User;
import com.umc.sopi.domain.UserSticker;
import com.umc.sopi.repository.StickerImageRepository;
import com.umc.sopi.repository.UserRepository;
import com.umc.sopi.repository.UserStickerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StickerImageServiceImpl implements StickerImageService{

    private final StickerImageRepository stickerImageRepository;
    private final UserRepository userRepository;
    private final UserStickerRepository userStickerRepository;

    @Override
    @Transactional
    public StickerImage addSticker(Long stickerId, Long userId) {
        StickerImage image = stickerImageRepository.findById(stickerId).get();
        User user = userRepository.findById(userId).get();
        UserSticker userSticker = StickerConverter.toUserSticker(image, user);
        userStickerRepository.save(userSticker);
        return image;
    }

    @Override
    public Long getRamdomStickerId() {
        // 1. 랜덤 기준점 설정
        final double pivot = Math.random();
        int rank = 0;
        double num =0.0;
        double[] probabilities = {0.1,0.2,0.25,0.45};
        for (int i=1;i<5;i++){
            num += probabilities[i-1];
            if(pivot <= num){
                rank = i-1;
                break;
            }
        }

        long[][] arr = {{2,4},{1,5,6,8,10},{3,9},{7}};
        Random random = new Random();
        int randomIndex = random.nextInt(arr[rank].length);

        return arr[rank][randomIndex];
    }
}
