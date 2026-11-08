package com.example.pizza;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    public static final String EXTRA_SIZE = "pizza.SIZE";
    public static final String EXTRA_SIZE_NUMBER = "pizza.SIZE_NUMBER";
    public static final String EXTRA_CHEESE = "pizza.CHEESE";
    public static final String EXTRA_OLIVES = "pizza.OLIVES";
    public static final String EXTRA_QUANTITY = "pizza.QUANTITY";
    public static final String EXTRA_ADDRESS = "pizza.ADDRESS";
    public static final String EXTRA_ORDER_NUMBER = "pizza.ORDER_NUMBER";
    TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvSummary = findViewById(R.id.tvSummary);
        tvSummary.setText(buildSummary());


        findViewById(R.id.btnEdit).setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });

        findViewById(R.id.btnConfirm).setOnClickListener(v -> confirm());

    }

    private String buildSummary() {

        Intent intent = getIntent();

        String size = intent.getStringExtra(EXTRA_SIZE);
        int sizeNumber = intent.getIntExtra(EXTRA_SIZE_NUMBER, 0);
        boolean cheese = intent.getBooleanExtra(EXTRA_CHEESE, false);
        boolean olives = intent.getBooleanExtra(EXTRA_OLIVES, false);
        int quantity = intent.getIntExtra(EXTRA_QUANTITY, 1);
        String address = intent.getStringExtra(EXTRA_ADDRESS);

        int price = 0;

        if (sizeNumber == 1) {
            price = 25;
        } else if (sizeNumber == 2) {
            price = 30;
        } else if (sizeNumber == 3) {
            price = 35;
        }

        String toppings = getString(R.string.none);

        if (cheese && olives) {
            toppings = getString(R.string.both_toppings);
            price += 9;
        } else if (cheese) {
            toppings = getString(R.string.cheese);
            price += 5;
        } else if (olives) {
            toppings = getString(R.string.olives);
            price += 4;
        }

        int total = price * quantity;

        return getString(R.string.summary_format,
                size, toppings, quantity, address, total);
    }

    private void confirm() {

        int number = 1000 + new Random().nextInt(9000);

        Intent result = new Intent();
        result.putExtra(EXTRA_ORDER_NUMBER, "PIZZA/" + number);

        setResult(RESULT_OK, result);
        finish();
    }

}
