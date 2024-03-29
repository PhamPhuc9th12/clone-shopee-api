package com.project.shoppeeclone.controller;

import com.project.shoppeeclone.dto.address.AddressRequest;
import com.project.shoppeeclone.dto.address.AddressResponse;
import com.project.shoppeeclone.service.address.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @Operation(summary = "create address")
    @PostMapping("/create")
    public void createAddressForUser(@RequestHeader("Authorization") String accessToken,
                                     @RequestBody @Valid  AddressRequest addressRequest){
        addressService.createAddress(accessToken,addressRequest);
    }

    @Operation(summary = "get list address")
    @GetMapping("/list-address")
    public Page<AddressResponse> getListAddress(@RequestHeader("Authorization") String accessToken,
                                                @ParameterObject Pageable pageable){
        return addressService.getAllAddress(accessToken,pageable);
    }
}
