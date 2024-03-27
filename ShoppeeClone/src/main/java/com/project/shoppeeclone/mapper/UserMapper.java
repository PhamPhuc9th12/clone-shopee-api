package com.project.shoppeeclone.mapper;

import com.project.shoppeeclone.dto.UserRequest;
import com.project.shoppeeclone.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserEntity getEntityFromInput(UserRequest userRequest);
}
