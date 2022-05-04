package com.prismaticsoftware.leavemanagementsystem.entity;
/**
 * Purpose : To demonstrate token
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
public class JwtResponse {

    String token;

    public JwtResponse() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse(String token) {

        this.token = token;
    }
}
