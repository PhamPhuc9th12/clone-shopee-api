package com.project.shoppeeclone.mapper;

import com.project.shoppeeclone.dto.user.UpdateUserRequest;
import com.project.shoppeeclone.dto.user.UserRequest;
import com.project.shoppeeclone.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {
    UserEntity getEntityFromInput(UserRequest userRequest);
    UserEntity updateUserInformation( @MappingTarget UserEntity userEntity, UpdateUserRequest updateUserRequest);
}
