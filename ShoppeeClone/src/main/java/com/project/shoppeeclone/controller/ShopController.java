package com.project.shoppeeclone.controller;

import com.project.shoppeeclone.dto.shop.ShopRequest;
import com.project.shoppeeclone.service.service_interface.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/shop")
@AllArgsConstructor
@CrossOrigin
public class ShopController {
    private final ShopService shopService;

    @Operation(summary = "create new shop")
    @PostMapping("/create")
    public void createNewShop(@RequestHeader("Authorization") String accessToken,
                              @RequestParam String shopName,
                              @RequestPart("image") MultipartFile multipartFile ){
        shopService.createShop(accessToken,shopName,multipartFile);
    }
}
