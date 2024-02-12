package spring.jdbc.StoredProc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import spring.jdbc.StoredProc.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private SimpleJdbcCall s1;

    public EmployeeDaoImpl(SimpleJdbcCall s1) {
        this.s1 = s1;
    }

    @Override
    public Employee getEmployeeByNS(int empid) {

        s1.withProcedureName("getempbynameandsal");

        ////////
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("empid", empid);
        MapSqlParameterSource input = new MapSqlParameterSource(params);
        ////////

        Map<String, Object> outputmap = s1.execute(input);
        System.out.println(outputmap);

        Employee e1 = new Employee();
        e1.setEname((String) outputmap.get("emp_name"));
        e1.setEsal((String) outputmap.get("emp_sal"));
        e1.setEid(empid);

        return e1;
    }

}
