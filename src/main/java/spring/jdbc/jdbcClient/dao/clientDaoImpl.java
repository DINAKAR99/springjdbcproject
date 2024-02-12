package spring.jdbc.jdbcClient.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.core.simple.JdbcClient.MappedQuerySpec;
import org.springframework.jdbc.core.simple.JdbcClient.ResultQuerySpec;
import org.springframework.stereotype.Component;

import spring.jdbc.jdbcClient.entities.User;

@Component("userdao")
public class clientDaoImpl implements jdbcClientDao {

    private JdbcClient j1;

    public clientDaoImpl(JdbcClient j1) {
        this.j1 = j1;
    }

    @Override
    public int createUser(User user) {

        int update = j1.sql("insert into user1 values(?,?,?)").param(1, user.getId()).param(2, user.getName()).param(3,
                user.getCity()).update();

        return update;

    }

    @Override
    public int changeUser(User user) {

        int update = j1.sql("update  user1 set name=:name,city=:city where id=:id").param("id", user.getId())
                .param("name", user.getName()).param("city",
                        user.getCity())
                .update();

        return update;
    }

    @Override
    public int deleteUser(User user) {
        int update = j1.sql(" delete from user1 where id=:id").param("id", user.getId()).update();

        return update;

    }

    @Override
    public User getUserById(int id) {
        return j1.sql(" select * from user1 where id=:id").param("id", id).query(User.class)
                .single();

    }

    @Override
    public List<User> getUsers() {
        List<User> list = j1.sql(" select * from user1  ").query(User.class).list();

        return list;

    }

}
