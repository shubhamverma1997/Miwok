package com.example.android.miwok;

/**
 * Created by shubham on 6/11/17.
 */

public class Word {
    private String miwok;
    private String defaultWord;
    private int imageId;

    public Word(String mi,String de)
    {
        miwok=mi;
        defaultWord=de;
        imageId=0;
    }

    public Word(String mi,String de,int id)
    {
        miwok=mi;
        defaultWord=de;
        imageId=id;
    }

    public void setMiwok(String text)
    {
        miwok=text;
    }
    public void setDefault(String text)
    {
        defaultWord=text;
    }
    public String getMiwok()
    {
        return miwok;
    }
    public String getDefaultWord()
    {
        return defaultWord;
    }
    public int getImageId()
    {
        return imageId;
    }
}
