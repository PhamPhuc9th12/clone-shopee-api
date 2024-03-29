package com.project.shoppeeclone.service.address;

import com.project.shoppeeclone.dto.address.AddressRequest;
import com.project.shoppeeclone.dto.address.AddressResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {
    void createAddress(String accessToken, AddressRequest addressRequest);

     Page<AddressResponse> getAllAddress(String accessToken, Pageable pageable);
}
