package com.project.shoppeeclone.service.service_implement;

import com.project.shoppeeclone.cloudinary.CloudinaryHelper;
import com.project.shoppeeclone.common.Common;
import com.project.shoppeeclone.entity.ShopEntity;
import com.project.shoppeeclone.entity.UserEntity;
import com.project.shoppeeclone.repository.ShopRepository;
import com.project.shoppeeclone.repository.UserRepository;
import com.project.shoppeeclone.service.service_interface.ShopService;
import com.project.shoppeeclone.token.TokenHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;
    private final CloudinaryHelper cloudinaryHelper;
    @Override
    @Transactional
    public void createShop(String accessToken, String shopName, MultipartFile image) {
        Long userId = TokenHelper.getUserIdFromToken(accessToken);
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException(Common.USER_NOT_FOUND)
        );
        if(Objects.nonNull(shopRepository.getByName(shopName))){
            throw new RuntimeException(Common.CAN_NOT_DO);
        }
        userEntity.setIsShop(true);
        userRepository.save(userEntity);
        ShopEntity shopEntity = ShopEntity.builder()
                .name(shopName)
                .image(cloudinaryHelper.uploadFile(image))
                .createdAt(OffsetDateTime.now())
                .rating(0)
                .followCount(0L)
                .productCount(0L)
                .userId(userId)
                .build();
        shopRepository.save(shopEntity);
    }


}
