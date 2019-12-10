package com.example.group6_f2019_mad3125_fp.ui.logout;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.group6_f2019_mad3125_fp.R;

public class LogOutFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        showVehicleDialog(getActivity(),"Are you sure you want to log out");


     //customDialog.showDialog(getActivity(),"Are you sure you want to Log Out?");
        return null;
    }



    public void showVehicleDialog(final Activity context, String msg) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog_twobutton);

        TextView text = dialog.findViewById(R.id.dialogtext);
        text.setText(msg);

        Button dialogButton = dialog.findViewById(R.id.customButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();
                getActivity().finish();

            }
        });
        Button dialogNoButton = dialog.findViewById(R.id.customButtonNo);
        dialogNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                getActivity().onBackPressed();
            }
        });


        dialog.show();

    }
}