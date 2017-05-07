package com.example.android.beginnerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class rokokActivity extends AppCompatActivity {


    int uang = 1120;
    int isi = 16;
    int quantity = 0;


    TextView e;
    TextView e1;
    TextView e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.rokok);


        e = (TextView) findViewById(R.id.money);
        e1 = (TextView) findViewById(R.id.money1);
        e2 = (TextView) findViewById(R.id.money2);

        e.setText(getString(R.string.money, "" + 0));
        e1.setText(getString(R.string.money1, "" + 0));
        e2.setText(getString(R.string.money2, "" + 0));
    }

    public void increment(View view) {
        if (quantity == 100) {
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

    public boolean getBatang() {
        RadioGroup r = (RadioGroup) findViewById(R.id.g1);
        int temp = r.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(temp);
        String geto = rb.getText().toString();
        return geto.equals("Bungkus");
    }

    public int clc1(int num) {
        if (getBatang())
            return num * uang * isi;
        else
            return num * uang;
    }

    public int clc2(int num) {
        if (getBatang())
            return num * uang * 30 * isi;
        else
            return num * uang * 30;
    }

    public int clc3(int num) {
        if (getBatang())
            return num * uang * 355 * isi;
        else
            return num * uang * 355;
    }

    public void calculate(View view) {

        e = (TextView) findViewById(R.id.money);
        e1 = (TextView) findViewById(R.id.money1);
        e2 = (TextView) findViewById(R.id.money2);

        e.setText(getString(R.string.money, NumberFormat.getInstance().format(clc1(quantity))));
        e1.setText(getString(R.string.money1, NumberFormat.getInstance().format(clc2(quantity))));
        e2.setText(getString(R.string.money2, NumberFormat.getInstance().format(clc3(quantity))));


    }
}
