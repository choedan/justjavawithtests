package com.example.android.justjavawithtests;

import org.junit.Test;

/**
 * Created by Dan on 2/16/2017.
 */

public class AllFields extends AbstractedTestClass {
    @Test
    public void setAllFields() {
        int qty = 2;
        setName("Dan");
        addWhippedCream();
        addChocolateTopping();
        setQuantity(qty);
        clickPreviewOrderButton();

        verifyNameOnPreview("Dan");
        verifyChocolateToppingOrderedOnPreview();
        verifyQuantityOnPreview(qty);

    }

}
