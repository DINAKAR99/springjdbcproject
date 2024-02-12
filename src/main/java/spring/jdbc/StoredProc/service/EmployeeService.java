package spring.jdbc.StoredProc.service;

import org.springframework.stereotype.Component;

import spring.jdbc.StoredProc.Employee;

@Component
public interface EmployeeService {
    public Employee fetchEmpByNameAndSal(int empid);
}
