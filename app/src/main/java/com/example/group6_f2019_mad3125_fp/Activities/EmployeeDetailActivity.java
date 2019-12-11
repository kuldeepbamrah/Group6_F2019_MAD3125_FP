package com.example.group6_f2019_mad3125_fp.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group6_f2019_mad3125_fp.Adapters.VehicleDataAdapter;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Vehicle;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;
import com.example.group6_f2019_mad3125_fp.SwipeToDeleteCallbackForEmployee;
import com.example.group6_f2019_mad3125_fp.SwipeToDeleteCallbackForVehicle;

import java.util.List;

public class EmployeeDetailActivity extends AppCompatActivity {

    TextView empid, empname, empage, emptype, detailtext;
    LinearLayout intern,fulltime,parttime;
    Employee employeetemp;
    int x;


//    @Override
//    protected void onResume() {
//
//        final Employee myemp = getIntent().getParcelableExtra("empobject");
//        EmployeeDB employeeDB = EmployeeDB.getInstance(this);
//        List<Employee> employees = employeeDB.daoObjct().getDefault();
//        x = employees.indexOf(myemp);
//        x = getIntent().getIntExtra("empindex",0);
//        //Toast.makeText(this,"onResume"+x,Toast.LENGTH_SHORT).show();
//
//        employeetemp = employees.get(x);
//        List<Vehicle> vehicles = myemp.getVehicle();
//
//            RecyclerView recyclerView1 = findViewById(R.id.recycler_vehicle);
//            final VehicleDataAdapter vehicleDataAdapter = new VehicleDataAdapter(this);
//          vehicleDataAdapter.setMyaaraylist(vehicles);
//            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//            recyclerView1.setLayoutManager(layoutManager);
//            recyclerView1.setAdapter(vehicleDataAdapter);
//
//
//        ItemTouchHelper itemTouchHelper = new
//                ItemTouchHelper(new SwipeToDeleteCallbackForVehicle(vehicleDataAdapter));
//        itemTouchHelper.attachToRecyclerView(recyclerView1);
//
//            final EmployeeDB uData = EmployeeDB.getInstance(this);
//
//
//            uData.daoObjct().getCurrentUserDetails(myemp.getId()).observe(this, new Observer<Employee>() {
//                @Override
//                public void onChanged(@Nullable Employee employee) {
//                    List<Vehicle> bills = employee.getVehicle();
//                    vehicleDataAdapter.setMyaaraylist(bills);
//                    vehicleDataAdapter.setMyemployee(employeetemp);
//                    vehicleDataAdapter.notifyDataSetChanged();
//                }
//            });
//
//        super.onResume();
//
//
//    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);
        Toast.makeText(this,"Oncreate called",Toast.LENGTH_SHORT).show();
        empid = findViewById(R.id.textEmpID);
        empname = findViewById(R.id.textEmpName);
        empage = findViewById(R.id.textEmpAge);
        emptype = findViewById(R.id.textEmptype);
        intern = findViewById(R.id.layoutintern);
        fulltime = findViewById(R.id.layoutfulltime);
        parttime = findViewById(R.id.layoutparttime);
        detailtext = findViewById(R.id.detailtext1);

        Employee myemp = getIntent().getParcelableExtra("empobject");
        empid.setText(String.valueOf(myemp.getId()));
        empname.setText(myemp.getName());
        empage.setText(myemp.getAge() + "Years");
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
            salary.setText(myemp.getSalary() + " $ + " + myemp.getBonus() + " $ (C)" );
            String totalftimesalary = (myemp.getSalary() + myemp.getBonus()) + " $";
            totalsalary.setText(totalftimesalary);

        }
        else if(myemp.getType().equalsIgnoreCase("PartTime / Fixed Amount"))
        {

            parttime.setVisibility(View.VISIBLE);
            TextView salaryptime = findViewById(R.id.textEmpsalaryparttime);
            TextView totalsalaryptime = findViewById(R.id.textEmptotalsalaryptime);
            TextView commision = findViewById(R.id.textEmpcommisionptime);
            Double salary = myemp.getHoursWorked() * myemp.getRate();
            salaryptime.setText(salary + " $ (" + myemp.getHoursWorked() + " Hrs * " + myemp.getRate() + " $)" );
            String totalptimesalary = String.valueOf(salary + myemp.getFixedAmount());
            commision.setText(myemp.getFixedAmount() + " $");
            totalsalaryptime.setText(totalptimesalary + " $");

        }
        else if(myemp.getType().equalsIgnoreCase("PartTime / Commissioned"))
        {

            parttime.setVisibility(View.VISIBLE);
            TextView salaryptime = findViewById(R.id.textEmpsalaryparttime);
            TextView totalsalaryptime = findViewById(R.id.textEmptotalsalaryptime);
            TextView commisionpercent = findViewById(R.id.textEmpcommisionptime);
            Double salary = myemp.getHoursWorked() * myemp.getRate();
            salaryptime.setText(salary + " $ (" + myemp.getHoursWorked() + " Hrs * " + myemp.getRate() + " $)" );
            Double commision = salary * myemp.getCommissionPercent()/100;
            String totalpctimesalary = String.valueOf(salary + commision);
            commisionpercent.setText(myemp.getCommissionPercent() + " %");
            totalsalaryptime.setText(totalpctimesalary + " $");

        }



        List<Vehicle> vehicles = myemp.getVehicle();

        if (vehicles ==  null)
        {
            detailtext.setText("No vehicles Registered");
            //List<Vehicle> mybills = new ArrayList<Vehicle>();

            Toast.makeText(this,"No vehicle",Toast.LENGTH_SHORT).show();

        }
        else {



            RecyclerView recyclerView1 = findViewById(R.id.recycler_vehicle);
            final VehicleDataAdapter vehicleDataAdapter = new VehicleDataAdapter(this);
            vehicleDataAdapter.setMyaaraylist(vehicles);
            vehicleDataAdapter.setMyemployee(myemp);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView1.setLayoutManager(layoutManager);
            recyclerView1.setAdapter(vehicleDataAdapter);


            ItemTouchHelper itemTouchHelper = new
                    ItemTouchHelper(new SwipeToDeleteCallbackForVehicle(vehicleDataAdapter));
            itemTouchHelper.attachToRecyclerView(recyclerView1);

            final EmployeeDB uData = EmployeeDB.getInstance(this);


            uData.daoObjct().getCurrentUserDetails(myemp.getId()).observe(this, new Observer<Employee>() {
                @Override
                public void onChanged(@Nullable Employee employee) {
                    List<Vehicle> bills = employee.getVehicle();
                    vehicleDataAdapter.setMyaaraylist(bills);
                    vehicleDataAdapter.setMyemployee(employee);
                    vehicleDataAdapter.notifyDataSetChanged();
                }
            });

        }









    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_vehicle,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.vehicle_add:
                //Employee emptemp =getIntent().getParcelableExtra("empobject");
                EmployeeDB employeeDB = EmployeeDB.getInstance(this);
                List<Employee> employees = employeeDB.daoObjct().getDefault();
                Employee emptemp = employees.get(getIntent().getIntExtra("empindex",0));
                Intent myintent = new Intent(this, AddVehicleActivity.class);
                myintent.putExtra("empobjectvehicle",emptemp);
                startActivity(myintent);
                //   Toast.makeText(HomeActivity.this,"Select Values",Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }


}
