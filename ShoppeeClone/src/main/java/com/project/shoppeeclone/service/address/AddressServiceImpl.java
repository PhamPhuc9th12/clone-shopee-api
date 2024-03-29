package com.project.shoppeeclone.service.address;

import com.project.shoppeeclone.dto.address.AddressRequest;
import com.project.shoppeeclone.dto.address.AddressResponse;
import com.project.shoppeeclone.entity.AddressEntity;
import com.project.shoppeeclone.entity.UserEntity;
import com.project.shoppeeclone.mapper.AddressMapper;
import com.project.shoppeeclone.repository.AddressRepository;
import com.project.shoppeeclone.token.TokenHelper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Transactional
    @Override
    public void createAddress(String accessToken, AddressRequest addressRequest) {
        Long user_id = TokenHelper.getUserIdFromToken(accessToken);
        AddressEntity addressEntity = addressMapper.getEntityFromRequest(addressRequest);
        addressEntity.setUserId(user_id);
        addressRepository.save(addressEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AddressResponse> getAllAddress(String accessToken, Pageable pageable) {
        Long userId = TokenHelper.getUserIdFromToken(accessToken);
        Page<AddressEntity> addressEntities = addressRepository.findAllByUserId(userId,pageable);
        return addressEntities.map(addressMapper::getResponseFrom);
    }
}
