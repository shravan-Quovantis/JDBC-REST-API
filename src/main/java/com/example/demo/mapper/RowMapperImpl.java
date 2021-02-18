package com.example.demo.mapper;

import model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {

        final Customer customer = new Customer();
        customer.setId(resultSet.getInt(1));
        customer.setName(resultSet.getString(2));
        customer.setCity(resultSet.getString(3));
        return customer;
    }
}
