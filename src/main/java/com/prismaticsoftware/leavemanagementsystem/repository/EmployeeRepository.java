package com.prismaticsoftware.leavemanagementsystem.repository;

import com.prismaticsoftware.leavemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Purpose : To demonstrate all the fields of EmployeePayroll repository connected with JpaRepository format
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
