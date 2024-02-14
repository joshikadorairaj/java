package com.kgisl.SpringJDBC;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class RegistrationDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  List<Registration> allRegistration() {
        String query = "SELECT * FROM registration";
        return jdbcTemplate.query(query,new RegistrationMapper());
    }
}