package com.prismaticsoftware.leavemanagementsystem;

import com.prismaticsoftware.leavemanagementsystem.controller.LeaveController;
import com.prismaticsoftware.leavemanagementsystem.dto.EmployeeDto;
import com.prismaticsoftware.leavemanagementsystem.entity.Employee;
import com.prismaticsoftware.leavemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LeaveManagementSystem  {
    @Autowired
    private static EmployeeService service;

    private static LeaveController leaveController = new LeaveController();

    public static void main(String[] args) {

        SpringApplication.run(LeaveManagementSystem.class, args);
//        List<Employee> listOfLeaves = (List<Employee>) leaveController.getEmployeeDetails();
//        for (Employee employee : listOfLeaves) {
//            EmployeeDto record = new EmployeeDto();
//            record.setName("Name" + employee.getName());
//            record.setLeaveType(employee.getLeaveType());
//            record.setLeaveStartDate(employee.getLeaveStartDate());
//            record.setLeaveEndDate(employee.getLeaveEndDate());
//            record.setEmailAddress(employee.getEmailAddress());
//            service.addEmployee(record);
//        }


//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return NoOpPasswordEncoder.getInstance();
//	}
    }
}
