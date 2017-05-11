package com.example.android.beginnerproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new com.example.android.beginnerproject.Word("one", "一 (ichi)", "satu",
                R.drawable.number_one));
        words.add(new com.example.android.beginnerproject.Word("two", "二 (ni)", "dua",
                R.drawable.number_two));
        words.add(new com.example.android.beginnerproject.Word("three", "三 (san)", "tiga",
                R.drawable.number_three));
        words.add(new com.example.android.beginnerproject.Word("four", "四 (shi/yon)", "empat",
                R.drawable.number_four));
        words.add(new com.example.android.beginnerproject.Word("five", "五 (go)", "lima",
                R.drawable.number_five));
        words.add(new com.example.android.beginnerproject.Word("six", "六 (roku)", "enam",
                R.drawable.number_six));
        words.add(new com.example.android.beginnerproject.Word("seven", "七 (shichi/nana)", "tujuh",
                R.drawable.number_seven));
        words.add(new com.example.android.beginnerproject.Word("eight", "八 (hachi)", "delapan",
                R.drawable.number_eight));
        words.add(new com.example.android.beginnerproject.Word("nine", "九 (kyū/ku)", "sembilan",
                R.drawable.number_nine));
        words.add(new com.example.android.beginnerproject.Word("ten", "十 (jū)", "sepuluh",
                R.drawable.number_ten));

        com.example.android.beginnerproject.WordAdapter adapter = new com.example.android.beginnerproject.WordAdapter(this, words, R.color.category_number);

        listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
