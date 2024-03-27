package com.project.shoppeeclone.service.user;

import com.project.shoppeeclone.dto.UserRequest;

public interface UserService {
    String signup(UserRequest userRequest);
    String login(UserRequest userRequest);
}
