package com.example.lab15_unittesting.helpers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalculatorTest {

    BasicCalculator testObj;
    double val1, val2, expectedSum, actualSum, expectDifference, actualDifference,
    expectedProduct, actualProduct, expectedQuotient, actualQuotient;


    @Before
    public void setUp() throws Exception {

        val1 = 25;
        val2 = 22;

        testObj = new BasicCalculator(val1, val2);

        expectedSum = val1 + val2 ;
        actualSum = testObj.add();

        expectDifference = val1 - val2;
        actualDifference = testObj.subtract();

        expectedProduct = val1 * val2;
        actualProduct = testObj.multiply();

        expectedQuotient = val1 / val2;
        actualQuotient = testObj.divide();


    }


    @Test
    public void testAddTwoPositiveNumbers() {
        assertEquals(expectedSum, actualSum, .2);
    }

    @Test
    public void subtract() {
        assertEquals(expectDifference,actualDifference, .2);
    }

    @Test
    public void multiply() {
        assertEquals(expectedProduct,actualProduct, .2);
    }

    @Test
    public void divide() {
        assertEquals(expectedQuotient,actualQuotient, .2);
    }


    @After
    public void tearDown() throws Exception {


        testObj = null; // clean the object in the end


    }

}