package spring.jdbc.StoredProc.dao;

import spring.jdbc.StoredProc.Employee;

public interface EmployeeDao {
    public Employee getEmployeeByNS(int empid);
}
