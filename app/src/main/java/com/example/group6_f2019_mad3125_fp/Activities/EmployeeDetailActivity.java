package com.example.group6_f2019_mad3125_fp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.group6_f2019_mad3125_fp.Adapters.EmployeeDataAdapter;
import com.example.group6_f2019_mad3125_fp.Adapters.VehicleDataAdapter;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Vehicle;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;

import java.util.List;

public class EmployeeDetailActivity extends AppCompatActivity {

    TextView empid, empname, empage, emptype;
    LinearLayout intern,fulltime,parttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        empid = findViewById(R.id.textEmpID);
        empname = findViewById(R.id.textEmpName);
        empage = findViewById(R.id.textEmpAge);
        emptype = findViewById(R.id.textEmptype);
        intern = findViewById(R.id.layoutintern);
        fulltime = findViewById(R.id.layoutfulltime);
        parttime = findViewById(R.id.layoutparttime);

        Employee myemp = getIntent().getParcelableExtra("empobject");
        empid.setText(String.valueOf(myemp.getId()));
        empname.setText(myemp.getName());
        empage.setText(String.valueOf(myemp.getAge()) + "Years");
        emptype.setText(myemp.getType());

        if(myemp.getType().equalsIgnoreCase("intern"))
        {

            intern.setVisibility(View.VISIBLE);
            TextView school = findViewById(R.id.textEmpschool);
            school.setText(myemp.getSchoolName());

        }

        else if(myemp.getType().equalsIgnoreCase("fulltime"))
        {

            fulltime.setVisibility(View.VISIBLE);
            TextView salary = findViewById(R.id.textEmpsalaryfulltime);
            TextView totalsalary = findViewById(R.id.textEmptotalsalaryftime);
            salary.setText(String.valueOf(myemp.getSalary()) + " $ + " + String.valueOf(myemp.getBonus()) + " $ (C)" );
            String totalftimesalary = String.valueOf(myemp.getSalary() + myemp.getBonus()) + " $";
            totalsalary.setText(totalftimesalary);

        }
        else if(myemp.getType().equalsIgnoreCase("PartTime / Fixed Amount"))
        {

            parttime.setVisibility(View.VISIBLE);
            TextView salaryptime = findViewById(R.id.textEmpsalaryparttime);
            TextView totalsalaryptime = findViewById(R.id.textEmptotalsalaryptime);
            TextView commision = findViewById(R.id.textEmpcommisionptime);
            Double salary = myemp.getHoursWorked() * myemp.getRate();
            salaryptime.setText(String.valueOf(salary) + " $ (" + String.valueOf(myemp.getHoursWorked()) + " Hrs * " + String.valueOf(myemp.getRate()) + " $)" );
            String totalptimesalary = String.valueOf(salary + myemp.getFixedAmount());
            commision.setText(String.valueOf(myemp.getFixedAmount()) + " $");
            totalsalaryptime.setText(totalptimesalary + " $");

        }
        else if(myemp.getType().equalsIgnoreCase("PartTime / Commissioned"))
        {

            parttime.setVisibility(View.VISIBLE);
            TextView salaryptime = findViewById(R.id.textEmpsalaryparttime);
            TextView totalsalaryptime = findViewById(R.id.textEmptotalsalaryptime);
            TextView commisionpercent = findViewById(R.id.textEmpcommisionptime);
            Double salary = myemp.getHoursWorked() * myemp.getRate();
            salaryptime.setText(String.valueOf(salary) + " $ (" + String.valueOf(myemp.getHoursWorked()) + " Hrs * " + String.valueOf(myemp.getRate()) + " $)" );
            Double commision = salary * myemp.getCommissionPercent()/100;
            String totalpctimesalary = String.valueOf(salary + commision);
            commisionpercent.setText(String.valueOf(myemp.getCommissionPercent()) + " %");
            totalsalaryptime.setText(totalpctimesalary + " $");

        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        VehicleDataAdapter vehicleDataAdapter = new VehicleDataAdapter(this);
        EmployeeDB employeeDB = EmployeeDB.getInstance(this);
        List<Vehicle> vehicles = myemp.getVehicle();
        vehicleDataAdapter.setMyaaraylist(vehicles);
        recyclerView.setAdapter(vehicleDataAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);




    }
}
