package com.example.linkonruhul.baghbondigame;

/**
 * Created by LINKON RUHUL on 17/01/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class lost extends AppCompatActivity {
    TextView tvHighScore, tvScore;
    Button btnRetry;
    int score;
    int highScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

    }
}

