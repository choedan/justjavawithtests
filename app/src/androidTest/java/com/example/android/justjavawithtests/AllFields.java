package com.example.android.justjavawithtests;

import org.junit.Test;

/**
 * Created by Dan on 2/16/2017.
 */

public class AllFields extends AbstractedTestClass {
    @Test
    public void setAllFields() {
        int qty = 2;
        String name = "Dan";
        
        setName(name);
        addWhippedCream();
        addChocolateTopping();
        setQuantity(qty);
        clickPreviewOrderButton();

        verifyNameOnPreview(name);
        verifyChocolateToppingOrderedOnPreview();
        verifyQuantityOnPreview(qty);

    }

}
