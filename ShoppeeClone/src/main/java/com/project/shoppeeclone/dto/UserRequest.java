package com.project.shoppeeclone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
