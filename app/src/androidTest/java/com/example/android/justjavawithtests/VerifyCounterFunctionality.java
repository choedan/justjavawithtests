package com.example.android.justjavawithtests;

import org.junit.Test;

/**
 * Created by Dan on 2/15/2017.
 * Test one is a simple test that performs user clicks on the quantity and asserts their values
 * match the input.  Test two does the same thing but is designed to fail by asserting an incorrect
 * value.
 */


public class VerifyCounterFunctionality extends AbstractedTestClass {

    @Test
    public void setAndVerifyCounter(){
        int qty = 5;
        setQuantity(qty);
        verifyQuantity(qty);
    }

    @Test
    public void setAndVerifyCounter_Fail(){
        int qty = 4;
        setQuantity(qty);
        verifyQuantity(qty-1);
    }
}
