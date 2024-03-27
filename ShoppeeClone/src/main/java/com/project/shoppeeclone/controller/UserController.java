package com.project.shoppeeclone.controller;

import com.project.shoppeeclone.dto.UserRequest;
import com.project.shoppeeclone.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "sign-up account")
    @PostMapping("/sign-up")
    public String createAccount(@RequestBody @Valid UserRequest userRequest) {
            return userService.signup(userRequest);
    }

    @Operation(summary = "login account")
    @PostMapping("/login")
    public String login(@RequestBody @Valid UserRequest userRequest){
        return userService.login(userRequest);
    }
}
