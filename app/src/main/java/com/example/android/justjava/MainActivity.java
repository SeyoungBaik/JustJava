package com.example.android.justjava;



/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.text.NumberFormat;



/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int price ;
    int total ;
    int quantity = 2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
            boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

// Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();



        int price = calculatePrice();

        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate) ;
        priceMessage = priceMessage + "\n Thx " ;

        displayMessage(priceMessage);




    }
    public int calculatePrice () { return quantity * 5 ; }

    private String createOrderSummary(int price, boolean addwhippedCream, boolean addChocolate){

        String priceMessage = "name : Seyoung ";

        priceMessage += "\n Add whipped Cream? " + addwhippedCream ;
        priceMessage += "\n Add choco ? " + addChocolate ;
         priceMessage += "\n Quantity : " + quantity ;
        priceMessage += "\nTotal : $ " + price ;
        priceMessage += "\nThank you" ;

        return priceMessage ;


    }



    /**
     * This method is called when the order PLUS button is clicked.
     */

    /**
     * This method displays the given text on the screen.
     */



    public void increment(View view) {

        quantity = quantity + 1  ;
        display(quantity);

    }
    /**
     * This method is called when the order PLUS button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity -1 ;
        display(quantity);

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }

    private  void displayQuantity(int numberOfCoffees) {

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);


    }




    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }



}