package com.kgisl.JunitTesting;

import java.security.AllPermission;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @DisplayName("Method 4")
    @Test
    void test4() {
        System.out.println("class 2 method 4");
    }

    @DisplayName("Method 2")
    @Test
    void test2() {
        System.out.println("class 2 method 2");
    }

    @DisplayName("Method 3")
    @Test
    void test3() {
        System.out.println("class 2 method 3");
    }

    @DisplayName("Method 5")
    @Test
    void test5() {
        System.out.println("class 2 method 5");
    }

    @DisplayName("Method 1")
    @Test
    void test1() {
        System.out.println("class 2 method 1");
    }

}
