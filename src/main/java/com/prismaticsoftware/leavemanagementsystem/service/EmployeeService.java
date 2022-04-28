package com.prismaticsoftware.leavemanagementsystem.service;

import com.prismaticsoftware.leavemanagementsystem.builder.EmployeePayRollBuilder;
import com.prismaticsoftware.leavemanagementsystem.dto.EmployeeDto;
import com.prismaticsoftware.leavemanagementsystem.entity.Employee;
import com.prismaticsoftware.leavemanagementsystem.exception.NoDataFoundException;
import com.prismaticsoftware.leavemanagementsystem.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

/**
 * Purpose : To implement all the methods in controller class
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
@Service
public class EmployeeService implements IEmployeeService {
    private static final String EMPLOYEE_ADDED_SUCCESSFULLY = "Employee Record is added Successfully ";
    private static final String EMPLOYEE_UPDATED_SUCCESSFULLY = "Employee Record is updated Successfully ";
    private static final String EMPLOYEE_DELETED_SUCCESSFULLY = "Employee Record is deleted Successfully";

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeePayRollBuilder employeePayRollBuilder;


    private JavaMailSender javaMailSender;

    @Autowired
    public EmployeeService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Purpose : This method is used to get list of details of all the employees
     *
     * @return the list of employeed added
     */
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    /**
     * Purpose : This method is used to add the details of employee
     *
     * @param employeeDto defines data added in DTO
     * @return message if data is added successfully;
     */
    @Override
    public String addEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();
        employee = employeePayRollBuilder.buildEmployeePayrollEntity(employeeDto,employee);
        employeeRepository.save(employee);
        logger.info("Employee Added SuccessFully" +employee.toString());
        return EMPLOYEE_ADDED_SUCCESSFULLY;
    }
    public void sendEmail(EmployeeDto employeePayrollDto) throws MailException {
        /*
         * This JavaMailSender Interface is used to send Mail in Spring Boot. This
         * JavaMailSender extends the MailSender Interface which contains send()
         * function. SimpleMailMessage Object is required because send() function uses
         * object of SimpleMailMessage as a Parameter
         */

        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setTo(user.getEmailAddress());
        mail.setTo(employeePayrollDto.getEmailAddress());
        mail.setCc("ramkrishna@prissoft.net");
        mail.setSubject("Leave Application ");
//        mail.setText("Hello sir," +
//                "I am feeling sick ,so request you to grant a holiday leave for me");
        mail.setText(employeePayrollDto.getNotes());

        /*
         * This send() contains an Object of SimpleMailMessage as an Parameter
         */
        javaMailSender.send(mail);
    }
    /**
     * Purpose : This method is used to find the details of employee corresponding to the id
     *
     * @param employeeId defines the id of the employee
     * @return the details of the particular employee
     */
    @Override
    public Employee findEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId).
                orElseThrow(() -> new NoDataFoundException("Employee data not found of this id :" + employeeId));
    }
    /**
     * Purpose : This method is used to update the details of the employee of corresponding id
     *
     * @param employeeId defines employee id
     * @param employeeDto defines the data stores in employee DTO
     * @return the message if updated successfully
     */
    @Override
    public String updateEmployeeById(int employeeId, EmployeeDto employeeDto)  {

        Employee employee = findEmployeeById(employeeId);
        employee = employeePayRollBuilder.buildEmployeePayrollEntity(employeeDto,employee);
        employeeRepository.save(employee);
        logger.info("Employee Updated" +employee.toString());
        return EMPLOYEE_UPDATED_SUCCESSFULLY;
    }
    /**
     * Purpose : This method is used to delete the employee details of corressponding id
     *
     * @param employeeId defines employee id
     * @return message if deleted successfully
     */
    @Override
    public String deleteEmployeeById(int employeeId) {
        Employee employee = findEmployeeById(employeeId);
        employeeRepository.delete(employee);
        logger.info("Employee Deleted" +employee.toString());
        return EMPLOYEE_DELETED_SUCCESSFULLY;
    }

}
