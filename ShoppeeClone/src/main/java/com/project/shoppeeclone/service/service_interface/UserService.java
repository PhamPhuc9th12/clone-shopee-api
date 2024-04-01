package com.project.shoppeeclone.service.service_interface;

import com.project.shoppeeclone.dto.user.UpdateUserRequest;
import com.project.shoppeeclone.dto.user.UserRequest;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    String signup(UserRequest userRequest);
    String login(UserRequest userRequest);
    void updateInformation(String accessToken, UpdateUserRequest updateUserRequest, MultipartFile multipartFile);
    String changePassword(String accessToken, String newPassword);
}
