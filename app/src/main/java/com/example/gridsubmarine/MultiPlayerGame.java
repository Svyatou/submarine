package com.example.gridsubmarine;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Random;

import javax.xml.transform.Templates;

public class MultiPlayerGame extends AppCompatActivity {

    private TextView textView;
    TextView textAddplayer;
    EditText addName;
    Button btnStartpl;
    Button btnAddpl;
    TextView textPlayers;
    TextView textPlayers2;
    TextView textPlayers3;
    TextView textPlayers4;
    TextView textPlayers5;


    public final int MAX = 34;
    public int number;
    int score = 0;
    private TextView textScoremain;
    int maxPlayer = 0;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        Intent intent = getIntent();

        addPlayer();

        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }

    }

    void addPlayer(){
        setContentView(R.layout.add_player);

        btnAddpl = (Button)findViewById(R.id.btnAddpl);
        textPlayers = (TextView)findViewById(R.id.textAddplayer);
        textPlayers2 = (TextView)findViewById(R.id.textPlayers2);
        textPlayers3 = (TextView)findViewById(R.id.textPlayers3);
        textPlayers4 = (TextView)findViewById(R.id.textPlayers4);
        textPlayers5 = (TextView)findViewById(R.id.textPlayers5);

        textAddplayer = (TextView)findViewById(R.id.textAddplayer);
        addName = (EditText)findViewById(R.id.addName);
        btnStartpl = (Button)findViewById(R.id.btnStartpl);
        textAddplayer.setText("Введите имена игроков:");

        btnAddpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textPlayers.setText(addName.getText().toString());
                addName.setText("");
                textPlayers2.setText(addName.getText().toString());
                addName.setText("");
                textPlayers3.setText(addName.getText().toString());
                addName.setText("");
                textPlayers4.setText(addName.getText().toString());
                addName.setText("");
                textPlayers5.setText(addName.getText().toString());
                addName.setText("");
            }
        });

        btnStartpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initeGameMulti();
            }
        });
    }

    void initeGameMulti(){
            setContentView(R.layout.activity_main);

            GridView gridView = (GridView)findViewById(R.id.gridView);
            ImageAdapter imageAdapter = new ImageAdapter(this);
            gridView.setAdapter(new ImageAdapter(this));
            gridView.setOnItemClickListener(gridviewOnItemClickListener);

            score = 0;

            textScoremain = (TextView)findViewById(R.id.textScoremain);
            textScoremain.setText("Количество попыток: "+ String.valueOf(score));

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

            if (number == position) {
                Boom();
            } else if(number != position){

                ImageView viewI = (ImageView)v;
                Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                anim1.setDuration(1000);
                anim1.setStartOffset(20);
                viewI.setImageResource(R.drawable.no);
                viewI.startAnimation(anim1);
            }
        }
    };

    void Boom(){
        DialogNewMulti dialog = new DialogNewMulti();
        dialog.show(getSupportFragmentManager(), "");
    }
}
