package com.project.shoppeeclone.service.user;

import com.project.shoppeeclone.dto.UserRequest;
import com.project.shoppeeclone.entity.UserEntity;
import com.project.shoppeeclone.mapper.UserMapper;
import com.project.shoppeeclone.repository.UserRepository;
import com.project.shoppeeclone.service.user.UserService;
import com.project.shoppeeclone.token.TokenHelper;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public String signup(UserRequest userRequest) {
        String hasedPassword = BCrypt.hashpw(userRequest.getPassword(),BCrypt.gensalt());
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setPassword(hasedPassword);
        userRepository.save(userEntity);
        return TokenHelper.generateToken(userEntity);
    }

    @Override
    @Transactional
    public String login(UserRequest userRequest){
        String userName = userRequest.getUserName();
        UserEntity userEntity = userRepository.findByUserName(userName);
        if(Objects.isNull(userEntity)) throw new RuntimeException("User not found");
        String hashedPassword = userEntity.getPassword();
        if(BCrypt.checkpw(userRequest.getPassword(),hashedPassword)){
            return TokenHelper.generateToken(userEntity);
        }else{
            throw new RuntimeException("Password is wrong");
        }
    }
}
