package com.umc.sopi.Service.StickerImageService;

import com.umc.sopi.converter.StickerConverter;
import com.umc.sopi.domain.StickerImage;
import com.umc.sopi.domain.User;
import com.umc.sopi.domain.UserSticker;
import com.umc.sopi.repository.StickerImageRepository;
import com.umc.sopi.repository.UserRepository;
import com.umc.sopi.repository.UserStickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
