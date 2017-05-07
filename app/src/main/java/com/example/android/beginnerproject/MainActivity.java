package com.example.android.beginnerproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView rokok = (TextView) findViewById(R.id.rokok);
        TextView lamp = (TextView) findViewById(R.id.lampu);
        TextView pc = (TextView) findViewById(R.id.pc);

        rokok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rokokIntent = new Intent(MainActivity.this, rokokActivity.class);
                startActivity(rokokIntent);
            }
        });

        lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lampIntent = new Intent(MainActivity.this, lampuActivity.class);
                startActivity(lampIntent);
            }
        });

        pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pcIntent = new Intent(MainActivity.this, pcActivity.class);
                startActivity(pcIntent);
            }
        });


    }
}
