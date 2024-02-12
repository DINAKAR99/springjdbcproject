package spring.jdbc.StoredProc.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.jdbc.StoredProc.Employee;
import spring.jdbc.StoredProc.dao.EmployeeDao;
import spring.jdbc.StoredProc.dao.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDaoImpl e1;

    public EmployeeServiceImpl(EmployeeDaoImpl e1) {
        this.e1 = e1;
    }

    @Override
    public Employee fetchEmpByNameAndSal(int empid) {
        return e1.getEmployeeByNS(empid);
    }

}
