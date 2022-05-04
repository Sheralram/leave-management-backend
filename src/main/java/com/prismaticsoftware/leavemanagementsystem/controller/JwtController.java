package com.prismaticsoftware.leavemanagementsystem.controller;

import com.prismaticsoftware.leavemanagementsystem.entity.JwtRequest;
import com.prismaticsoftware.leavemanagementsystem.entity.JwtResponse;
import com.prismaticsoftware.leavemanagementsystem.service.CustomerUserDetailsService;
import com.prismaticsoftware.leavemanagementsystem.utility.JwtUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Purpose : Generating Token  with the emailId and password of the SignUp Credentials
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */

//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin("*")
@RestController
public class JwtController {

    Logger logger= LoggerFactory.getLogger(JwtController.class);
    @Autowired
    private CustomerUserDetailsService customUserDeatilsService;

    @Autowired
    private JwtUtility jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    @CrossOrigin(origins = "*")
    @RequestMapping(value= "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
//        System.out.println(jwtRequest);
        logger.info(jwtRequest.toString());
        try {
            this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmailId(), jwtRequest.getPassword()));

        }catch(UsernameNotFoundException e) {
            e.printStackTrace();
//            System.out.println(jwtRequest);
            logger.info(jwtRequest.toString());
            throw new Exception("wrong");
        }catch(BadCredentialsException e) {
            e.printStackTrace();
//            System.out.println(jwtRequest);
            logger.info(jwtRequest.toString());
            throw new Exception("wrong!");
        }

        UserDetails userDetails = this.customUserDeatilsService.loadUserByUsername(jwtRequest.getEmailId());
        String token=this.jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }
}
