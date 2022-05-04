package com.prismaticsoftware.leavemanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;
/**
 * Purpose : To demonstrate all the fields of employee in the entity database format
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMP_ID")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "leaveType")
    private String leaveType;

    @Column(name = "notes")
    private String notes;

    @Column(name = "leaveStartDate")
    private String leaveStartDate;

    @Column(name = "leaveEndDate")
    private String leaveEndDate;

    @Column(name = "emailAddress")
    private String emailAddress;


    public Employee(int id, String name, String leaveType, String notes, String leaveStartDate, String leaveEndDate, String emailAddress) {
        this.id = id;
        this.name = name;
        this.leaveType = leaveType;
        this.notes = notes;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.emailAddress = emailAddress;
    }



//        private List <Leave> leaves;

    public Employee() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(String leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public String getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(String leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


//    @Column(name = "NAME")
//    private String name;
//
//    @Column(name = "GENDER")
//    private String gender;
//
//    private String department;
//
//    @Column(name = "START_DATE")
//    private String joiningDate;
//
//    @Column(name = "SALARY")
//    private long salary;
//
//    @Column(name = "NOTES")
//    private String notes;
}
