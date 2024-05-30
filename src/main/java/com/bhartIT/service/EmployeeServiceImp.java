package com.bhartIT.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhartIT.Exception.BharatItAttendenceException;
import com.bhartIT.dto.EmployeeDto;
import com.bhartIT.entity.Employees;
import com.bhartIT.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImp.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto getEmployee(Integer empNumber) throws BharatItAttendenceException {
        Optional<Employees> optional = employeeRepository.findById(empNumber);
        Employees employee = optional.orElseThrow(() -> new BharatItAttendenceException("Service.employee_NOT_FOUND"));

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setemployeeId(employee.getEmployeeId());
        employeeDto.setEmailId(employee.getEmailId());
        employeeDto.setEmployeeName(employee.getEmployeeName());
        employeeDto.setEmployeePassword(employee.getEmployeePassword());
        employeeDto.setEmpNumber(employee.getEmpNumber());
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() throws BharatItAttendenceException {
        Iterable<Employees> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        employees.forEach(employee -> {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setEmailId(employee.getEmailId());
            employeeDto.setemployeeId(employee.getEmployeeId());
            employeeDto.setEmployeeName(employee.getEmployeeName());
            employeeDto.setEmployeePassword(employee.getEmployeePassword());
            employeeDto.setEmpNumber(employee.getEmpNumber());
            employeeDtos.add(employeeDto);
        });

        if (employeeDtos.isEmpty()) {
            throw new BharatItAttendenceException("Service.employee_NOT_FOUND");
        }

        return employeeDtos;
    }

    @Override
    public boolean authenticateUser(String employeeName, String employeePassword) {
        try {
            Employees employee = employeeRepository.findByEmployeeNameAndEmployeePassword(employeeName, employeePassword);
            return employee != null;
        } catch (Exception e) {
            logger.error("Error during authentication", e);
            throw new RuntimeException("An error occurred during authentication", e);
        }
    }

    @Override
    public Integer addEmployee(EmployeeDto employee) throws BharatItAttendenceException {
        Employees employeesEntity = new Employees();
        employeesEntity.setEmployeeId(employee.getemployeeId());
        employeesEntity.setEmailId(employee.getEmailId());
        employeesEntity.setEmployeeName(employee.getEmployeeName());
        employeesEntity.setEmployeePassword(employee.getEmployeePassword());
        employeesEntity.setEmpNumber(employee.getEmpNumber());

        Employees entity2 = employeeRepository.save(employeesEntity);
        return entity2.getEmployeeId();
    }

	@Override
	public Integer addEmployeePunchIn(EmployeeDto employee) throws BharatItAttendenceException {
		 //               | 
		Employees employeesEntity = new Employees();
		employeesEntity.setEmployeeName(employee.getEmployeeName());
		employeesEntity.setEmailId(employee.getEmailId());
		employeesEntity.setEmpNumber(employee.getEmpNumber());
		employeesEntity.setPunchInDateTime(employee.getPunchInDateTime());
		return null;
	}
}
