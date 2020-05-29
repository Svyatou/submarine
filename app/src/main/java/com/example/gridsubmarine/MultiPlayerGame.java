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
import java.util.Random;








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
    final String n = "Игрок 1";
    final String n2 = "Игрок 2";
    final String n3 = "Игрок 3";
    final String n4 = "Игрок 4";
    final String n5 = "Игрок 5";

    int p = 1;
    int k =0;
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

    void addPlayer() {
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

        btnAddpl = (Button) findViewById(R.id.btnAddpl);
        textPlayers = (TextView) findViewById(R.id.textPlayers);
        textPlayers2 = (TextView) findViewById(R.id.textPlayers2);
        textPlayers3 = (TextView) findViewById(R.id.textPlayers3);
        textPlayers4 = (TextView) findViewById(R.id.textPlayers4);
        textPlayers5 = (TextView) findViewById(R.id.textPlayers5);

        textAddplayer = (TextView) findViewById(R.id.textAddplayer);
        addName = (EditText) findViewById(R.id.addName);
        btnStartpl = (Button) findViewById(R.id.btnStartpl);
        textAddplayer.setText("Введите имена игроков:");

        textPlayers.setText("Игрок 1");
        textPlayers2.setText("Игрок 2");
        textPlayers3.setText("Игрок 3");
        textPlayers4.setText("Игрок 4");
        textPlayers5.setText("Игрок 5");


        btnAddpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (addName.length() == 0) {
                    addName.setHint("Вы не ввели имя!");
                } else if (textPlayers.getText().toString().equals(n) && addName.length() != 0) {
                    textPlayers.setText(addName.getText());
                    player = textPlayers.getText().toString();
                    addName.setText("");
                    addName.setHint("Введите имя");
                } else if (textPlayers2.getText().toString().equals(n2) && addName.length() != 0) {
                    textPlayers2.setText(addName.getText());
                    player2 = textPlayers2.getText().toString();
                    addName.setText("");
                    addName.setHint("Введите имя");
                } else if (textPlayers3.getText().toString().equals(n3) && addName.length() != 0) {
                    textPlayers3.setText(addName.getText());
                    player3 = textPlayers3.getText().toString();
                    addName.setText("");
                    addName.setHint("Введите имя");
                } else if (textPlayers4.getText().toString().equals(n4) && addName.length() != 0) {
                    textPlayers4.setText(addName.getText());
                    player4 = textPlayers4.getText().toString();
                    addName.setText("");
                    addName.setHint("Введите имя");
                } else if (textPlayers5.getText().toString().equals(n5) && addName.length() != 0) {
                    textPlayers5.setText(addName.getText());
                    player5 = textPlayers5.getText().toString();
                    addName.setText("");
                    addName.setHint("Введите имя");
                } else if (addName.length() != 0) {
                    addName.setText("");
                    addName.setHint("Не больше 5 игроков!");
                }
            }
        });

        btnStartpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addName.length() == 0 && (textPlayers.getText().toString()).equals(n) || (textPlayers.getText().toString()).equals(n)
                        || addName.length() == 0 && (textPlayers2.getText().toString()).equals(n2) || (textPlayers2.getText().toString()).equals(n2) )
                {addName.setText("");
                    addName.setHint("Должено быть хотя бы 2 игрока");} else{
                    initeGameMulti();
                        }
            }
        });
    }

    void initeGameMulti() {
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

        GridView gridViewMulti = (GridView) findViewById(R.id.gridViewMulti);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridViewMulti.setAdapter(new ImageAdapter(this));
        gridViewMulti.setOnItemClickListener(clickPlayer);
        score = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;
        score5 = 0;
        k=0;
        Random random = new Random();
        number = random.nextInt(MAX);

        infoPlayer = (TextView) findViewById(R.id.infoPlayer);

        infoPlayer2 = (TextView) findViewById(R.id.infoPlayer2);
        infoPlayer3 = (TextView) findViewById(R.id.infoPlayer3);
        infoPlayer4 = (TextView) findViewById(R.id.infoPlayer4);
        infoPlayer5 = (TextView) findViewById(R.id.infoPlayer5);

        if (textPlayers.getText().toString().equals(n)) {
            player = n;
            infoPlayer.setText(n + ": " + score);
        } else {
            infoPlayer.setText(String.valueOf(player + ": " + score));
        }
        if (textPlayers2.getText().toString().equals(n2)) {
            player2 = n2;
            infoPlayer2.setText(n2 + ": " + score2);
        } else {
            infoPlayer2.setText(String.valueOf(player2 + ": " + score2));
        }
        if (textPlayers3.getText().toString().equals(n3)) {
            infoPlayer3.setText(n3 + ": " + score3);
        } else {
            infoPlayer3.setText(String.valueOf(player3 + ": " + score3));
        }
        if (textPlayers4.getText().toString().equals(n4)) {
            infoPlayer4.setText(n4 + ": " + score4);
        } else {
            infoPlayer4.setText(String.valueOf(player4 + ": " + score4));
        }
        if (textPlayers5.getText().toString().equals(n5)) {
            infoPlayer5.setText(n5 + ": " + score5);
        } else {
            infoPlayer5.setText(String.valueOf(player5 + ": " + score5));
        }

        textInfoHOD = (TextView) findViewById(R.id.textInfoHOD);
    }
    GridView.OnItemClickListener clickPlayer = new GridView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

            switch (k++){
                case 0:
                { if (number == position) {
                    score++;
                    winner = player;
                    ImageView viewI = (ImageView) v;
                    Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                    anim1.setDuration(1000);
                    anim1.setStartOffset(20);
                    viewI.setImageResource(R.drawable.ok);
                    viewI.startAnimation(anim1);
                    Boom();
                } else if (number != position) {
                    score++;
                    textInfoHOD.setText("Переход хода к " + player2);
                    ImageView viewI = (ImageView) v;
                    Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                    anim1.setDuration(1000);
                    anim1.setStartOffset(20);
                    viewI.setImageResource(R.drawable.no);
                    viewI.startAnimation(anim1);
                }
                    break;}
                case 1:
                {if (number == position) {
                    score2++;
                    winner = player2;
                    ImageView viewI = (ImageView) v;
                    Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                    anim1.setDuration(1000);
                    anim1.setStartOffset(20);
                    viewI.setImageResource(R.drawable.ok);
                    viewI.startAnimation(anim1);
                    Boom();
                    Boom();
                } else if (number != position) {
                    score2++;
                    ImageView viewI = (ImageView) v;
                    Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                    anim1.setDuration(1000);
                    anim1.setStartOffset(20);
                    viewI.setImageResource(R.drawable.no);
                    viewI.startAnimation(anim1);
                    if(textPlayers3.getText().toString().equals(n3)){
                        k=0;
                        textInfoHOD.setText("Переход хода к " + player);
                    } else{
                        textInfoHOD.setText("Переход хода к " + player3);}
                }
                    break;}
                case 2:
                { if (number == position) {
                    score3++;
                    winner = player3;
                    ImageView viewI = (ImageView) v;
                    Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                    anim1.setDuration(1000);
                    anim1.setStartOffset(20);
                    viewI.setImageResource(R.drawable.ok);
                    viewI.startAnimation(anim1);
                    Boom();
                    Boom();
                } else if (number != position) {
                    score3++;

                    ImageView viewI = (ImageView) v;
                    Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                    anim1.setDuration(1000);
                    anim1.setStartOffset(20);
                    viewI.setImageResource(R.drawable.no);
                    viewI.startAnimation(anim1);
                    if(textPlayers4.getText().toString().equals(n4)){k=0; textInfoHOD.setText("Переход хода к " + player);}else{
                    textInfoHOD.setText("Переход хода к " + player4);}
                }
                    break;}
                case 3:{
                    if (number == position) {
                        score4++;
                        winner = player4;
                        ImageView viewI = (ImageView) v;
                        Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                        anim1.setDuration(1000);
                        anim1.setStartOffset(20);
                        viewI.setImageResource(R.drawable.ok);
                        viewI.startAnimation(anim1);
                        Boom();
                        Boom();
                    } else if (number != position) {
                        score4++;

                        ImageView viewI = (ImageView) v;
                        Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                        anim1.setDuration(1000);
                        anim1.setStartOffset(20);
                        viewI.setImageResource(R.drawable.no);
                        viewI.startAnimation(anim1);
                        if(textPlayers5.getText().toString().equals(n5)){k = 0; textInfoHOD.setText("Переход хода к " + player);}
                        else{textInfoHOD.setText("Переход хода к " + player5);}
                    }
                    break;}
                case 4:{
                    if (number == position) {
                        score5++;
                        winner = player5;
                        ImageView viewI = (ImageView) v;
                        Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                        anim1.setDuration(1000);
                        anim1.setStartOffset(20);
                        viewI.setImageResource(R.drawable.ok);
                        viewI.startAnimation(anim1);
                        Boom();
                        Boom();
                    } else if (number != position) {
                        score5++;
                        textInfoHOD.setText("Переход хода к " + player);
                        ImageView viewI = (ImageView) v;
                        Animation anim1 = new AlphaAnimation(0.0f, 1.0f);
                        anim1.setDuration(1000);
                        anim1.setStartOffset(20);
                        viewI.setImageResource(R.drawable.no);
                        viewI.startAnimation(anim1);
                        k = 0;
                    }
                    break;}
            }

            if (textPlayers.getText().toString().equals(n)) {
                player = n;
                infoPlayer.setText(n + ": " + score);
            } else {
                infoPlayer.setText(String.valueOf(player + ": " + score));
            }
            if (textPlayers2.getText().toString().equals(n2)) {
                player2 = n2;
                infoPlayer2.setText(n2 + ": " + score2);
            } else {
                infoPlayer2.setText(String.valueOf(player2 + ": " + score2));
            }
            if (textPlayers3.getText().toString().equals(n3)) {
                player3 = n3;
                infoPlayer3.setText(n3 + ": " + score3);
            } else {
                infoPlayer3.setText(String.valueOf(player3 + ": " + score3));
            }
            if (textPlayers4.getText().toString().equals(n4)) {
                player4 = n4;
                infoPlayer4.setText(n4 + ": " + score4);
            } else {
                infoPlayer4.setText(String.valueOf(player4 + ": " + score4));
            }
            if (textPlayers5.getText().toString().equals(n5)) {
                player5 = n5;
                infoPlayer5.setText(n5 + ": " + score5);
            } else {
                infoPlayer5.setText(String.valueOf(player5 + ": " + score5));
            }
        }};

    void IntentMenu(){
        Intent i;
        i = new Intent(MultiPlayerGame.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    void Boom() {
        DialogNewMulti dialog = new DialogNewMulti();
        dialog.show(getSupportFragmentManager(), "");
    }
}