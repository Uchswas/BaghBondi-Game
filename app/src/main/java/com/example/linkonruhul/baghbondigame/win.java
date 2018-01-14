package com.example.linkonruhul.baghbondigame;

/**
 * Created by LINKON RUHUL on 17/01/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        TextView t=(TextView) findViewById(R.id.scorebox);
        TextView ht=(TextView) findViewById(R.id.high);
        int score = getIntent().getIntExtra("score", 0);
        t.setText("Your Score " +Integer.toString(score));
        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int   highScore = prefs.getInt("score", 0);


        if (highScore > score) {
            ht.setText("High Score \n" +Integer.toString(highScore));
        } else {
            highScore = score;
            ht.setText(" New High Score \n  " + Integer.toString(highScore));
            prefs.edit().putInt("score", highScore).apply();
        }



    }
}

