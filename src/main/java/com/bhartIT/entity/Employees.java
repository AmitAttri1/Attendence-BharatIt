package com.bhartIT.entity;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public int hashCode() {
		return Objects.hash(emailId, empNumber, employeeId, employeeName, employeePassword, punchInDateTime);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(empNumber, other.empNumber)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeePassword, other.employeePassword)
				&& Objects.equals(punchInDateTime, other.punchInDateTime);
	}

	
	
}
