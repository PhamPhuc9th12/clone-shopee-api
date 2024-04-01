package com.project.shoppeeclone.service.service_interface;

import com.project.shoppeeclone.dto.shop.ShopRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public interface ShopService {

    void createShop(String accessToken, String shopName, MultipartFile image);
}
