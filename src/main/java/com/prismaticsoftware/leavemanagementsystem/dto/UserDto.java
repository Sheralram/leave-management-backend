package com.prismaticsoftware.leavemanagementsystem.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Purpose : To demonstrate fields of User in DTO
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
@Data
public class UserDto {
    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]{3,}$", message= "Name Not In Proper Format")
    public String fullName;

    @NotNull
    public String emailId;

    @NotNull
    public String password;

    @NotNull
    public Long phoneNumber;

    public String role;
}
