package com.example.android.miwok;

/**
 * Created by shubham on 6/11/17.
 */

public class Word {
    private String miwok;
    private String defaultWord;

    public Word(String mi,String de)
    {
        miwok=mi;
        defaultWord=de;
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
}
