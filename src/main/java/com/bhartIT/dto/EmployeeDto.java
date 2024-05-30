package com.bhartIT.dto;

import java.sql.Timestamp;

public class EmployeeDto {
	private Integer employeeId;
	private String employeeName;
	private String employeePassword;
	private String emailId;
	private String empNumber;
	private Timestamp punchInDateTime;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public Timestamp getPunchInDateTime() {
		return punchInDateTime;
	}
	public void setPunchInDateTime(Timestamp punchInDateTime) {
		this.punchInDateTime = punchInDateTime;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePassword="
				+ employeePassword + ", emailId=" + emailId + ", empNumber=" + empNumber + ", punchInDateTime="
				+ punchInDateTime + "]";
	}

	
	
	
	       

}
