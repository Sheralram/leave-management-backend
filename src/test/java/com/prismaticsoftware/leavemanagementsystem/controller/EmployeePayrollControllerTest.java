//package com.prismaticsoftware.leavemanagementsystem.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import com.prismaticsoftware.leavemanagementsystem.dto.EmployeeDto;
//import com.prismaticsoftware.leavemanagementsystem.entity.Employee;
//import com.prismaticsoftware.leavemanagementsystem.service.EmployeeService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class EmployeePayrollControllerTest {
//    @InjectMocks
//    private  EmployeeController employeeController;
//
//    @Mock
//    private EmployeeService employeeService;
//
//    @Test
//    void whenGetAllEmployeeMethodIsCalled_ShouldReturnTheListOfAllEmployeeResponseDto() {
//
//        List<Employee>employee = new ArrayList<>();
//        Employee employee1 = new Employee();
//        employee1.setName("Ramkrishna");
//        employee1.setGender("Male");
//        employee1.setDepartment("FullStack");
//        employee1.setSalary((long) 56980.35);
//        employee1.setNotes("Regular");
//        employee1.setJoiningDate("11/02/2021");
//
//        Employee employee2 = new Employee();
//        employee2.setName("Ronak");
//        employee2.setGender("Male");
//        employee2.setDepartment("Tester");
//        employee2.setSalary((long)55985.65);
//        employee2.setJoiningDate("15/05/2021");
//        employee2.setNotes("Regular");
//
//        String successString = "Get Call Success";
//        int actual = 200;
//
//        when (employeeService.getAllEmployee()).thenReturn(employee);
//        int actualValue = employeeController.getAllEmployee().getStatusCodeValue();
//        assertEquals(actual,actualValue);
//    }
//
//    @Test
//    void whenAddEmployeeMethodIsCalled_ShouldAddEmployeeAndGenerateSuccessMessage(){
//        String successString = "Created Employee Payroll Data For";
//        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successString, HttpStatus.OK);
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setName("Ramkrishna");
//        employeeDto.setGender("Male");
//        employeeDto.setDepartment("FullStack");
//        employeeDto.setSalary((long)569871.36);
//
//        when(employeeService.addEmployee(employeeDto)).thenReturn(successString);
//        ResponseEntity<String>actualResponseString = employeeController.addEmployeePayrollData(employeeDto);
//        assertEquals(expectedResponseEntity, actualResponseString);
//    }
//
//    @Test
//    void whenUpdateEmployeeMethodIsCalled_ShouldUpdateEmployeeAndGenerateSuccessMessage() {
//        String successString = "Update Employee Payroll Data For";
//        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successString, HttpStatus.OK);
//        int id = 1;
//        EmployeeDto employeeDTO = new EmployeeDto();
//        employeeDTO.setName("Ram");
//        employeeDTO.setGender("Male");
//        employeeDTO.setDepartment("FullStack");
//        employeeDTO.setSalary((long)569800.32);
//        employeeDTO.setJoiningDate("15/01/2021");
//        employeeDTO.setNotes("Regular");
//        when(employeeService.updateEmployeeById(id, employeeDTO)).thenReturn(successString);
//        ResponseEntity<String> actualResponseString = employeeController.updateEmployeePayrollById(id, employeeDTO);
//        assertEquals(expectedResponseEntity, actualResponseString);
//    }
//
//    @Test
//    void whenDeleteEmployeeMethodIsCalled_ShouldDeleteEmployeeAndGenerateSuccessMessage() {
//        String successString = "Deleted Successfully";
//        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successString, HttpStatus.OK);
//        int id = 1;
//        when(employeeService.deleteEmployeeById(id)).thenReturn(successString);
//        ResponseEntity<String> actualResponseString = employeeController.deleteEmployeePayroll(id);
//        assertEquals(expectedResponseEntity, actualResponseString);
//    }
//
//
//}
