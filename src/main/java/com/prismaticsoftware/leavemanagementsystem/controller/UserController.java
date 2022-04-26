package com.prismaticsoftware.leavemanagementsystem.controller;

import com.prismaticsoftware.leavemanagementsystem.dto.ResponseDto;
import com.prismaticsoftware.leavemanagementsystem.dto.UserDto;
import com.prismaticsoftware.leavemanagementsystem.entity.NewPassword;
import com.prismaticsoftware.leavemanagementsystem.entity.UserEntity;
import com.prismaticsoftware.leavemanagementsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
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

    @Autowired
    UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<ResponseDto>addUser(@Valid @RequestBody UserDto userDto) {
        ResponseDto userRegisterResponseDto = new ResponseDto("Added SuccessFully!!", userService.add(userDto));
        return new ResponseEntity<ResponseDto>(userRegisterResponseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-user")
    public ResponseEntity<ResponseDto>getAllEmployee(){
        List<UserEntity> List = userService.getAll();
        ResponseDto userRegisterResponseDto = new ResponseDto("All User!!",List);
        return new ResponseEntity<ResponseDto>(userRegisterResponseDto,HttpStatus.OK);
    }
    @PutMapping("/reset-password")
    public ResponseEntity<ResponseDto>resetPassword(@RequestBody NewPassword newPassword){
        ResponseDto userRegisterResponseDto = new ResponseDto("Reset Password Successfully ",userService.newPassword(newPassword.getToken(),newPassword.getNewPassword()));
        return new ResponseEntity<ResponseDto>(userRegisterResponseDto,HttpStatus.OK);

    }


}
