package com.login.demo.demo.repository;

import com.login.demo.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByUsername(String username);
}
