package com.example.group6_f2019_mad3125_fp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog {

    public void showDialog(final Activity context, String msg){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog_twobutton);

        TextView text = (TextView) dialog.findViewById(R.id.dialogtext);
        text.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.customButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                context.finish();
            }
        });
        Button dialogNoButton = (Button) dialog.findViewById(R.id.customButtonNo);
        dialogNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();

    }

    public class CustomhelpDialog {

        public void showDialog(final Activity context, String msg){
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.custom_dialog_twobutton);

            TextView text = (TextView) dialog.findViewById(R.id.dialogtext);
            text.setText(msg);

            Button dialogButton = (Button) dialog.findViewById(R.id.customButton);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                    context.finish();
                }
            });
            Button dialogNoButton = (Button) dialog.findViewById(R.id.customButtonNo);
            dialogNoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });


            dialog.show();

        }
}

