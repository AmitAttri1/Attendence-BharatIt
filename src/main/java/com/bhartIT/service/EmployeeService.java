 package com.bhartIT.service;

import java.util.List;

import com.bhartIT.Exception.BharatItAttendenceException;
import com.bhartIT.dto.EmployeeDto;

public interface EmployeeService{
	
	public EmployeeDto getEmployee( Integer employeeId)throws BharatItAttendenceException;
	
	public List<EmployeeDto> getAllEmployee()throws BharatItAttendenceException;
	
	boolean authenticateUser(String employeeName, String employeePassword)throws BharatItAttendenceException;
	 
	 public Integer addEmployee(EmployeeDto employee)throws BharatItAttendenceException;
	 public Integer addEmployeePunchIn(EmployeeDto employee)throws BharatItAttendenceException;
	
	
}


