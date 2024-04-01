package com.project.shoppeeclone.dto.shop;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShopRequest {
    private String name;
}
