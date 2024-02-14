package com.kgisl.JunitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void addtest() {
        Calculator c1 = new Calculator();
        int er1 = 15;
        int ar1 = c1.add(10, 5);
        assertEquals(er1,ar1);
    }

    @Test
    public void subtest() {
        Calculator c2 = new Calculator();
        int er2 = 5;
        int ar2 = c2.subtraction(10, 5);
        assertEquals(er2,ar2);
    }

    @Test
    public void multest() {
        Calculator c3 = new Calculator();
        int er3 = 50;
        int ar3 = c3.multiplication(10, 5);
        assertEquals(er3,ar3);
    }

    @Test
    public void divtest() {
        Calculator c1 = new Calculator();
        int er4 = 2;
        int ar4 = c1.division(10, 5);
        assertEquals(er4,ar4);
    }
}
