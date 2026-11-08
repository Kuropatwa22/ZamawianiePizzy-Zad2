package com.example.pizza;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spSize;
    CheckBox cbCheese, cbOlives;
    SeekBar sbQuantity;
    TextView tvQuantity;
    EditText etAddress;

    private final ActivityResultLauncher<Intent> pizzaLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {

                        if (result.getResultCode() == RESULT_OK
                                && result.getData() != null) {

                            String number = result.getData()
                                    .getStringExtra(
                                            SummaryActivity.EXTRA_ORDER_NUMBER);

                            Toast.makeText(this,
                                    getString(R.string.order_success, number),
                                    Toast.LENGTH_LONG).show();

                        } else {

                            Toast.makeText(this,
                                    R.string.order_cancel,
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spSize = findViewById(R.id.spSize);
        cbCheese = findViewById(R.id.cbCheese);
        cbOlives = findViewById(R.id.cbOlives);
        sbQuantity = findViewById(R.id.sbQuantity);
        tvQuantity = findViewById(R.id.tvQuantity);
        etAddress = findViewById(R.id.etAddress);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.pizza_sizes,
                        android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spSize.setAdapter(adapter);

        tvQuantity.setText(
                getString(R.string.quantity_format, 1));

        sbQuantity.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar, int progress, boolean fromUser) {

                        tvQuantity.setText(
                                getString(R.string.quantity_format,
                                        Math.max(1, progress)));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        findViewById(R.id.btnNext).setOnClickListener(
                v -> openSummary());

        findViewById(R.id.btnAbout).setOnClickListener(v -> {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        });

    }

    private void openSummary() {

        if (spSize.getSelectedItemPosition() == 0) {
            android.widget.Toast.makeText(
                    this,
                    R.string.error_size,
                    android.widget.Toast.LENGTH_SHORT).show();
            return;
        }

        String address = etAddress.getText().toString().trim();

        if (address.isEmpty()) {
            etAddress.setError(getString(R.string.error_address));
            etAddress.requestFocus();
            return;
        }

        Intent intent = new Intent(this, SummaryActivity.class);

        intent.putExtra(SummaryActivity.EXTRA_SIZE,
                spSize.getSelectedItem().toString());

        intent.putExtra(SummaryActivity.EXTRA_SIZE_NUMBER,
                spSize.getSelectedItemPosition());

        intent.putExtra(SummaryActivity.EXTRA_CHEESE,
                cbCheese.isChecked());

        intent.putExtra(SummaryActivity.EXTRA_OLIVES,
                cbOlives.isChecked());

        intent.putExtra(SummaryActivity.EXTRA_QUANTITY,
                Math.max(1, sbQuantity.getProgress()));

        intent.putExtra(SummaryActivity.EXTRA_ADDRESS, address);

        pizzaLauncher.launch(intent);
    }
}
