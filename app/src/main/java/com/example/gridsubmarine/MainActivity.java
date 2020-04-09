package com.example.gridsubmarine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    public final int MAX = 34;
    public int number;
    int score = 0;
    private TextView textScoremain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }

        textView = (TextView)findViewById(R.id.info);
        textScoremain = (TextView)findViewById(R.id.textScoremain);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(gridviewOnItemClickListener);

        initGame();
    }

    void initGame(){

        Random random = new Random();
        number = random.nextInt(MAX);

    }

    private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener(){

//        Выводится номер позиции.
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id){

            score++;

            textScoremain = (TextView)findViewById(R.id.textScoremain);
            textScoremain.setText("Количество попыток: "+ String.valueOf(score));


            textView = (TextView)findViewById(R.id.info);

            Animation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(1000);
            anim.setStartOffset(20);
            textView.startAnimation(anim);

            textView.setText("Ваш выбор: " +String.valueOf(position+1));

            if (number == position){
                Boom();
            }
        }
    };

    void Boom(){
        DialogNew dialog = new DialogNew();
        dialog.show(getSupportFragmentManager(), "");
    }
}
