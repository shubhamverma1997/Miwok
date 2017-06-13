package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

       /* String[] words=new String[11];
        words[0]="Zero";
        words[1]="One";
        words[2]="Two";
        words[3]="Three";
        words[4]="Four";
        words[5]="Five";
        words[6]="Six";
        words[7]="Seven";
        words[8]="Eight";
        words[9]="Nine";
        words[10]="Ten";*/

        ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("One","Lutti",R.drawable.number_one));
        words.add(new Word("Two","Otiiko",R.drawable.number_two));
        words.add(new Word("Three","Tolookosu",R.drawable.number_three));
        words.add(new Word("Four","Oyyisa",R.drawable.number_four));
        words.add(new Word("Five","Massokka",R.drawable.number_five));
        words.add(new Word("Six","Temmokka",R.drawable.number_six));
        words.add(new Word("Seven","Kenekaku",R.drawable.number_seven));
        words.add(new Word("Eight","Kawinta",R.drawable.number_eight));
        words.add(new Word("Nine","Wo'e",R.drawable.number_nine));
        words.add(new Word("Ten","Na'aacha",R.drawable.number_ten));

        /*
        LinearLayout rootview=(LinearLayout) findViewById(R.id.rootView);
        for(int i=0;i<10;i++) {
            TextView word = new TextView(this);
            word.setText(words.get(i));
            word.setTextSize(40);
            rootview.addView(word);
        }
        */
        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
