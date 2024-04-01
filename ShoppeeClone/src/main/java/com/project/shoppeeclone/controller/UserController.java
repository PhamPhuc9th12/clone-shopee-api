package com.project.shoppeeclone.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.shoppeeclone.dto.user.UpdateUserRequest;
import com.project.shoppeeclone.dto.user.UserRequest;
import com.project.shoppeeclone.service.service_interface.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Operation(summary = "change information user")
    @PutMapping(value = "/update", consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public void changeInforUser(@RequestHeader("Authorization") String accessToken,
                                @RequestPart("updateInforString") String updateUserRequestString,
                                @RequestPart("image") MultipartFile multipartFile) throws JsonProcessingException {
        UpdateUserRequest updateUserRequest;
        ObjectMapper objectMapper = new ObjectMapper();
        updateUserRequest = objectMapper.readValue(updateUserRequestString, UpdateUserRequest.class);
        userService.updateInformation(accessToken,updateUserRequest,multipartFile);
    }

    @Operation(summary = "change password")
    @PutMapping("password-change")
    public String changePassword(@RequestHeader("Authorization") String accessToken,
                                 @RequestParam String newPassword){
        return userService.changePassword(accessToken,newPassword);
    }
}
