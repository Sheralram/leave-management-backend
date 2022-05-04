package com.prismaticsoftware.leavemanagementsystem.entity;

import lombok.Data;

/**
 * Purpose : To demonstrate token and newPassword
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
@Data
public class NewPassword {
    private String token;
    private String newPassword;
}
