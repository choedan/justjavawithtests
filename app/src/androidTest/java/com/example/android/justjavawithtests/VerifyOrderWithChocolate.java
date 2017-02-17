package com.example.android.justjavawithtests;


import org.junit.Test;

/**
 * Created by Dan on 2/15/2017.
 * Very simple test that
 * - selects the chocolate topping check box
 * - sets the quantity of coffees ordered to 1
 * - clicks on the preview order button
 * - asserts that the chocolate topping was selected in the text view displaying the order summary
 */

public class VerifyOrderWithChocolate extends AbstractedTestClass {
    @Test
    public void orderWithChocolate(){
        addChocolateTopping();
        setQuantity(1);
        clickPreviewOrderButton();
        verifyChocolateToppingOrderedOnPreview();

    }
}

