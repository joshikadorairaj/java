package com.kgisl.JunitTesting;

public class CustomerBuilder {
    

    Customer customer=new Customer();

    public CustomerBuilder setId(int id) {
        customer.setId(id);
        return this;
    }

    public CustomerBuilder setFirstName(String firstName) {
        customer.setFirstName(firstName);
        return this;
    }

    public CustomerBuilder setLastName(String lastName) {
        customer.setLastName(lastName);
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        customer.setEmail(email);
        return this;
    }

    public Customer build() {
        return customer;
    }
}
