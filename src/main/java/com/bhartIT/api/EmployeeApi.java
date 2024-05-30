package com.bhartIT.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhartIT.Exception.BharatItAttendenceException;
import com.bhartIT.dto.EmployeeDto;
import com.bhartIT.service.AuthenticationResponse;
import com.bhartIT.service.EmployeeService;
import com.bhartIT.util.JwtUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/BharatIt")
@CrossOrigin(origins = "http://localhost:3000")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EmployeeApi {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeApi.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employee/")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto employee) throws BharatItAttendenceException {
        try {
            Integer employeeId = employeeService.addEmployee(employee);
            String successMessage = "Employee registered successfully with ID: " + employeeId;
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error adding employee", e);
            return new ResponseEntity<>("Failed to register employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            logger.info("Authentication request received for user: {}", loginRequest.getEmployeeName());

            boolean isAuthenticated = employeeService.authenticateUser(loginRequest.getEmployeeName(), loginRequest.getEmployeePassword());

            if (isAuthenticated) {
                String token = JwtUtil.generateToken(loginRequest.getEmployeeName());
                AuthenticationResponse authenticationResponse = new AuthenticationResponse(token);
                logger.info("User authenticated successfully: {}", loginRequest.getEmployeeName());
                return ResponseEntity.ok(authenticationResponse);
            } else {
                logger.warn("Authentication failed for user: {}", loginRequest.getEmployeeName());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthenticationResponse("Invalid username or password"));
            }
        } catch (Exception e) {
            logger.error("Error during authentication", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AuthenticationResponse("An error occurred"));
        }
    }

    @GetMapping(value = "/employee/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeData(@PathVariable int employeeId) throws BharatItAttendenceException {
        try {
            EmployeeDto employee = employeeService.getEmployee(employeeId);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error retrieving employee data for ID: {}", employeeId, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employee/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() throws BharatItAttendenceException {
        try {
            List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
            return new ResponseEntity<>(allEmployee, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error retrieving all employees", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
