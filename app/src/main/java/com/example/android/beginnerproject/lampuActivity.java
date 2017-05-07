package com.example.android.beginnerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class lampuActivity extends AppCompatActivity {


    double uang = 1.46728;
    int quantity, quan = 0;

    EditText txt;
    TextView e;
    TextView e1;
    TextView e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lampu);


        e = (TextView) findViewById(R.id.money);
        e1 = (TextView) findViewById(R.id.money1);
        e2 = (TextView) findViewById(R.id.money2);

        e.setText(getString(R.string.money, "" + 0));
        e1.setText(getString(R.string.money1, "" + 0));
        e2.setText(getString(R.string.money2, "" + 0));
    }

    public void increment(View view) {
        if (quantity == 24) {
            // Show an error message as a toast
            Toast.makeText(this, getString(R.string.moree), Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 0) {
            // Show an error message as a toast
            Toast.makeText(this, getString(R.string.fewe), Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private void displayQuantity(int n) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + n);
    }

    public void incc(View view) {
        if (quan == 1000) {
            // Show an error message as a toast
            Toast.makeText(this, getString(R.string.moree), Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quan = quan + 1;
        displayQLamp(quan);
    }

    public void decc(View view) {
        if (quan == 0) {
            // Show an error message as a toast
            Toast.makeText(this, getString(R.string.fewe), Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quan = quan - 1;
        displayQLamp(quan);
    }

    private void displayQLamp(int n) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_lamp);
        quantityTextView.setText("" + n);
    }


    public int getLamp() {
        txt = (EditText) findViewById(R.id.watt);
        String value = txt.getText().toString().trim();
        if (value.isEmpty() || value.length() == 0 || value.equals("") || value == null) {
            Toast.makeText(this, "intesitas kosong", Toast.LENGTH_SHORT).show();
            return 0;
        }

        return Integer.parseInt(value);

    }

    public double clc1(int num, int num1) {
        return num * num1 * getLamp() * uang;
    }

    public double clc2(int num, int num1) {
        return num * num1 * getLamp() * uang * 30;
    }

    public double clc3(int num, int num1) {
        return num * num1 * getLamp() * uang * 355;
    }

    public void calculate(View view) {

        txt = (EditText) findViewById(R.id.watt);


        e = (TextView) findViewById(R.id.money);
        e1 = (TextView) findViewById(R.id.money1);
        e2 = (TextView) findViewById(R.id.money2);


        e.setText(getString(R.string.money, NumberFormat.getInstance().format(clc1(quantity, quan))));
        e1.setText(getString(R.string.money1, NumberFormat.getInstance().format(clc2(quantity, quan))));
        e2.setText(getString(R.string.money2, NumberFormat.getInstance().format(clc3(quantity, quan))));


    }
}
