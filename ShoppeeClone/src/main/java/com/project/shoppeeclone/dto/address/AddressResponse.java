package com.project.shoppeeclone.dto.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressResponse {
    private String tinh;
    private String quan;
    private String xa;
    private String addressDetail;
    private String nameReceive;
    private String phone;
    private boolean isDefault;
}
