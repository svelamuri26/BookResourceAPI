package com.example.BookResourcedemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        LOGGER.info("Setting up DataSource bean...");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/BookAPI");
        dataSource.setUsername("root");
        dataSource.setPassword("niri2214");
        LOGGER.info("DataSource bean configured successfully.");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        LOGGER.info("Creating JdbcTemplate bean...");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.info("JdbcTemplate bean created successfully.");
        return jdbcTemplate;
    }

    @Bean
    public BookDao bookDao(JdbcTemplate jdbcTemplate) {
        LOGGER.info("Creating BookDao bean...");
        BookDao bookDao = new BookDao(jdbcTemplate);
        LOGGER.info("BookDao bean created successfully.");
        return bookDao;
    }

    @Bean
    public BookService bookService(BookDao bookDao) {
        LOGGER.info("Creating BookService bean...");
        BookService bookService = new BookServiceImpl(bookDao);
        LOGGER.info("BookService bean created successfully.");
        return bookService;
    }

    @Bean
    public Object insertLog(DataSource dataSource) {
        LOGGER.info("Inserting log into database...");
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO Logs (host, headers, body, status_code, response) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, "abcsample.com");
                pstmt.setString(2, "Sample Headers");
                pstmt.setString(3, "Sample Body");
                pstmt.setInt(4, 200);
                pstmt.setString(5, "Sample Response");
                int rowsAffected = pstmt.executeUpdate();
                LOGGER.info("Log inserted successfully. Rows affected: " + rowsAffected);
            } catch (SQLException e) {
                LOGGER.error("Error inserting log: " + e.getMessage());
            }
        } catch (SQLException e) {
            LOGGER.error("Error establishing connection: " + e.getMessage());
        }

        return null;
    }
}
