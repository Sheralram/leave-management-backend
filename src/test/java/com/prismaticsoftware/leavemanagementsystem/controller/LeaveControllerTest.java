package com.prismaticsoftware.leavemanagementsystem.controller;

import com.prismaticsoftware.leavemanagementsystem.dto.EmployeeDto;
import com.prismaticsoftware.leavemanagementsystem.entity.Employee;
import com.prismaticsoftware.leavemanagementsystem.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LeaveControllerTest {

    @InjectMocks
    private LeaveController leaveController;

    @Mock
    private EmployeeService employeeService;

    @Test
    void whenGetAllEmployeeMethodIsCalled_ShouldReturnTheListOfAllEmployeeResponseDto(){

        List<Employee>employee = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setName("Ramkrishna");
        employee1.setEmailAddress("ramkrishna.sheral@gmail.com");
        employee1.setLeaveType("Medical");
        employee1.setLeaveStartDate("12/04/2022");
        employee1.setLeaveEndDate("16/04/2022");
        employee1.setNotes("Headache");

        Employee employee2 = new Employee();
        employee2.setName("Ronak");
        employee2.setEmailAddress("ronak.sheral@gmail.com");
        employee2.setLeaveType("Vacation");
        employee2.setLeaveStartDate("18/04/2022");
        employee2.setLeaveEndDate("20/04/2022");
        employee2.setNotes("Family trip");

    String successString = "Get Call Success";
    int actual = 200;

    when (employeeService.getAllEmployee()).thenReturn(employee);
    int actualValue = leaveController.getEmployeeDetails().getStatusCodeValue();
    assertEquals(actual,actualValue);
    }

    @Test
    void whenAddLeaveMethodIsCalled_ShouldAddLeaveAndGenerateSuccessMessage(){
    String successString = "Created Employee Payroll Data For";
    ResponseEntity<String> expectedEntity = new ResponseEntity<>(successString, HttpStatus.OK);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Ramkrishna");
        employeeDto.setEmailAddress("ramkrishna.sheral@gmail.com");
        employeeDto.setLeaveType("Medical");
        employeeDto.setLeaveStartDate("27/04/2022");
        employeeDto.setLeaveEndDate("28/04/2022");
        employeeDto.setNotes("Headache");

        when(employeeService.addEmployee(employeeDto)).thenReturn(successString);
        ResponseEntity<String>actualResponseEntity = leaveController.addEmployeePayrollData(employeeDto);
        assertEquals(expectedEntity,actualResponseEntity);
    }



    @Test
    void whenUpdateLeaveMethodISCalled_ShouldUpdateLeaveAndGenerateSuccessMessage(){
        String successString = "Update Employee Payroll Data For";
        ResponseEntity<String> expectedEntity = new ResponseEntity<>(successString, HttpStatus.OK);
        EmployeeDto employeeDto = new EmployeeDto();
        int id=1;
        employeeDto.setName("Ramkrishna");
        employeeDto.setEmailAddress("ramkrishna.sheral@gmail.com");
        employeeDto.setLeaveType("Medical");
        employeeDto.setLeaveStartDate("27/04/2022");
        employeeDto.setLeaveEndDate("28/04/2022");
        employeeDto.setNotes("Headache");

        when(employeeService.updateEmployeeById(id,employeeDto)).thenReturn(successString);
        ResponseEntity<String>actualResponseEntity = leaveController.updateEmployeePayrollById(id,employeeDto);
        assertEquals(expectedEntity,actualResponseEntity);

    }



    @Test
    void  whenDeleteLeaveMethodIsCalled_ShouldDeleteLeaveAndGenerateSuccessString(){
        String successString = "Deleted Successfully";
        ResponseEntity<String> expectedEntity = new ResponseEntity<>(successString, HttpStatus.OK);
        int id =1;
        when(employeeService.deleteEmployeeById(id)).thenReturn(successString);
        ResponseEntity<String>actualResponseEntity = leaveController.deleteEmployeePayroll(id);
        assertEquals(expectedEntity,actualResponseEntity);
    }
}


