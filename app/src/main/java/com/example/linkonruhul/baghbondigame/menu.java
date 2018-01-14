package com.example.linkonruhul.baghbondigame;

/**
 * Created by LINKON RUHUL on 17/01/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void playgame(View view) {
        Intent intent = new Intent(this, asolplay.class);
        startActivity(intent);
    }
    public void highsc(View view) {
        Intent intent = new Intent(this, highscr.class);
        startActivity(intent);
    }
    public void howtoplay(View view) {
        Intent intent = new Intent(this, howplay.class);
        startActivity(intent);
    }

    public void about(View view) {
        Intent intent = new Intent(this, about.class);
        startActivity(intent);
    }
}

