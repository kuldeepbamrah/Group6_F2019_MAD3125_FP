package com.example.group6_f2019_mad3125_fp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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

import static com.example.group6_f2019_mad3125_fp.R.color.Greencolor;

public class AddBillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText plate,make,model,type;
    TextView textswitch;
    Switch insurance;

    Button mybutton;
    String vplate ;
    String vmake ;
    String vmodel ;
    String vtype ;
    Boolean vinsurance;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

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



        spinner = (Spinner) findViewById(R.id.spinnervehicle);
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
            mydialog.showSingleDialog(AddBillActivity.this,"Please add All Vehicle values to complete the Vehicle Form");

        }
        else {

//            CustomDialog mydialog = new CustomDialog();
//            mydialog.showVehicleDialog(AddBillActivity.this,"Are you sure you want to submit?");

            Employee myemp = getIntent().getParcelableExtra("empobjectvehicle");
            Vehicle tempobject = new Vehicle(1,vmake,vplate,vmodel,vinsurance,vtype);

            final EmployeeDB uData = EmployeeDB.getInstance(AddBillActivity.this);


            myemp.setmyVehicle(tempobject);
            //Gson gson = new Gson();


            uData.daoObjct().update(myemp);




            //Toast.makeText(AddCustomerActivity.this, "Added obj", Toast.LENGTH_SHORT).show();
        }
    }

    public void createvehicle()
    {

        Employee myemp = getIntent().getParcelableExtra("empobjectvehicle");

        Vehicle tempobject = new Vehicle(1,vmake,vplate,vmodel,vinsurance,vtype);

        final EmployeeDB uData = EmployeeDB.getInstance(AddBillActivity.this);


        myemp.setmyVehicle(tempobject);
        //Gson gson = new Gson();


        uData.daoObjct().update(myemp);


    }
}



