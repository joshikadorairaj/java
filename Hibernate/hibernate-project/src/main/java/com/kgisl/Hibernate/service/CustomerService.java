package com.kgisl.Hibernate.service;

import java.util.List;

import com.kgisl.Hibernate.entity.Customer;

public interface CustomerService {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
    
    public void updateCustomer(Customer theCustomer);


}
