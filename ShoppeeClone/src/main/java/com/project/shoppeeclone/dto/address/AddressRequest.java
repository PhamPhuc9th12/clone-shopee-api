package com.project.shoppeeclone.dto.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressRequest {

    private String tinh;
    private String quan;
    private String xa;
    private String addressDetail;
    private String nameReceive;
    private String phone;
    @Pattern(regexp = "^(HOME|OFFICE)")
    private String type;
    private boolean isDefault;
}
