/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //New clickListener object

        TextView numbers=(TextView) findViewById(R.id.numbers);
        //NumbersClickListener clickListener=new NumbersClickListener();
        //numbers.setOnClickListener(clickListener);
        //other way without defining another class
        numbers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"Open the list of numbers",Toast.LENGTH_SHORT).show();
                Intent numintent = new Intent(view.getContext(),NumbersActivity.class);
                startActivity(numintent);
            }
        });

        //for all others
        TextView phrases=(TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phintent=new Intent(v.getContext(),PhrasesActivity.class);
                startActivity(phintent);
            }
        });

        TextView family=(TextView) findViewById(R.id.family);
        family.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyintent=new Intent(v.getContext(),FamilyActivity.class);
                startActivity(familyintent);
            }
        });

        TextView color=(TextView) findViewById(R.id.colors);
        color.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorIntent=new Intent(v.getContext(),ColorsActivity.class);
                startActivity(colorIntent);
            }
        });
    }

/*    public void Family(View view)
    {
        Intent familyintent=new Intent(this,FamilyActivity.class);
        if(familyintent.resolveActivity(getPackageManager())!=null)
            startActivity(familyintent);
    }
    public void Phrases(View view)
    {
        Intent phraseintent=new Intent(this,PhrasesActivity.class);
        if(phraseintent.resolveActivity(getPackageManager())!=null)
            startActivity(phraseintent);
    }
    public void Colors(View view)
    {
        Intent colorintent=new Intent(this,ColorsActivity.class);
        if(colorintent.resolveActivity(getPackageManager())!=null)
            startActivity(colorintent);
    }*/

}
