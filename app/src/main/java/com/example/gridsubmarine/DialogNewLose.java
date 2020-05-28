package com.example.gridsubmarine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class DialogNewLose  extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.layout_proigral, null);

        final TextView textLose = (TextView)dialogView.findViewById(R.id.textLose);
        final Button button01 = (Button)dialogView.findViewById(R.id.button01);
        final Button button02 = (Button)dialogView.findViewById(R.id.button02);
        TextView textScore2 = (TextView)dialogView.findViewById(R.id.textScore2);
        MainActivity call = (MainActivity) getActivity();
        int score = call.score;
        textScore2.setText("Количество попыток: " +String.valueOf(score));

        builder.setView(dialogView);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity callingActivity = (MainActivity) getActivity();
                callingActivity.startGame();
                dismiss();
            }
        });
        button01.setOnClickListener(new View.OnClickListener() {
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
