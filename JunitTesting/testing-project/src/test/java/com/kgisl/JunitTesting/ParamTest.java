package com.kgisl.JunitTesting;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParamTest {
    // @ParameterizedTest



    //------------------------------emptysource-------------------------
    // @ValueSource(strings = {"\n",""," ","\t"})
    // @EmptySource
    // void testEmptyValuesAndNull(String value) {
    //     assertTrue(value.isBlank());
    // }

    //---------------------------------null source----------------------------
//at default it gives one null value as an arguement
    // @ValueSource(strings = {"apple", "banana", "orange",""})
    // @NullSource
    // void testStringValueWithNull(String value) {
    //     if (value != null) {
    //         // Test logic for non-null values
    //         assertTrue(value.length() > 0);
    //     } else {
    //         // Test logic for null values
    //         assertNull(value);
    //     }
    // }

    //--------------------------------------valuesource------------------------------
    // @ValueSource(strings = {"apple", "banana", "orange", "grape", "kiwi"})
    // void testStringLength(String fruit) {
    // assertNotNull(fruit);
    // assertTrue(fruit.length() > 0);
    // }
    // @ValueSource(ints = { 1, 2, 3, 4, 5 })
    // void testIsPositive(int number) {
    // assertTrue(number > 0);
    // }
}