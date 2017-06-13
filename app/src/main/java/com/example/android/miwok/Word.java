package com.example.android.miwok;

/**
 * Created by shubham on 6/11/17.
 */

public class Word {
    private String miwok;
    private String defaultWord;
    private int imageId=-1;
    private int soundId;

    public Word(String mi,String de,int so)
    {
        miwok=mi;
        defaultWord=de;
        soundId=so;
    }

    public Word(String mi,String de,int id,int so)
    {
        miwok=mi;
        defaultWord=de;
        imageId=id;
        soundId=so;
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
    public int getSoundId()
    {
        return soundId;
    }
    public boolean hasimage()
    {
        if(imageId==-1)
            return false;
        else
            return true;
    }
}
