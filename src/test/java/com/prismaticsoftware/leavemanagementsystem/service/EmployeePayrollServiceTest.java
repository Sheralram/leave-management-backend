//package com.prismaticsoftware.leavemanagementsystem.service;
//
//import com.prismaticsoftware.leavemanagementsystem.builder.EmployeePayRollBuilder;
//import com.prismaticsoftware.leavemanagementsystem.dto.EmployeeDto;
//import com.prismaticsoftware.leavemanagementsystem.entity.Employee;
//import com.prismaticsoftware.leavemanagementsystem.exception.NoDataFoundException;
//import com.prismaticsoftware.leavemanagementsystem.repository.EmployeeRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class EmployeePayrollServiceTest {
//
//    private static final String EMPLOYEE_ADDED_SUCCESSULLY = "Employee Record is added Successfully ";
//    private static final String EMPLOYEE_UPDATED_SUCCESSULLY = "Employee Record is updated Successfully ";
//    private static final String EMPLOYEE_DELETED_SUCCESSULLY = "Employee Record is deleted Successfully";
//
//    @InjectMocks
//    private EmployeeService employeeService;
//    @Mock
//    private EmployeeRepository employeeRepository;
//    @Mock
//    private EmployeePayRollBuilder employeePayRollBuilder;
//
//    @Test
//    void whenGetAllEmployeeMethodIsCalled_ShouldReturnListOfEmployeeResponseDto() {
//
//        List<Employee> employeeList = new ArrayList<>();
//
//        Employee employee1 = new Employee();
//        employee1.setName("Ramkrishna");
//        employee1.setGender("Male");
//        employee1.setDepartment("FullStack");
//        employee1.setSalary((long) 56980.35);
//        employee1.setNotes("Regular");
//        employee1.setJoiningDate("11/02/2021");
//        employeeList.add(employee1);
//
//        Employee employee2 = new Employee();
//        employee2.setName("Ronak");
//        employee2.setGender("Male");
//        employee2.setDepartment("Tester");
//        employee2.setSalary((long) 55985.65);
//        employee2.setJoiningDate("15/05/2021");
//        employee2.setNotes("Regular");
//        employeeList.add(employee2);
//
//        when(employeeRepository.findAll()).thenReturn(employeeList);
//        List<Employee> actualList = employeeService.getAllEmployee();
//        assertEquals(2, actualList.size());
//        assertEquals(employeeList, actualList);
//    }
//
//    @Test
//    void WhenFindEmployeeDetailsByIdCalled_ThenIfIdIsNotFound_ShouldThrowException() {
//        int employeeId = 1;
//        when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());
//        assertThrows(NoDataFoundException.class, () -> employeeService.findEmployeeById(employeeId));
//    }
//
//    @Test
//    void whenAddEmployeeEntitiesCalled_ShouldAddEmployeeDetailsAndReturnResponseAndGenerateSuccessMessage() {
//        EmployeeDto employeeDto = new EmployeeDto();
//        Employee employee = new Employee();
//        employeeDto.setName("Ramkrishna");
//        employeeDto.setGender("Male");
//        employeeDto.setDepartment("Electronics");
//        employeeDto.setJoiningDate("18/02/2021");
//        employeeDto.setNotes("Regular");
//        employeeDto.setSalary((long) 86521.56);
//        when(employeePayRollBuilder.buildEmployeePayrollEntity(employeeDto, employee)).thenReturn(employee);
//        String actualValue = employeeService.addEmployee(employeeDto);
//        assertEquals(EMPLOYEE_ADDED_SUCCESSULLY, actualValue);
//    }
//
//    @Test
//    void givenwhenUpdateEmployeeDataCalled_ShouldUpdateEmployeeDataAndReturnSuccessMessage() {
//        int employeeId = 1;
//        ArgumentCaptor<Employee> employeePayrollArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
//        String successMessage = EMPLOYEE_UPDATED_SUCCESSULLY;
//        EmployeeDto employeeDto = new EmployeeDto();
//        //  Employee employee = new Employee();
//        employeeDto.setName("Ramkrishna");
//        employeeDto.setGender("Male");
//        employeeDto.setDepartment("Electronics");
//        employeeDto.setJoiningDate("18/02/2021");
//        employeeDto.setNotes("Regular");
//        employeeDto.setSalary((long) 86521.56);
//
//        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setName("Ramkrishna");
//        employee.setSalary((long) 86521.56);
//        employee.setGender("Male");
//        employee.setDepartment("Electronics");
//        employee.setJoiningDate("18/02/2021");
//        employee.setNotes("Regular");
//
//        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
//        when(employeePayRollBuilder.buildEmployeePayrollEntity(employeeDto, employee)).thenReturn(employee);
//        String actualMessage = employeeService.updateEmployeeById(employeeId, employeeDto);
//        assertEquals(successMessage, actualMessage);
//        verify(employeeRepository, times(1)).save(employeePayrollArgumentCaptor.capture());
//        assertEquals(employee.getName(), employeePayrollArgumentCaptor.getValue().getName());
//        assertEquals(employee.getSalary(), employeePayrollArgumentCaptor.getValue().getSalary());
//        assertEquals(employee.getGender(), employeePayrollArgumentCaptor.getValue().getGender());
//        assertEquals(employee.getDepartment(), employeePayrollArgumentCaptor.getValue().getDepartment());
//        assertEquals(employee.getNotes(), employeePayrollArgumentCaptor.getValue().getNotes());
//    }
//
//    @Test
//    void whenUpdateEmployeeMethodIsCalled_IfNotFoundId_shouldThrowExceptionMessage() {
//        int id = 1;
//        EmployeeDto employeeDto = new EmployeeDto();
//        Employee employee = new Employee();
//        employeeDto.setName("Ramkrishna");
//        employeeDto.setGender("Male");
//        employeeDto.setDepartment("Electronics");
//        employeeDto.setJoiningDate("18/02/2021");
//        employeeDto.setNotes("Regular");
//        employeeDto.setSalary((long) 86521.56);
//        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
//        assertThrows(NoDataFoundException.class, () -> employeeService.updateEmployeeById(id, employeeDto));
//    }
//
//    @Test
//    void givenDeleteEmployeeMethodIsCalledWithAnId_ShouldDeleteTheDataOfThatId() {
//        int id = 1;
//        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setName("Ramkrishna");
//        employee.setSalary((long) 86521.56);
//        employee.setGender("Male");
//        employee.setDepartment("Electronics");
//        employee.setJoiningDate("18/02/2021");
//        employee.setNotes("Regular");
//        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
//        String actualMessage = employeeService.deleteEmployeeById(id);
//        assertEquals(EMPLOYEE_DELETED_SUCCESSULLY, actualMessage);
//    }
//
//
//    @Test
//    void whenDeleteEmployeeMethodIsCalled_IfIdNotFound_shouldThrowExceptionMessage() {
//        int id = 1;
//        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
//        assertThrows(NoDataFoundException.class, () -> employeeService.deleteEmployeeById(id));
//    }
//
//}
