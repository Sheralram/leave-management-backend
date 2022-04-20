package com.prismaticsoftware.leavemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * Purpose : To demonstrate various fields of employee in DTo
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 15-12-2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    //private int id;
    @Pattern(regexp = "[A-Z][a-z]{2,}$", message = "Not a Valid Name")
    private String name;

    @Pattern(regexp = "[A-Z][a-z]{2,}$", message = "Not a Valid Leave Type")
    private String leaveType;

    @Size(message = "This should be within 50 letters", max = 50)
    private String notes;

    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$",
            message = "Date should be maintain the format : mm/dd/yyyy")
    private String leaveStartDate;


    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$",
            message = "Date should be maintain the format : mm/dd/yyyy")
    private String leaveEndDate;


    @Pattern(regexp = "[A-Z][a-z]{2,}$", message = "Not a Valid Leave Type")
    private String emailAddress;

}
