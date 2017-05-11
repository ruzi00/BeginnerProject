package com.example.android.beginnerproject;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.beginnerproject.R;
import com.example.android.beginnerproject.Word;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.R.attr.y;

/**
 * Created by rasr00 on 07/05/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);


        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english);
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        TextView indoTextView = (TextView) listItemView.findViewById(R.id.indo);
        indoTextView.setText(currentWord.getmIndonesianTranslation());

        TextView japanTextView = (TextView) listItemView.findViewById(R.id.japan);
        japanTextView.setText(currentWord.getmJapanTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentWord.getmImageResourceId());
        imageView.setVisibility(View.VISIBLE);


        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
