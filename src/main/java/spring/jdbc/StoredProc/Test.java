package spring.jdbc.StoredProc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.jdbc.StoredProc.service.EmployeeServiceImpl;
import spring.jdbc.jdbcClient.config.clientconfig;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(clientconfig.class);

        EmployeeServiceImpl bean = container.getBean(EmployeeServiceImpl.class);
        Employee fetchEmpByNameAndSal = bean.fetchEmpByNameAndSal(2);

        System.out.println(fetchEmpByNameAndSal);
    }

}
