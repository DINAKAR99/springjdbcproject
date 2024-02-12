package spring.jdbc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "spring.jdbc.dao")
@PropertySource("classpath:db.properties")

public class jdbcconfig {
    @Value("${db.driver}")
    String drivername;
    @Value("${db.url}")
    String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    String password;

    @Value("${db.initialsize}")
    int initialSize;

    @Value("${db.maxtotal}")
    int maxSize;

    @Bean("source")
    BasicDataSource getDataSource() {

        BasicDataSource source = new BasicDataSource();

        source.setDriverClassName(drivername);
        source.setUrl(url);
        source.setUsername(username);
        source.setPassword(password);
        source.setInitialSize(initialSize);
        source.setMaxTotal(maxSize);
        ;

        return source;
    }

    // @Bean("template")
    // JdbcTemplate getJDBCtemplate() {

    // JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    // return jdbcTemplate;

    // }

    @Bean("namedtemplate")
    NamedParameterJdbcTemplate getnamedJDBCtemplate() {

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return jdbcTemplate;

    }

    // @Bean("studentDAO")
    // StudentDao getStudentDao() {

    // StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    // studentDaoImpl.setTemp1(getJDBCtemplate());
    // return studentDaoImpl;
    // }

    // @Bean
    // public static PropertySourcesPlaceholderConfigurer
    // propertySourcesPlaceholderConfigurer() {
    // return new PropertySourcesPlaceholderConfigurer();
    // }
}
