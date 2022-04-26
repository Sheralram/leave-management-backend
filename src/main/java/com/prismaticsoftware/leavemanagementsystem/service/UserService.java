package com.prismaticsoftware.leavemanagementsystem.service;

import com.prismaticsoftware.leavemanagementsystem.dto.UserDto;
import com.prismaticsoftware.leavemanagementsystem.entity.UserEntity;
import com.prismaticsoftware.leavemanagementsystem.repository.UserRepository;
import com.prismaticsoftware.leavemanagementsystem.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRegisterRepository;

    @Autowired
    private JwtUtility jwtUtil;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsServiceilsService;

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

    public String newPassword(String token, String newPassword) {
        String emailId = jwtUtil.extractUsername(token);
        UserDetails userDetails = customerUserDetailsServiceilsService.loadUserByUsername(emailId);
        if (jwtUtil.validateToken(token, userDetails)) {
            UserEntity userEntity = userRegisterRepository.findByEmailId(emailId);
            userEntity.setPassword(newPassword);
            userRegisterRepository.save(userEntity);
            return "success";
        } else {
            return "failed";
        }
    }
}
