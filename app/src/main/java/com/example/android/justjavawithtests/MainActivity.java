package com.example.android.justjavawithtests;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        boolean hasWhippedCream = whippedCream.isChecked();

        CheckBox chocolateTopping = (CheckBox) findViewById(R.id.chocolateTopping);
        boolean hasChocoalteTopping = chocolateTopping.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocoalteTopping);

        EditText name = (EditText) findViewById(R.id.nameField);
        Editable userName = name.getText();

        String order = createOrderSummary(price, hasWhippedCream, hasChocoalteTopping, userName);

        Log.v("activity main.java", order);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for " + userName);
        intent.putExtra(Intent.EXTRA_TEXT, order);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void previewOrder(View view){
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        boolean hasWhippedCream = whippedCream.isChecked();

        CheckBox chocolateTopping = (CheckBox) findViewById(R.id.chocolateTopping);
        boolean hasChocoalteTopping = chocolateTopping.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocoalteTopping);

        EditText name = (EditText) findViewById(R.id.nameField);
        Editable userName = name.getText();

        String order = createOrderSummary(price, hasWhippedCream, hasChocoalteTopping, userName);
        TextView orderPreview = (TextView) findViewById(R.id.orderSummary);
        orderPreview.setText(order);

    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if (quantity<=99){
            quantity = quantity + 1;
        }
        else {
            Toast.makeText(MainActivity.this, "Number of cups of coffee must not exceed 100", Toast.LENGTH_SHORT).show();
            return;
        }

        displayQuantity(quantity);

    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1){
            Toast.makeText(MainActivity.this, "Number of cups of coffee must be greater than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            quantity = quantity - 1;
        }
        displayQuantity(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * Calculates the price of the order.
     * @param hasChocolateTopping is the state of the chocolate topping box
     * @param hasWhippedCreamTopping is the state of the whipped cream box
     * @return total price
     */
    private int calculatePrice(boolean hasWhippedCreamTopping, boolean hasChocolateTopping) {
        int price = 5;
        if (hasWhippedCreamTopping){
            price = price + 1;
        }
        if (hasChocolateTopping){
            price = price + 2;
        }

        return price * quantity;
    }

    /**
     * Method creates the actual text for the ordersummary view
     *@param name is the user name
     * @param price               total cost
     * @param hasWhippedCream     is a boolean representing the state of the check box
     * @param hasChocolateTopping is a boolean representing the state of the check box
     * @return order summary string
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolateTopping, Editable name) {

        String orderSummary = "Name: " + name + "\nAdd whipped cream? " + hasWhippedCream + "\nAdd chocolate topping? " + hasChocolateTopping + "\nQuantity: " + quantity + "\nTotal $" + price + "\nThank you!";
        return orderSummary;

    }
}
