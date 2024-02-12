package spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import spring.jdbc.entities.Student;

@Component("studdao")
public class StudentDaoImpl implements StudentDao {
    // @Autowired
    // private JdbcTemplate temp1;

    @Autowired
    private NamedParameterJdbcTemplate namedtemplate;

    public NamedParameterJdbcTemplate getNamedtemplate() {
        return namedtemplate;
    }

    public void setNamedtemplate(NamedParameterJdbcTemplate namedtemplate) {
        this.namedtemplate = namedtemplate;
    }

    @Override
    public int createStudent(Student s1) {

        String query1 = "insert into student values(id=:id,name=:name,address=:address,city=:city)";

        MapSqlParameterSource value = new MapSqlParameterSource("id", s1.getId()).addValue("name", s1.getName())
                .addValue("address", s1.getAddress())
                .addValue("city", s1.getCity());
        // int update = temp1.update(query1, s1.getId(), s1.getName(), s1.getAddress(),
        // s1.getCity());
        int update = namedtemplate.update(query1, value);

        return update;

    }

    @Override
    public int updateStudent(Student s1) {
        String query = "update student set name=:name ,city=:city where id=:id";

        // int update = temp1.update(query, s1.getName(), s1.getCity(), 2);
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("name", s1.getName()).addValue("city",
                s1.getCity());
        int update = namedtemplate.update(query, mapSqlParameterSource);

        return update;

    }

    @Override
    public int deleteStudent(Student s1) {

        String query = "delete from student where id =?";

        // int update = temp1.update(query, s1.getId());

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("id", s1.getId());
        int update = namedtemplate.update(query, mapSqlParameterSource);
        return update;
    }

    @Override
    public Student fetchStudent(int id) {
        String query = "select * from student where id=:id";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        // Student stud = temp1.queryForObject(query, rowMapper, id);

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("id", id);
        Student queryForObject = namedtemplate.queryForObject(query, mapSqlParameterSource, rowMapper);
        return queryForObject;
    }

    // @Override
    // public List<Student> fetchAllStudent() {
    // String query = "select * from student ";
    // // List<Student> query2 = temp1.query(query, new RowMapperImpl());
    // List<Student> query2 = new List<Student>();

    // return query2;

    // }
}
