package com.example.demo.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component("customerDaoBean")
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Customer customer) {
        String query = "insert into customer(id, name, city) values(?,?,?)";
        final int result = this.jdbcTemplate.update(query, customer.getId(), customer.getName(), customer.getCity());
        return result;
    }

    //Updating Customer information
    public int alter(Customer customer) {
        String query = "update customer set name=?, city=? where id=?";
        final int result = this.jdbcTemplate.update(query, customer.getName(), customer.getCity(), customer.getId());
        return result;
    }

    public int delete(int customerId) {
        final String query = "delete from customer where id =?";
        final int result = this.jdbcTemplate.update(query, customerId);
        return result;
    }

    //Selecting single Customer
    public Customer select(int customerId) {
        final String query = "select * from customer where id=?";
        RowMapper<Customer> rowMapper = new RowMapperImpl();
        final Customer customer = this.jdbcTemplate.queryForObject(query, rowMapper, customerId);
        return customer;
    }

    //Selecting multiple customer
    public List<Customer> selectAll() {
        final String query = "select * from customer";
        final List<Customer> customerList = this.jdbcTemplate.query(query, new RowMapperImpl());
        return customerList;
    }
}
