package spring.jdbc.jdbcClient.dao;

import java.util.List;

import spring.jdbc.jdbcClient.entities.User;

public interface jdbcClientDao {

    int createUser(User user);

    int changeUser(User user);

    int deleteUser(User user);

    User getUserById(int id);

    List<User> getUsers();

}
