package spring.jdbc.jdbcClient.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = { " spring.jdbc.jdbcClient.dao", "spring.jdbc.StoredProc.service",
        "spring.jdbc.StoredProc.dao" })
public class clientconfig {

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

    @Bean("clientsource")
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

    @Bean("jdbcclient")
    JdbcClient getJdbcClient() {

        JdbcClient jdbcClient = JdbcClient.create(getDataSource());

        return jdbcClient;
    }

    @Bean("jdbc")
    JdbcTemplate getJdbcTemplate() {

        JdbcTemplate JdbcTemplate = new JdbcTemplate(getDataSource());

        return JdbcTemplate;
    }

    @Bean("simplejdbc")
    SimpleJdbcCall getsimplejdbccall() {

        SimpleJdbcCall s1 = new SimpleJdbcCall(getJdbcTemplate());

        return s1;
    }

}
