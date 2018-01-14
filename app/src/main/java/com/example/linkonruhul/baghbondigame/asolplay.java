package com.example.linkonruhul.baghbondigame;

/**
 * Created by LINKON RUHUL on 17/01/2017.
 */

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class asolplay extends AppCompatActivity {

    static int[] myarr = {11, 12, 13, 21, 22, 23, 31, 32, 33, 42, 51, 52, 53, 61, 62, 63, 71, 72, 73};
    int[] loop = {1, -1, 10, -10};
    int[] current = {11, 12, 13, 21, 22, 23, 32};
    int bagh = 72;
    int clicked = 0;
    int asolc = 0;
    int[] middle={31,33,51,53};
    int[] clickable = new int[100];
    int cnt = 0;
    int left=7,score=10000;

    boolean found(int x) {
        for (int i = 0; i < current.length; i++) {
            if (current[i] == x)
                return true;
        }

        return false;
    }

    boolean found2(int x) {
        for (int i = 0; i < myarr.length; i++) {
            if (myarr[i] == x)
                return true;
        }

        return false;
    }


    class dontchange implements Animator.AnimatorListener {
        Button b1, b2, b3;
        int nw,check,del;

        public dontchange(Button bnn1, Button bnn2, Button bnn3, int k,int c,int d) {
            b1 = bnn1;
            b2 = bnn2;
            b3 = bnn3;
            nw = k;
            check=c;
            del=d;
        }

        @Override
        public void onAnimationStart(Animator animation) {


            b2.setVisibility(View.INVISIBLE);
            int[] buttons = {R.id.base11, R.id.base12, R.id.base13, R.id.base21, R.id.base22, R.id.base23, R.id.base33, R.id.base32, R.id.base31, R.id.base42, R.id.base51, R.id.base52,
                    R.id.base53, R.id.base61, R.id.base62, R.id.base63, R.id.base71, R.id.base72, R.id.base73
            };
            for (int i = 0; i < buttons.length; i++) {
                Button buttonNum = (Button) findViewById(buttons[i]);
                buttonNum.setBackgroundResource(R.drawable.images);

            }

        }

        @Override
        public void onAnimationEnd(Animator animation) {

            b3.setVisibility(View.VISIBLE);


            for (int i = 0; i < 100; i++)
                clickable[i] = 0;

            if(check==0){
                Button lf=(Button)findViewById(R.id.left);
                left--;
                lf.setText("Left "+(left));
                if(left<=3){

                    Button sc=(Button)findViewById(R.id.score);
                    sc.setBackgroundResource(R.drawable.ns);

                }
                int[] but = {R.id.mvb22, R.id.mvb21, R.id.mvb23, R.id.mvb11, R.id.mvb12, R.id.mvb13, R.id.mvb32};
                for (int i = 0; i < but.length; i++) {
                    Button butNum = (Button) findViewById(but[i]);
                    int off=Integer.parseInt((butNum.getText().toString()));

                    if(off==del){
                        butNum.setVisibility(View.INVISIBLE);
                        String bbbb="base"+del;
                        int resId = getResources().getIdentifier(bbbb, "id", getPackageName());
                        Button yyy = (Button) findViewById(resId);
                        yyy.setVisibility(View.VISIBLE);
                        for(int j=0;j<current.length;j++) {
                            if (current[j] == off)
                                current[j] = 0;
                        }

                    }
                }


            }
            Button sc=(Button)findViewById(R.id.score);
            Button lf=(Button)findViewById(R.id.left);
            sc.setBackgroundResource(R.drawable.score);
            lf.setBackgroundResource(R.drawable.score);
        }

        @Override
        public void onAnimationCancel(Animator animation) {
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }
    }


    class change implements Animator.AnimatorListener {
        Button b1, b2, b3;
        int nw;

        public change(Button bnn1, Button bnn2, Button bnn3, int k) {
            b1 = bnn1;
            b2 = bnn2;
            b3 = bnn3;
            nw = k;
        }

        @Override
        public void onAnimationStart(Animator animation) {


            b2.setVisibility(View.INVISIBLE);
            int[] buttons = {R.id.base11, R.id.base12, R.id.base13, R.id.base21, R.id.base22, R.id.base23, R.id.base33, R.id.base32, R.id.base31, R.id.base42, R.id.base51, R.id.base52,
                    R.id.base53, R.id.base61, R.id.base62, R.id.base63, R.id.base71, R.id.base72, R.id.base73
            };
            for (int i = 0; i < buttons.length; i++) {
                Button buttonNum = (Button) findViewById(buttons[i]);
                buttonNum.setBackgroundResource(R.drawable.images);

            }

        }

        @Override
        public void onAnimationEnd(Animator animation) {

            b3.setVisibility(View.VISIBLE);
            for (int i = 0; i < 100; i++)
                clickable[i] = 0;
            Button lf=(Button)findViewById(R.id.score);
            score-=100;
            lf.setText("Score "+(score));
            tigermove();
        }

        @Override
        public void onAnimationCancel(Animator animation) {
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asolplay);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more informatio


        int[] buttons = {R.id.mvb22, R.id.mvb21, R.id.mvb23, R.id.mvb11, R.id.mvb12, R.id.mvb13, R.id.mvb32};
        for (int i = 0; i < buttons.length; i++) {
            Button buttonNum = (Button) findViewById(buttons[i]);
            buttonNum.setOnClickListener(doSomething);
        }


        int[] basebuttons = {R.id.base11, R.id.base12, R.id.base13, R.id.base21, R.id.base22, R.id.base23, R.id.base33, R.id.base32, R.id.base31, R.id.base42, R.id.base51, R.id.base52,
                R.id.base53, R.id.base61, R.id.base62, R.id.base63, R.id.base71, R.id.base72, R.id.base73
        };

        for (int i = 0; i < basebuttons.length; i++) {
            Button buttonNum = (Button) findViewById(basebuttons[i]);
            buttonNum.setOnClickListener(moveSomething);
        }


    }

    private View.OnClickListener moveSomething = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = ((Button) v).getText().toString();
            int x = Integer.parseInt(name);
            if (clickable[x] == 1) {
                String clickedbutton = "mvb" + clicked;
                String dest = "base" + x;
                String base = "base" + asolc;
                for (int i = 0; i < current.length; i++) {
                    if (current[i] == asolc)
                        current[i] = x;


                }


                Button asol = (Button) findViewById(getResources().getIdentifier(clickedbutton, "id", getPackageName()));

                Button nokol = (Button) findViewById(getResources().getIdentifier(dest, "id", getPackageName()));
                Button mid = (Button) findViewById(getResources().getIdentifier(base, "id", getPackageName()));
                asol.setText(""+x);
                ObjectAnimator move = ObjectAnimator.ofFloat(asol, "x", asol.getX(), nokol.getX());
                move.setDuration(300);

                move.setStartDelay(50);
                ObjectAnimator move2 = ObjectAnimator.ofFloat(asol, "y", asol.getY(), nokol.getY());
                move2.setDuration(300);
                move2.setStartDelay(50);
                AnimatorSet set2 = new AnimatorSet();
                set2.playTogether(move, move2);
                set2.addListener(new change(asol, nokol, mid, x));
                set2.start();



            }
        }


    };


    private View.OnClickListener doSomething = new View.OnClickListener() {
        @Override

        public void onClick(View v) {


            for (int i = 0; i < 100; i++)
                clickable[i] = 0;
            int[] buttons = {R.id.base11, R.id.base12, R.id.base13, R.id.base21, R.id.base22, R.id.base23, R.id.base33, R.id.base32, R.id.base31, R.id.base42, R.id.base51, R.id.base52,
                    R.id.base53, R.id.base61, R.id.base62, R.id.base63, R.id.base71, R.id.base72, R.id.base73
            };
            for (int i = 0; i < buttons.length; i++) {
                Button buttonNum = (Button) findViewById(buttons[i]);
                buttonNum.setBackgroundResource(R.drawable.images);
            }


            String name = ((Button) v).getText().toString();
            int x = Integer.parseInt(name);
            asolc = x;
            String Id = v.getResources().getResourceName(v.getId());
            String pp = "";
            String s = "";
            for (int i = 0; i < Id.length(); i++) {
                if (Id.charAt(i) >= '0' && Id.charAt(i) <= '9') {
                    pp += Id.charAt(i);
                }


            }

            clicked = Integer.parseInt(pp);
            for (int i = 0; i <= 3; i++) {
                int xxx = x + loop[i];

                for (int j = 0; j < myarr.length; j++) {
                    if (myarr[j] == xxx && xxx!=bagh) {
                        s = "base" + xxx;
                        clickable[xxx] = 1;
                        int resId = getResources().getIdentifier(s, "id", getPackageName());
                        Button yyy = (Button) findViewById(resId);
                        yyy.setBackgroundResource(R.drawable.bc);
                    }
                    if(x==31|| x==33 || x==51 || x==53){
                        clickable[42]=1;
                        Button yyy = (Button) findViewById(R.id.base42);
                        yyy.setBackgroundResource(R.drawable.bc);
                    }
                    if(x==42){
                        for(int k=0;k<middle.length;k++){
                            s = "base" +middle[k];
                            clickable[middle[k]] = 1;
                            int resId = getResources().getIdentifier(s, "id", getPackageName());
                            Button yyy = (Button) findViewById(resId);
                            yyy.setBackgroundResource(R.drawable.bc);
                        }



                    }

                }


            }


        }

    };

    public void tigermove() {

        String nnn = "";
        String s = "";
        String bb = "";
        int havetodel = 0;
        ArrayList<Integer> a = new ArrayList();

        Button tiger = (Button) findViewById(R.id.bagh);

        int x = bagh;
        int check = 1;
        for (int i = 0; i <= 3; i++) {
            int xxx = x + loop[i];
            int temp = xxx + loop[i];

            for (int j = 0; j < myarr.length; j++) {
                if (myarr[j] == xxx && !found(xxx)) {
                    a.add(xxx);

                } else if (myarr[j] == xxx && found(xxx) && found2(temp) && !found(temp)) {
                    s = "base" + temp;
                    bb = "base" + bagh;
                    bagh = temp;
                    check = 0;
                    havetodel=xxx;
                    break;
                }




            }


        }
        if(check==1) {
            if (x == 42) {
                for(int i=0;i<middle.length;i++){
                    int xxx=middle[i];
                    int temp;
                    if(xxx>middle[i])
                        temp=middle[i]+10;
                    else
                        temp=middle[i]-10;
                    if (!found(xxx)) {
                        a.add(xxx);


                    } else if (found(xxx) && found2(temp) && !found(temp)) {
                        s = "base" + temp;
                        bb = "base" + bagh;
                        bagh = temp;
                        check = 0;
                        havetodel=xxx;
                        break;
                    }

                }

            }
            else    if (x == 31 || x == 33 || x == 51 || x == 53) {
                int dif=42-x ;
                int temp=42+dif;
                if (!found(42)) {
                    a.add(42);


                } else if (found(42) && found2(temp) && !found(temp)) {
                    s = "base" + temp;
                    bb = "base" + bagh;
                    bagh = temp;
                    havetodel=42;
                    check = 0;

                }
            }
            else if(x==21 || x==23 || x==61 || x ==63){
                int temp=x+10;
                if(x>42){
                    temp=x-10;
                }


                if(found(temp) && !found(42) ){
                    s="base"+42;
                    bb="base"+bagh;
                    bagh=42;
                    check=0;
                    havetodel=temp;
                }
            }

        }
        if(check==0){

            if(left<=4){

                Button sc=(Button)findViewById(R.id.score);
                sc.setBackgroundResource(R.drawable.ns);
                Intent intent = new Intent(this, lost.class);
                startActivity(intent);
            }
            Button lf=(Button)findViewById(R.id.left);
            lf.setBackgroundResource(R.drawable.ns);

        }
        boolean sesh=false;
        if(check==1 && a.size()==0){
            sesh=true;

            Button lf=(Button)findViewById(R.id.left);
            lf.setBackgroundResource(R.drawable.ns);
            Intent intent = new Intent(this, win.class);
            intent.putExtra("score", score);
            startActivity(intent);

        }

        else if (check == 1) {
            int len = a.size();
            Random rn = new Random();
            int nw = rn.nextInt(len);
            int xx = a.get(nw);
            s = "base" + xx;
            bb = "base" + bagh;
            bagh = xx;
        }


        if(!sesh) {
            int resId = getResources().getIdentifier(s, "id", getPackageName());
            Button yyy = (Button) findViewById(resId);
            int res = getResources().getIdentifier(bb, "id", getPackageName());
            Button mid = (Button) findViewById(res);

            ObjectAnimator movebagh = ObjectAnimator.ofFloat(tiger, "x", mid.getX(), yyy.getX());
            movebagh.setDuration(1000);
            movebagh.setStartDelay(1000);
            ObjectAnimator move2bagh = ObjectAnimator.ofFloat(tiger, "y", mid.getY(), yyy.getY());
            move2bagh.setDuration(1000);
            move2bagh.setStartDelay(100);
            AnimatorSet set = new AnimatorSet();
            set.playTogether(movebagh, move2bagh);
            set.addListener(new dontchange(tiger, yyy, mid,bagh,check,havetodel));


            set.start();
        }
    }


}

