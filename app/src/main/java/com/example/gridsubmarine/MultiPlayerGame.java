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
    ImageView imageNo;
    TextView textAddplayer;
    EditText addName;
    Button btnStartpl;
    Button btnAddpl;
    TextView textPlayers;
    TextView textPlayers2;
    TextView textPlayers3;
    TextView textPlayers4;
    TextView textPlayers5;
    TextView textInfoHOD;
    String player;
    String player2;
    String player3;
    String player4;
    String player5;
    String winner;
    TextView infoPlayer;
    TextView infoPlayer2;
    TextView infoPlayer3;
    TextView infoPlayer4;
    TextView infoPlayer5;

    public final int MAX = 34;
    public int number;
    int score = 0, score2 = 0, score3 = 0, score4 = 0, score5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }

        addPlayer();
    }

    void addPlayer(){
        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
        setContentView(R.layout.add_player);

        btnAddpl = (Button)findViewById(R.id.btnAddpl);
        textPlayers = (TextView)findViewById(R.id.textPlayers);
        textPlayers2 = (TextView)findViewById(R.id.textPlayers2);
        textPlayers3 = (TextView)findViewById(R.id.textPlayers3);
        textPlayers4 = (TextView)findViewById(R.id.textPlayers4);
        textPlayers5 = (TextView)findViewById(R.id.textPlayers5);

        textAddplayer = (TextView)findViewById(R.id.textAddplayer);
        addName = (EditText)findViewById(R.id.addName);
        btnStartpl = (Button)findViewById(R.id.btnStartpl);
        textAddplayer.setText("Введите имена игроков:");

        textPlayers.setText("Игрок 1");
        textPlayers2.setText("Игрок 2");
        textPlayers3.setText("Игрок 3");
        textPlayers4.setText("Игрок 4");
        textPlayers5.setText("Игрок 5");
        final String n = "Игрок 1";
        final String n2 = "Игрок 2";
        final String n3 = "Игрок 3";
        final String n4 = "Игрок 4";
        final String n5 = "Игрок 5";


        btnAddpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(addName.length() == 0)
            {addName.setHint("Вы не ввели имя!");}
                else if(textPlayers.getText().toString().equals(n) && addName.length()!= 0)
                {textPlayers.setText(addName.getText());
                player = String.valueOf(textPlayers);
                addName.setText("");
                addName.setHint("Введите имя");
                }
                else if(textPlayers2.getText().toString().equals(n2) && addName.length()!= 0)
                {textPlayers2.setText(addName.getText());
                    player2 = String.valueOf(textPlayers2);
                addName.setText("");
                addName.setHint("Введите имя");}
                else if(textPlayers3.getText().toString().equals(n3) && addName.length()!= 0)
                {textPlayers3.setText(addName.getText());
                    player3 = String.valueOf(textPlayers3);
                addName.setText("");
                addName.setHint("Введите имя");}
                else if(textPlayers4.getText().toString().equals(n4) && addName.length()!= 0)
                {textPlayers4.setText(addName.getText());
                    player4 = String.valueOf(textPlayers4);
                addName.setText("");
                addName.setHint("Введите имя");}
                else if(textPlayers5.getText().toString().equals(n5) && addName.length()!= 0)
                {textPlayers5.setText(addName.getText());
                    player5 = String.valueOf(textPlayers5);
                addName.setText("");
                addName.setHint("Введите имя");}
                else if (addName.length()!=0)
                {addName.setText("");
                addName.setHint("Не больше 5 игроков!");}
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
        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
            setContentView(R.layout.multiplayer_main);

            GridView gridViewMulti = (GridView)findViewById(R.id.gridViewMulti);
            ImageAdapter imageAdapter = new ImageAdapter(this);
            gridViewMulti.setAdapter(new ImageAdapter(this));
            gridViewMulti.setOnItemClickListener(gridviewOnItemClickListener);
            score = 0;
            Random random = new Random();
            number = random.nextInt(MAX);
        }
    private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener(){


        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id){

//            Количество попыток у игроков, имя игрока чей ход в игре и нажатия на поле.
            }
    };

    void Boom(){
//        DialogNewMulti dialog = new DialogNewMulti();
//        dialog.show(getSupportFragmentManager(), "");
    }
}
