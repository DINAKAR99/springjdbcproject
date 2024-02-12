package spring.jdbc.jdbcClient;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.jdbc.jdbcClient.config.clientconfig;
import spring.jdbc.jdbcClient.dao.jdbcClientDao;
import spring.jdbc.jdbcClient.entities.User;

public class jdbcClientDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(clientconfig.class);

        jdbcClientDao bean = container.getBean("userdao", jdbcClientDao.class);

        User u1 = new User(2, "deno", "ny");
        // inserting-------------
        // int user = bean.createUser(u1);
        // System.out.println("affected " + user);
        // inserting-------------

        // updating-----------
        // int changeUser = bean.changeUser(u1);
        // System.out.println(changeUser);
        // updating-----------

        // deleting-------------

        // int deleteUser = bean.deleteUser(u1);
        // System.out.println(deleteUser);
        // deleting-------------

        // fecth user -------------
        // User userById = bean.getUserById(2);
        // System.out.println(userById);
        // fecth user -------------

        // fecth all userall -------------
        List<User> users = bean.getUsers();

        for (User user : users) {
            System.out.println(user);

        }
        // fecth all user -------------

    }
}
