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
    private String district;
    private String county;
    private String commune;
    private String addressDetail;
    private String nameReceive;
    private String phone;
    private boolean isDefault;
}
