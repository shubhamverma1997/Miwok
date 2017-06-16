package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mp;

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener onFocus=new AudioManager.OnAudioFocusChangeListener()
    {
        @Override
        public void onAudioFocusChange(int focusChange)
        {
            if(focusChange==AudioManager.AUDIOFOCUS_GAIN)
            {
                mp.seekTo(mp.getCurrentPosition());
                mp.start();
            }

            if(focusChange==AudioManager.AUDIOFOCUS_LOSS)
            {
                mp.stop();
                releaseMediaPlayer();
            }

            if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                mp.pause();
                mp.seekTo(0);
            }

        }

    };

    private MediaPlayer.OnCompletionListener completion=new MediaPlayer.OnCompletionListener()
    {
        @Override
        public void onCompletion(MediaPlayer mp)
        {
            releaseMediaPlayer();
        }
    };
    @Override
    public void onStop()
    {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAudioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);

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

        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("One","Lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("Two","Otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("Three","Tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("Four","Oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("Five","Massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("Six","Temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("Seven","Kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("Eight","Kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("Nine","Wo'e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("Ten","Na'aacha",R.drawable.number_ten,R.raw.number_ten));

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                int result=mAudioManager.requestAudioFocus(onFocus,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    mp=MediaPlayer.create(view.getContext(),words.get(position).getSoundId());
                    mp.start();
                    mp.setOnCompletionListener(completion);
                }

                //previously these lines were here
                //mp=MediaPlayer.create(view.getContext(),words.get(position).getSoundId());
                //mp.start();
                //mp.setOnCompletionListener(completion);
            }
        });


    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;

            mAudioManager.abandonAudioFocus(onFocus);
        }
    }
}
