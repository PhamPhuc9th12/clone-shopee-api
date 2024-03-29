package com.project.shoppeeclone.mapper;

import com.project.shoppeeclone.dto.address.AddressRequest;
import com.project.shoppeeclone.dto.address.AddressResponse;
import com.project.shoppeeclone.entity.AddressEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {

     AddressEntity getEntityFromRequest(AddressRequest addressRequest);

     AddressResponse getResponseFrom(AddressEntity addressEntity);
}
