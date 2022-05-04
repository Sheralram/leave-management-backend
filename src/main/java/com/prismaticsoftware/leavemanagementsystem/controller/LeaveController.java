package com.prismaticsoftware.leavemanagementsystem.controller;

import com.prismaticsoftware.leavemanagementsystem.dto.EmployeeDto;
import com.prismaticsoftware.leavemanagementsystem.dto.ResponseDto;
import com.prismaticsoftware.leavemanagementsystem.entity.Employee;
import com.prismaticsoftware.leavemanagementsystem.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Purpose : To demonstrate various HTTP request methods
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */

@RestController
@RequestMapping(value = "/leave-management-system")
@CrossOrigin("*")
public class LeaveController {
    Logger logger= LoggerFactory.getLogger(LeaveController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeService notificationService;

    /**
     * Purpose : This method is used to get list of all the added employee
     *
     * @return the list of employee details
     */

//    @GetMapping("/get-all-employee")
//    public ResponseEntity<ResponseDto> getAllEmployee() {
//        List<Employee> employeePayRollData = employeeService.getAllEmployee();
//        ResponseDto responseDTO = new ResponseDto("Get Call Success", employeePayRollData);
//        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
//    }

    @GetMapping(value = "/get-all-employee")
    public ResponseEntity<List<Employee>> getEmployeeDetails() {
        logger.info("Entering in getEmployeeDetails");
        List<Employee> allEmployee = employeeService.getAllEmployee();
        logger.info("All Details" +allEmployee.toString());
        logger.info("Exit in getEmployeeDetails");
        return new ResponseEntity<>( allEmployee,HttpStatus.OK);

    }
    /**
     * Purpose : This method to add new employee data in employee payroll service
     *
     * @param employeePayrollDto defines the input data of employee in DTO  format
     * @return response message if new employee data is added
     */
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(
            @RequestBody EmployeeDto employeePayrollDto) {
        logger.info("Entering addEmployeePayrollData");
//        employeePayrollDto.setEmailAddress(employeePayrollDto.getEmailAddress());  //Receiver's email address
//        /*
//         * Here we will call sendEmail() for Sending mail to the sender.
//         */
//        try {
//            notificationService.sendEmail(employeePayrollDto);
//        } catch (MailException mailException) {
//           // System.out.println(mailException);
//            logger.info(mailException.toString());
//        }
        String employeePayRollData = employeeService.addEmployee(employeePayrollDto);
        ResponseDto responseDTO = new ResponseDto("Created Employee Payroll Data For ", employeePayRollData);
        logger.info("Exit addEmployeePayrollData ");
        return new ResponseEntity<>("Created Employee Payroll Data For", HttpStatus.OK);
    }
    /**
     * Purpose : This method is used to get the employee data by using particular id
     *
     * @param employeeId defines employee id
     * @return employee data corresponding to the  id
     */
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollDataById(
            @PathVariable int employeeId) {
        logger.info("Entering getEmployeePayrollDataById");
        Employee employeePayRollData = employeeService.findEmployeeById(employeeId);
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id", employeePayRollData);
        logger.info("Exit getEmployeePayrollDataById");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Purpose : This method is used to update the employee data corresponding to the id
     *
     * @param employeeId defines the employee id
     * @param employeeDTO defines the data in DTO format
     * @return message if data is updated successfully
     */

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<String> updateEmployeePayrollById(
            @PathVariable int employeeId,
            @RequestBody EmployeeDto employeeDTO) {
        logger.info("Entering updateEmployeePayrollById");
        String employeePayRollData = employeeService.updateEmployeeById(employeeId, employeeDTO);
        ResponseDto responseDTO = new ResponseDto("Update Employee Payroll Data For ", employeePayRollData);
        logger.info("Exit updateEmployeePayrollById");
        return new ResponseEntity<>("Update Employee Payroll Data For", HttpStatus.OK);
    }

    /**
     * Purpose : This method is used to delete the employee details corresponding to it's id
     *
     * @param employeeId defines employee id
     * @return message if employee details of corresponding id is deleted successfully
     */



    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployeePayroll(
            @PathVariable int employeeId) {
        logger.info("Entering deleteEmployeePayroll");
        employeeService.deleteEmployeeById(employeeId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully", "deleted id: " + employeeId);
        logger.info("Exit deleteEmployeePayroll");
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}

