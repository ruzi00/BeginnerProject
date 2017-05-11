package com.example.android.beginnerproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.R.layout.simple_spinner_dropdown_item;
import static com.example.android.beginnerproject.R.id.detail;

public class AgeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    int thisYear, pickYear;
    int thisMonth, pickMonth;
    int thisDate, pickDate;
    Spinner yea;
    Spinner spinner, spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.age);
        pickYear = 1900;
        pickMonth = 1;
        pickDate = 1;

        thisYear = Calendar.getInstance().get(Calendar.YEAR);
        thisMonth = Calendar.getInstance().get(Calendar.MONTH);
        thisDate = Calendar.getInstance().get(Calendar.DATE);

        ArrayList<String> yy = new ArrayList<String>();
        for (int i = 1900; i <= thisYear; i++) {
            yy.add(Integer.toString(i));
        }
        yea = (Spinner) findViewById(R.id.tahun);
        ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yy);
        adapter0.setDropDownViewResource(simple_spinner_dropdown_item);
        yea.setAdapter(adapter0);

        spinner = (Spinner) findViewById(R.id.month);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.month, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayList<String> date = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            date.add(Integer.toString(i));
        }
        spinner1 = (Spinner) findViewById(R.id.day);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, date);
        adapter1.setDropDownViewResource(simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(this);
        yea.setOnItemSelectedListener(this);
    }


    boolean kabisat(int year) {
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {
        // TODO Auto-generated method stub
        pickMonth = spinner.getSelectedItemPosition() + 1;
        yea = (Spinner) findViewById(R.id.tahun);

        pickYear = Integer.parseInt(yea.getSelectedItem().toString());

        if ((pickMonth == 1) || (pickMonth == 3) || (pickMonth == 5) || (pickMonth == 7) || (pickMonth == 8) || (pickMonth == 10) || (pickMonth == 12)) {
            ArrayList<String> date = new ArrayList<String>();
            for (int i = 1; i <= 31; i++) {
                date.add(Integer.toString(i));
            }

            spinner1 = (Spinner) findViewById(R.id.day);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, date);
            adapter1.setDropDownViewResource(simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter1);
        } else if (pickMonth == 2) {
            if (kabisat(pickYear)) {
                ArrayList<String> date = new ArrayList<String>();
                for (int i = 1; i <= 29; i++) {
                    date.add(Integer.toString(i));
                }

                spinner1 = (Spinner) findViewById(R.id.day);
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, date);
                adapter1.setDropDownViewResource(simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
            } else {
                ArrayList<String> date = new ArrayList<String>();
                for (int i = 1; i <= 28; i++) {
                    date.add(Integer.toString(i));
                }

                spinner1 = (Spinner) findViewById(R.id.day);
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, date);
                adapter1.setDropDownViewResource(simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
            }
        } else {
            ArrayList<String> date = new ArrayList<String>();
            for (int i = 1; i <= 30; i++) {
                date.add(Integer.toString(i));
            }

            spinner1 = (Spinner) findViewById(R.id.day);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, date);
            adapter1.setDropDownViewResource(simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter1);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void calculate(View view) {

        pickDate = Integer.parseInt(((Spinner) findViewById(R.id.day)).getSelectedItem().toString());
        Date date1 = null;
        Date date2 = null;
        double y, m, d = 0;
        double m1, d1;

        double dd = 0;
        double hour = 0, min = 0, sec = 0;


        if (pickMonth > thisMonth && thisYear == pickYear) {
            Toast.makeText(this, "Bulannya Kelebihan", Toast.LENGTH_SHORT).show();
        } else if (pickDate > thisDate && pickMonth == thisMonth && thisYear == pickYear) {
            Toast.makeText(this, "Tanggalnya Kelebihan", Toast.LENGTH_SHORT).show();
        } else {


            int t0 = pickYear * 12 + pickMonth - 1;
            int t = thisYear * 12 + thisMonth - 1;
            int dm = t - t0;
            if (thisDate >= pickDate) {
                y = Math.floor(dm / 12);
                m = dm % 12;
                d = thisDate - pickDate;
            } else {
                dm--;
                t--;
                y = Math.floor(dm / 12);
                m = dm % 12;
                m++;
                int gety = (int) y;
                int getz = (int) m;
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                String dat1 = "" + pickDate + "/" + (getz) + "/" + gety;
                String dat2 = "" + thisDate + "/" + thisMonth + "/" + thisYear;
//                String dat1 = "10/10/2013";
//                String dat2 = "12/12/2014";
                try {
                    date1 = format.parse(dat1);
                    date2 = format.parse(dat2);

                    long diff = date2.getTime() - date1.getTime();

                    sec = diff / 1000 % 60;
                    min = diff / (60 * 1000) % 60;
                    hour = diff / (60 * 60 * 1000) % 24;
                    d = diff / (24 * 60 * 60 * 1000) % 30;
                    d = Math.abs(d);
                    int s = 0;
                    Log.w("Ta", "" + d);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            m1 = y * 12 + m;
            d1 = d;

            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            String dat1 = "" + pickDate + "/" + pickMonth + "/" + pickYear;
            String dat2 = "" + thisDate + "/" + thisMonth + "/" + thisYear;
//                String dat1 = "10/10/2013";
//                String dat2 = "12/12/2014";
            try {
                date1 = format.parse(dat1);
                date2 = format.parse(dat2);

                long diff = date2.getTime() - date1.getTime();

                sec = diff / 1000 % 60;
                min = diff / (60 * 1000) % 60;
                hour = diff / (60 * 60 * 1000) % 24;
                dd = diff / (24 * 60 * 60 * 1000);
                dd = Math.abs(dd);

                sec = diff / 1000;
                min = diff / (60 * 1000);
                hour = diff / (60 * 60 * 1000);

                Log.w("Ta", "" + d);
            } catch (Exception e) {
                e.printStackTrace();
            }


            TextView tex = (TextView) findViewById(detail);
            String de = "Umur anda \n" + y + " Tahun " + m + " Bulan " + d + " Hari\n";
            de += "Bisa juga \n" + m1 + " Bulan " + d1 + " Hari\n";
            de += "Mungkin \n" + dd + "Hari\n";
            de += "Atau \n" + NumberFormat.getInstance().format(hour) + " Jam\n";
            de += "Maybe \n" + NumberFormat.getInstance().format(min) + " Menit\n";
            de += "Bisa jadi \n" + NumberFormat.getInstance().format(sec) + " Detik\n";
            de += "Sudahkan anda Menabung";
            tex.setText(de);
        }


    }
}
