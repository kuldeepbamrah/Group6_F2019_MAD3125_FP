package com.example.group6_f2019_mad3125_fp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeFragment extends Fragment {

TextView numberemp, datetime;
Integer empcount;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
        empcount = employeeDB.daoObjct().count();
        numberemp = view.findViewById(R.id.textView4);
        numberemp.setText(String.valueOf(empcount));

        datetime = view.findViewById(R.id.textdateandtime);

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => "+c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MMMM-dd \n hh:mm:ss aa");
        String formattedDate = df.format(c.getTime());
        // formattedDate have current date/time


        // Now we display formattedDate value in TextView
        datetime.setText(formattedDate);
        return view;

    }
}