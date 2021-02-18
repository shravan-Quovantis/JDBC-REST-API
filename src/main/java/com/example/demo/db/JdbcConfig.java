package com.example.demo.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"db"})
public class JdbcConfig {

    @Bean("driverManagerDataSourceBean")
    public DriverManagerDataSource getDataSource() {
        final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/Quovantis");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Olivia@83");
        return driverManagerDataSource;
    }

    @Bean(name = {"jdbcTemplateBean"})                                          //another way of declaring the name
    public JdbcTemplate getTemplate() {
        final JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
}
