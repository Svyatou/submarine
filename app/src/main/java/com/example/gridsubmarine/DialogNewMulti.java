package com.example.gridsubmarine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import org.w3c.dom.Text;

public class DialogNewMulti extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.layout_dialogmulti, null);

        final Button btnMultireturn = (Button)dialogView.findViewById(R.id.btnMultireturn);
        final Button btnMultimenu = (Button)dialogView.findViewById(R.id.btnMultimenu);
        final TextView textPlayerP = (TextView)dialogView.findViewById(R.id.textPlayerP);
        final TextView textPlayerP2 = (TextView)dialogView.findViewById(R.id.textPlayerP2);
        final TextView textPlayerP3 = (TextView)dialogView.findViewById(R.id.textPlayerP3);
        final TextView textPlayerP4 = (TextView)dialogView.findViewById(R.id.textPlayerP4);
        final TextView textPlayerP5 = (TextView)dialogView.findViewById(R.id.textPlayerP5);
        final  TextView textWinner = (TextView)dialogView.findViewById(R.id.textWinner);
        MultiPlayerGame call = (MultiPlayerGame)getActivity();
        int score = call.score;
        int score2 = call.score2;
        int score3 = call.score3;
        int score4 = call.score4;
        int score5 = call.score5;
        String n2 = call.n2;
        String n3 = call.n3;
        String n4 = call.n4;
        String n5 = call.n5;
        String winner = call.winner;
        String player = call.player;
        String player2 = call.player2;
        String player3 = call.player3;
        String player4 = call.player4;
        String player5 = call.player5;

        textPlayerP.setText(player+ ": "+ score);
        if(player2.equals(null)){textPlayerP2.setText(n2+": "+score2);}
        else{textPlayerP2.setText(player2+": "+score2);}
        if(player3.equals(null)){textPlayerP3.setText(n3+": "+score3);}
        else{textPlayerP3.setText(player3+": "+score3);}
        if(player4.equals(null)){textPlayerP4.setText(n4+": "+score4);}
        else{textPlayerP4.setText(player4+": "+score4);}
        if(player5.equals(null)){textPlayerP5.setText(n5+": "+score5);}
        else{textPlayerP5.setText(player5+": "+score5);}
        textWinner.setText("Победитель: " +winner);


        builder.setView(dialogView);
        btnMultireturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiPlayerGame calling = (MultiPlayerGame)getActivity();
                calling.initeGameMulti();
                dismiss();
            }
        });
        btnMultimenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiPlayerGame calling = (MultiPlayerGame)getActivity();
                calling.IntentMenu();
                dismiss();
            }
        });

        return builder.create();
    }
    }
