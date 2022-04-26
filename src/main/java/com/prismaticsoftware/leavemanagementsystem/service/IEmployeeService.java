package com.prismaticsoftware.leavemanagementsystem.service;

import com.prismaticsoftware.leavemanagementsystem.dto.EmployeeDto;
import com.prismaticsoftware.leavemanagementsystem.entity.Employee;

import java.util.List;
/**
 * Purpose : To implement all the methods of service class
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
public interface IEmployeeService {

    public List<Employee> getAllEmployee();

    public String addEmployee(EmployeeDto employeeDto);

    public Employee findEmployeeById(int employeeId);

    public String updateEmployeeById(int employeeId, EmployeeDto employeeDto);

    public String deleteEmployeeById(int employeeId);
}
