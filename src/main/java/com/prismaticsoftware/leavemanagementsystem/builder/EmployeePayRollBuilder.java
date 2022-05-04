package com.prismaticsoftware.leavemanagementsystem.builder;

import com.prismaticsoftware.leavemanagementsystem.dto.EmployeeDto;
import com.prismaticsoftware.leavemanagementsystem.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Purpose : Implement builder to handle BeanUtils so that not to ignore boilerPlate not to break dry principle
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */

@Component
public class EmployeePayRollBuilder {

    /**
     * Purpose : This method is used to convert the input of DTO into entity using BeanUtils
     *
     * @param employeeDto defines the field of employee in DTO
     * @param employee defines the field of employee in entity
     * @return the fields of employee in the format of entity
     */
    public Employee buildEmployeePayrollEntity(EmployeeDto employeeDto, Employee employee) {
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }

}
