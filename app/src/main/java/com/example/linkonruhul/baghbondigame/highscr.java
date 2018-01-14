package com.example.linkonruhul.baghbondigame;

/**
 * Created by LINKON RUHUL on 17/01/2017.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.id.text1;

public class highscr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscr);
        TextView tt=(TextView) findViewById(R.id.text22);
        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int text2= prefs.getInt("Score", 0);
        tt.setText("High Score \n" +text2);
    }

}

