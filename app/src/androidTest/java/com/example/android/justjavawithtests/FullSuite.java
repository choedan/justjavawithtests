package com.example.android.justjavawithtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Dan on 2/15/2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        VerifyCounterFunctionality.class,
        VerifyOrderWithChocolate.class,
        AllFields.class

})
public class FullSuite {
}
