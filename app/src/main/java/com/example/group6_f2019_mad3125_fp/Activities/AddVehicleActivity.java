package com.example.group6_f2019_mad3125_fp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.group6_f2019_mad3125_fp.CustomDialog;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Vehicle;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AddVehicleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText plate,make,model,type;
    TextView textswitch;
    Switch insurance;

    Button mybutton;
    String vplate ;
    String vmake ;
    String vmodel ;
    String vtype ;
    Boolean vinsurance;

    int x;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);
        x= generateRandomNumberBetweenRange(6,90);
        textswitch = findViewById(R.id.textswitch);
        plate = findViewById(R.id.editTextVehiclePlate);
        make = findViewById(R.id.editTextVehicleMake);
        model = findViewById(R.id.editTextVehicleModel);
        type = findViewById(R.id.editTextVehicleType);
        mybutton = findViewById(R.id.buttonvehicle);
        mybutton.setOnClickListener(this);


        insurance = findViewById(R.id.switchVehicleInsurance);

        textswitch.setVisibility(View.VISIBLE);
        textswitch.setText("False");
        textswitch.setBackgroundColor(Color.WHITE);
        textswitch.setTextColor(Color.RED);
        vinsurance = Boolean.FALSE;

        insurance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (insurance.isChecked())
                {
                    textswitch.setVisibility(View.VISIBLE);
                    textswitch.setText("True");
                    textswitch.setBackgroundColor(Color.WHITE);
                    textswitch.setTextColor(Color.GREEN);
                    vinsurance = Boolean.TRUE;
                }
                else
                {
                    textswitch.setVisibility(View.VISIBLE);
                    textswitch.setText("False");
                    textswitch.setBackgroundColor(Color.WHITE);
                    textswitch.setTextColor(Color.RED);
                    vinsurance = Boolean.FALSE;

                }

            }
        });



        spinner = findViewById(R.id.spinnervehicle);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicletype, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);



        type.setOnClickListener(this);







    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String textposition = parent.getSelectedItem().toString();
        type.setText(textposition);
       // Toast.makeText(view.getContext(),textposition,Toast.LENGTH_SHORT).show();

    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        type.setText("");

    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonvehicle:
                validationvehicle();
                break;
            case R.id.editTextVehicleType:
                spinner.performClick();
                break;


        }
    }


    public void validationvehicle()
    {
        vmake = make.getText().toString();
        vmodel = model.getText().toString();
        vplate = plate.getText().toString();
        vtype = type.getText().toString();



        if(vmodel.equals("") || vmake.equals("") || vplate.equals("") || vtype.equals(""))
        {
            CustomDialog mydialog = new CustomDialog();
            mydialog.showSingleDialog(AddVehicleActivity.this,"Please add All Vehicle values to complete the Vehicle Form");

        }
        else {


showVehicleDialog(AddVehicleActivity.this,"Are you sure you want to submit?");




            //Toast.makeText(AddCustomerActivity.this, "Added obj", Toast.LENGTH_SHORT).show();
        }
    }

    public void createvehicle()
    {




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

                Employee myemp = getIntent().getParcelableExtra("empobjectvehicle");

                Vehicle tempobject = new Vehicle(x,vmake,vplate,vmodel,vinsurance,vtype);

                final EmployeeDB uData = EmployeeDB.getInstance(AddVehicleActivity.this);

                if (myemp.getVehicle() == null)
                {
                    List<Vehicle> mybills = new ArrayList<Vehicle>();
                    mybills.add(tempobject);
                    myemp.setVehicle(mybills);
                    uData.daoObjct().update(myemp);
                }
                else
                {
                    myemp.setmyVehicle(tempobject);
                    uData.daoObjct().update(myemp);


                }


                //Gson gson = new Gson();



                dialog.dismiss();
                context.finish();
            }
        });
        Button dialogNoButton = dialog.findViewById(R.id.customButtonNo);
        dialogNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();

    }
    private int generateRandomNumberBetweenRange(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to);
    }
}



