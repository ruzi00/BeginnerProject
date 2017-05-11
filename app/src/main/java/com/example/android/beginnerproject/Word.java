package com.example.android.beginnerproject;

/**
 * Created by rasr00 on 07/05/2017.
 */

public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;
    private String mDefaultTranslation;
    private String mJapanTranslation;
    private String mIndonesianTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;


    public Word(String mDefaultTranslation, String mJapanTranslation, String mIndonesianTranslation, int mImageResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mJapanTranslation = mJapanTranslation;
        this.mIndonesianTranslation = mIndonesianTranslation;
        this.mImageResourceId = mImageResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmIndonesianTranslation() {
        return mIndonesianTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmJapanTranslation() {
        return mJapanTranslation;
    }
}