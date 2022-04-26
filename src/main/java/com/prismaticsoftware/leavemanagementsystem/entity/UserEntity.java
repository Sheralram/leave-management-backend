package com.prismaticsoftware.leavemanagementsystem.entity;

import com.prismaticsoftware.leavemanagementsystem.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="User")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String emailId;
    private String password;
    private Long phoneNumber;
    private String role;

    public UserEntity(UserDto userDto) {
        super();
        this.id = id;
        this.fullName=userDto.fullName;
        this.emailId=userDto.emailId;
        this.password=userDto.password;
        this.phoneNumber=userDto.phoneNumber;
        this.role=userDto.role;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public UserEntity(int id, String fullName, String emailId, String password, Long phoneNumber, String role) {
        this.id = id;
        this.fullName = fullName;
        this.emailId = emailId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

}
