package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shubham on 6/11/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Context context,ArrayList<Word> data)
    {
        //second argument is used when we only need a single textview. here we can put any value.
        super(context,0,data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listview=convertView;

        if(listview == null) {
            listview = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord=getItem(position);

        TextView miwokTextView=(TextView) listview.findViewById(R.id.text1);
        miwokTextView.setText(currentWord.getMiwok());

        TextView defaultTextView=(TextView) listview.findViewById(R.id.text2);
        defaultTextView.setText(currentWord.getDefaultWord());

        ImageView image=(ImageView) listview.findViewById(R.id.image);
        if(currentWord.getImageId()!=0)
        image.setImageResource(currentWord.getImageId());

        return listview;
    }
}
