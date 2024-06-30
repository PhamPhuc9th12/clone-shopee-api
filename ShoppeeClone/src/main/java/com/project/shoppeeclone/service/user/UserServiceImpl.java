package com.project.shoppeeclone.service.user;

import com.project.shoppeeclone.cloudinary.CloudinaryHelper;
import com.project.shoppeeclone.common.Common;
import com.project.shoppeeclone.dto.response.UserResponse;
import com.project.shoppeeclone.dto.user.UpdateUserRequest;
import com.project.shoppeeclone.dto.user.UserRequest;
import com.project.shoppeeclone.entity.UserEntity;
import com.project.shoppeeclone.mapper.UserMapper;
import com.project.shoppeeclone.repository.UserRepository;
import com.project.shoppeeclone.token.TokenHelper;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CloudinaryHelper cloudinaryHelper;

    @Override
    @Transactional
    public String signup(UserRequest userRequest) {
        if(Boolean.TRUE.equals(userRepository.findByUserName(userRequest.getUserName()))){
            throw new RuntimeException(Common.USERNAME_IS_EXIST);
        }
        String hasedPassword = BCrypt.hashpw(userRequest.getPassword(),BCrypt.gensalt());
        UserEntity userEntity = new UserEntity();
        UUID uuid = UUID.randomUUID();
        userEntity.setFullName(Common.USER + uuid);
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setPassword(hasedPassword);
        userEntity.setImage(Common.DEFAULT_IMAGE_URL);
        userRepository.save(userEntity);
        return TokenHelper.generateToken(userEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public String login(UserRequest userRequest){
        String userName = userRequest.getUserName();
        UserEntity userEntity = userRepository.findByUserName(userName);
        if(Objects.isNull(userEntity)) throw new RuntimeException(Common.USER_NOT_FOUND);
        String hashedPassword = userEntity.getPassword();
        if(BCrypt.checkpw(userRequest.getPassword(),hashedPassword)){
            return TokenHelper.generateToken(userEntity);
        }else{
            throw new RuntimeException(Common.PASSWORD_IS_WRONG);
        }
    }

    @Override
    @Transactional
    public void updateInformation(String accessToken, UpdateUserRequest updateUserRequest, MultipartFile multipartFile) {
        Long userId = TokenHelper.getUserIdFromToken(accessToken);
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException(Common.USER_NOT_FOUND)
        );
        userMapper.updateUserInformation(userEntity,updateUserRequest);
        userEntity.setBirthday(OffsetDateTime.parse(updateUserRequest.getBirthdayString()));

        userEntity.setImage(cloudinaryHelper.uploadFile(multipartFile));
        userRepository.save(userEntity);
    }

    @Override
    public UserResponse getUserInformation(String accessToken) {
        Long userId = TokenHelper.getUserIdFromToken(accessToken);
        UserEntity userEntity = userRepository.findById(userId).get();
        return userMapper.getUserResponseFrom(userEntity);
    }

}
