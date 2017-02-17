package com.example.android.justjavawithtests;

import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Dan on 2/15/2017.
 */

public class AbstractedTestClass {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    public void addWhippedCream(){
        onView(withId(R.id.whippedCream))
                .perform(click());
        }

    public void addChocolateTopping(){
        onView(withId(R.id.chocolateTopping))
                .perform(click());

    }

    public void setQuantity(int quantity){
        for (int i = 0; i<quantity; i++){
            onView(withId(R.id.incrementButton)).perform(click());
        }
    }

    public void clickOrderButton(){
        onView(withId(R.id.orderButton)).perform(click());
    }


    /*scrollTo added to overcome the following error: "Action will not be performed because
    the target view does not match one or more of the following constraints: at least 90
    percent of the view's area is displayed to the user."
    could have alternatively overridden the click action to bypass the 90% visible restriction.
    http://blog.novatec-gmbh.de/mobile-testing-espresso-framework/ */

    public void clickPreviewOrderButton(){

        onView(withId(R.id.previewOrderButton)).perform(scrollTo(),click());
    }

    public void setName(String name){
        onView(withId(R.id.nameField)).perform(typeText(name));
    }

    public void verifyQuantity(int quantity){
        onView(withId(R.id.quantity_text_view))
        .check(matches(withText(""+quantity)));
    }

    public void verifyQuantityOnPreview(int quantity){
        onView(withId(R.id.orderSummary))
                .check(matches(withText(containsString(""+quantity))));
    }
    public void verifyChocolateToppingOrderedOnPreview(){
        onView(withId(R.id.orderSummary))
                .check(matches(withText(containsString("Add chocolate topping? true"))));

    }
    public void verifyNameOnPreview(String name){
        onView(withId(R.id.orderSummary))
                .check(matches(withText(containsString(name))));
    }


}
