package com.prismaticsoftware.leavemanagementsystem.service;

import com.prismaticsoftware.leavemanagementsystem.dto.UserDto;
import com.prismaticsoftware.leavemanagementsystem.entity.UserEntity;
import com.prismaticsoftware.leavemanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRegisterRepository;

    public UserEntity add(UserDto userDto) {
        UserEntity registerUSer = userRegisterRepository.findByEmailId(userDto.emailId);
        UserEntity userEntity = new UserEntity(userDto);
        if(registerUSer == null){
            userRegisterRepository.save(userEntity);
            return userEntity;
        }
            return null;
    }

    public List<UserEntity> getAll() {
        return userRegisterRepository.findAll();
    }
}
