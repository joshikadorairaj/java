package com.kgisl.JunitTesting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// @TestMethodOrder(MethodOrderer.DisplayName.class)
public class AppTest2 {


    @DisplayName("Method 4")
    @Test
    void test4() {
        System.out.println("class 1 method 4");
    }

    @DisplayName("Method 2")
    @Test
    void test2() {
        System.out.println("class 1 method 2");
    }

    @DisplayName("Method 3")
    @Test
    void test3() {
        System.out.println("class 1 method 3");
    }

    @DisplayName("Method 5")
    @Test
    void test5() {
        System.out.println("class 1 method 5");
    }

    @DisplayName("Method 1")
    @Test
    void test1() {
        System.out.println("class 1 method 1");
    }




}
