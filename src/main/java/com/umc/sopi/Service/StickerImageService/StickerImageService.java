package com.umc.sopi.Service.StickerImageService;

import com.umc.sopi.domain.StickerImage;

public interface StickerImageService {

    StickerImage addSticker(Long stickerId, Long userId);

    Long getRamdomStickerId();
}
