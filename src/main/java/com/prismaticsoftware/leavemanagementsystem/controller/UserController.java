package com.prismaticsoftware.leavemanagementsystem.controller;

import com.prismaticsoftware.leavemanagementsystem.dto.ResponseDto;
import com.prismaticsoftware.leavemanagementsystem.dto.UserDto;
import com.prismaticsoftware.leavemanagementsystem.entity.NewPassword;
import com.prismaticsoftware.leavemanagementsystem.entity.UserEntity;
import com.prismaticsoftware.leavemanagementsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin("*")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<ResponseDto>addUser(@Valid @RequestBody UserDto userDto) {
        logger.info("Entering in addUser");
        UserEntity add =  userService.add(userDto);
        ResponseDto userRegisterResponseDto = new ResponseDto("Added SuccessFully!!", add);
        logger.info("SignUp Added" +add.toString());
        logger.info("Exit in addUser");
        return new ResponseEntity<ResponseDto>(userRegisterResponseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-user")
    public ResponseEntity<ResponseDto>getAllEmployee(){
        logger.info("Entering in getAllEmployee");
        List<UserEntity> List = userService.getAll();
        logger.info("All User" +List.toString());
        ResponseDto userRegisterResponseDto = new ResponseDto("All User!!",List);
        logger.info("Entering in getAllEmployee");
        return new ResponseEntity<ResponseDto>(userRegisterResponseDto,HttpStatus.OK);
    }

    @PutMapping("/reset-password")
    public ResponseEntity<ResponseDto>resetPassword(@RequestBody NewPassword newPassword){
        logger.info("Entering in resetPassword");
        ResponseDto userRegisterResponseDto = new ResponseDto("Reset Password Successfully ",userService.newPassword(newPassword.getToken(),newPassword.getNewPassword()));
        logger.info("Exit in resetPassword");
        return new ResponseEntity<ResponseDto>(userRegisterResponseDto,HttpStatus.OK);
    }


}
