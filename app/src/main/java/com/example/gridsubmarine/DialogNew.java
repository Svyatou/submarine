package com.example.gridsubmarine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import static android.content.Intent.getIntent;


public class DialogNew extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.layout_dialog, null);

        final TextView textView = (TextView)dialogView.findViewById(R.id.textv);
        final Button button1 = (Button)dialogView.findViewById(R.id.btn);
        final Button button2 = (Button)dialogView.findViewById(R.id.btn2);
        TextView textScore = (TextView)dialogView.findViewById(R.id.textScore);
        MainActivity call = (MainActivity) getActivity();
        int score = call.score;
        textScore.setText("Количество попыток: " +String.valueOf(score));

        builder.setView(dialogView);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity callingActivity = (MainActivity) getActivity();
                callingActivity.startGame();
                dismiss();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity callingActivity = (MainActivity) getActivity();
                callingActivity.initGame();
                dismiss();
            }
        });

        return builder.create();
    }
}
