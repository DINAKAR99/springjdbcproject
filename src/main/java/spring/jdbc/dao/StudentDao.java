package spring.jdbc.dao;

import java.util.List;

import spring.jdbc.entities.Student;

public interface StudentDao {
    int createStudent(Student s1);

    int updateStudent(Student s1);

    int deleteStudent(Student s1);

    Student fetchStudent(int id);

    // List<Student> fetchAllStudent();

}