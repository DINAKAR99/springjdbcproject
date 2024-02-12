package spring.jdbc;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.jdbc.config.jdbcconfig;
import spring.jdbc.dao.StudentDao;
import spring.jdbc.dao.StudentDaoImpl;
import spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(jdbcconfig.class);

        StudentDao bean1 = container.getBean("studdao", StudentDao.class);

        // Student s1 = new Student(7, "imran", "newyork", "usa");
        // Student s2 = new Student(2, "jhon", "new jersey", "usa");

        // int student = bean1.createStudent(s1);

        // System.out.println(student);

        // update

        // int updateStudent = bean1.updateStudent(s2);
        // System.out.println(updateStudent);

        // delete

        // int deleteStudent = bean1.deleteStudent(s2);

        // System.out.println(deleteStudent);

        // fetching student

        Student fetchStudent = bean1.fetchStudent(3);
        System.out.println(fetchStudent);

        // List<Student> fetchAllStudent = bean1.fetchAllStudent();

        // for (Student student : fetchAllStudent) {

        // System.out.println(student);

        // }
    }

}
