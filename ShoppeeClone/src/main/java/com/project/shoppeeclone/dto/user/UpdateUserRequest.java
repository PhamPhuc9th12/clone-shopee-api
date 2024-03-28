package com.project.shoppeeclone.dto.user;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateUserRequest {
    private String fullName;
    private String birthdayString;
    private String gender;
    private String email;
    private String phone;
    private boolean isShop;
}
