package com.kgisl.JunitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

public class CustomerBuilderTest {
    @Test
    void testCustomerBuilder() {
        Customer customer = new CustomerBuilder()
                .setId(1)
                .setFirstName("Josh")
                .setLastName("durairaj")
                .setEmail("josh.durai@example.com")
                .build();
       
        assertEquals(1, customer.getId());
        assertEquals("Josh", customer.getFirstName());
        assertEquals("durairaj", customer.getLastName());
        assertEquals("josh.durai@example.com", customer.getEmail());
    }
}
