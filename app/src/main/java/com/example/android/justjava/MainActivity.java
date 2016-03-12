package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int coffeePrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        displayMessage(createOrderSummary(calculatePrice()));
    }

    public String createOrderSummary(int price) {
        return "Name: Newton Duarte" +
                "\nQuantity: " + quantity +
                "\nTotal: $" + price +
                "\nThank you!";
    }

    private int calculatePrice() {
        int finalPrice = quantity * coffeePrice;
        return finalPrice;
    }

    public void checkQuantity() {
        if (quantity < 0) {
            quantity = 0;
        }
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        quantity += 1;
        display(quantity);
    }

    public void decrement(View view) {
        quantity -= 1;
        checkQuantity();
        display(quantity);
    }


}
