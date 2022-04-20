//package com.prismaticsoftware.leavemanagementsystem.integration;
//
//import com.prismaticsoftware.leavemanagementsystem.controller.EmployeeController;
//import com.prismaticsoftware.leavemanagementsystem.dto.EmployeeDto;
//import com.prismaticsoftware.leavemanagementsystem.service.EmployeeService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(EmployeeController.class)
//public class EmployeeControllerIntegrationTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private EmployeeService employeeService;
//
//
//    @Test
//    void getAllEmployeePayrollData() throws Exception {
//        when(employeeService.getAllEmployee()).thenReturn(new ArrayList<>());
//        mockMvc.perform(MockMvcRequestBuilders.get("/employee-payroll-app/get-all-employee"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void addEmployeePayrollData() throws Exception {
//        when(employeeService.addEmployee(any())).thenReturn("success");
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/employee-payroll-app/create")
//                        .content("{\"department\":\"CSE\",\"gender\":\"ritvik\",\"joiningDate\":\"19/02/2021\",\"name\":\"good\",\"notes\":\"REGULAR\",\"salary\":51530}")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk());
//    }
//
//
//    @Test
//    void updateEmployeePayrollData() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setName("Ramkrishna");
//        employeeDto.setGender("Male");
//        employeeDto.setDepartment("Electronics");
//        employeeDto.setJoiningDate("18/02/2021");
//        employeeDto.setNotes("Regular");
//        employeeDto.setSalary((long) 86521.56);
//        int id = 1;
//        when(employeeService.updateEmployeeById(id, employeeDto)).thenReturn("success");
//        mockMvc.perform(MockMvcRequestBuilders
//                        .put("/employee-payroll-app/update/1")
//                        .content("{\"department\":\"CSE\",\"gender\":\"ritvik\",\"joiningDate\":\"19/02/2021\",\"name\":\"good\",\"notes\":\"REGULAR\",\"salary\":51530}")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk());
//    }
//
//
//    @Test
//    void deleteEmployeePayrollData() throws Exception {
//        when(employeeService.deleteEmployeeById(1)).thenReturn("success");
//        mockMvc.perform(MockMvcRequestBuilders
//                        .delete("/employee-payroll-app/delete/1")
//                        .content("{\"department\":\"CSE\",\"gender\":\"ritvik\",\"joiningDate\":\"19/02/2021\",\"name\":\"good\",\"notes\":\"REGULAR\",\"salary\":51530}")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk());
//    }
//
//
//}
