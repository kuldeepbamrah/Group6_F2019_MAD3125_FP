package com.example.group6_f2019_mad3125_fp.ui.addemployee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.group6_f2019_mad3125_fp.R;

import java.util.Objects;


public class AddEmployeeFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    EditText empType,empID,empFname,empAge,empEmail;
    View empFT,empComm,empIntern,empFixed;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_addemployee,container,false);
        empType = view.findViewById(R.id.editTextEmpType);
        empID = view.findViewById(R.id.textEmpID);
        empFname = view.findViewById(R.id.editTextEmpfname);
        empAge = view.findViewById(R.id.textEmpAge);
        empEmail = view.findViewById(R.id.editTextEmpemail);
        empFT =  view.findViewById(R.id.FullTime);
        empComm = view.findViewById(R.id.CommisionBasedPartTime);
        empIntern = view.findViewById(R.id.Intern);
        empFixed  = view.findViewById(R.id.FixedBasedPartTime);




        spinner =view.findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(this.getActivity()),
                R.array.emptype, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
       // spinner.setOnItemSelectedListener(this);
        
        empType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.performClick();
            }
        });
        return view;


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
