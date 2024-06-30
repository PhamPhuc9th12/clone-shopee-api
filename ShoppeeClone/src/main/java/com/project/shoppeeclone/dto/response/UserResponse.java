package com.project.shoppeeclone.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private Long id;
    private String fullName;
    private String birthdayString;
    private String gender;
    private String email;
    private String address;
    private String phone;
}
