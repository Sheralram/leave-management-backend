package com.prismaticsoftware.leavemanagementsystem.entity;


/**
 * Purpose : To demonstrate Jwt request  with Email And Password
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
public class JwtRequest {

    String emailId;
    String password;

    @Override
    public String toString() {
        return "JwtRequest [emailId=" + emailId + ", password=" + password + "]";
    }

    public JwtRequest(String emailId, String password) {
        super();
        this.emailId = emailId;
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JwtRequest() {

    }
}
