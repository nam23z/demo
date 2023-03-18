package com.login.demo.demo.Service;

import com.login.demo.demo.model.Customer;
import com.login.demo.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepository customerRepository;
    public Customer createCustomer(Customer customer){
        String password = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(password);
        return customerRepository.save(customer);
    }
}
