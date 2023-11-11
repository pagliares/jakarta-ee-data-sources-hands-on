package xyz.pagliares.jakarta.datasources.datasourcejdbc.entity;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationScoped
public class InitializeDatabase {

    @Resource(name = "jdbc/__default")
    private DataSource dataSource;

    public void postConstruct(@Observes @Initialized(ApplicationScoped.class)Object o) {
        try {
            try (Connection connection = dataSource.getConnection()) {
                connection.prepareStatement("CREATE TABLE Company('id' bigint(20) NOT NULL, 'name' ");
                connection.prepareStatement("INSERT INTO Company('id','name') VALUES(1,'Payara')").executeUpdate();
            }
            System.out.println("Created table and test data");
        } catch (SQLException throwables) {
            // FIXME
            throwables.printStackTrace();
        }
    }
}
