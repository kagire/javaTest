package com.mastery.simplewebapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Value( "${spring.datasource.url}" )
    private String jdbcUrl;

    @Value( "${spring.datasource.driver-class-name}" )
    private String jdbcClassName;

    //db connection
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(jdbcClassName);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("1234");
        return dataSourceBuilder.build();
    }
}
