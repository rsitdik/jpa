package io.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:util.properties")
@PropertySource(value = "classpath:auth.properties")
public class DataConfig {
    private Environment environment;

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driver"));
//        dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
//        dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.username"));
//        dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
//        return dataSource;
//    }

//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource());
//        return jdbcTemplate;
//    }


    // for prod
//    @Bean
//    public UserDetailsService userDetailsService() {
//        JdbcDaoImpl dao = new JdbcDaoImpl();
//        dao.setDataSource(dataSource());
//        dao.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
//        dao.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
//        return dao;
//    }


    // non for prod
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        // ensure the passwords are encoded properly
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("user").roles("USER").build());
        manager.createUser(users.username("admin").password("admin").roles("USER", "ADMIN").build());
        return manager;
    }

    public Environment getEnvironment() {
        return environment;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
