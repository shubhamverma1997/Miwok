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
        words.add(new Word("One","Lutti"));
        words.add(new Word("Two","Otiiko"));
        words.add(new Word("Three","Tolookosu"));
        words.add(new Word("Four","Oyyisa"));
        words.add(new Word("Five","Massokka"));
        words.add(new Word("Six","Temmokka"));
        words.add(new Word("Seven","Kenekaku"));
        words.add(new Word("Eight","Kawinta"));
        words.add(new Word("Nine","Wo'e"));
        words.add(new Word("Ten","Na'aacha"));

        /*
        LinearLayout rootview=(LinearLayout) findViewById(R.id.rootView);
        for(int i=0;i<10;i++) {
            TextView word = new TextView(this);
            word.setText(words.get(i));
            word.setTextSize(40);
            rootview.addView(word);
        }
        */
        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
