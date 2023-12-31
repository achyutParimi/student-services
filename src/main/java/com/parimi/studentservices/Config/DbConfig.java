package com.parimi.studentservices.Config;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Value(
            "jdbc.jdbcUrl"
    )
    private String dbUrl;

    /*@Value(
            "jdbc.username"
    )
    private String dbUserName;

    /*@Value(
            "jdbc.driver-class-name"
    )
    private String driverClass;

    @Value(
            "jdbc.password"
    )
    private String dbUserPwd;*/


    @Bean(name="dataSource")
    //@ConfigurationProperties(prefix="jdbc")
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        //ds.setUrl(dbUrl);
        ds.setUsername("postgresql");
        ds.setPassword("postgresql");
        return ds;
     //   return DataSourceBuilder.create().type(org.apache.tomcat.jdbc.pool.DataSource.class).build();
    }

    @Bean(name ="namedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("dataSource") final DataSource requestDataSource) {
        return new NamedParameterJdbcTemplate(requestDataSource);
    }

    @Bean(name ="jdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") final DataSource requestDataSource) {
        return new JdbcTemplate(requestDataSource);
    }

}