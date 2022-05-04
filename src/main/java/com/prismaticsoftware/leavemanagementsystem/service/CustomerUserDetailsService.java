package com.prismaticsoftware.leavemanagementsystem.service;

import com.prismaticsoftware.leavemanagementsystem.entity.UserEntity;
import com.prismaticsoftware.leavemanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomerUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    /**
     *
     * @param username
     * @return user find by Username
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.findByEmailId(username) != null) {
            UserEntity user = userRepository.findByEmailId(username);
            return new User(user.getEmailId(), user.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Not found");
        }
    }
}
