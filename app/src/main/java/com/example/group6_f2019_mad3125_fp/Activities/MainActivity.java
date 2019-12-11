package com.example.group6_f2019_mad3125_fp.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import com.example.group6_f2019_mad3125_fp.JSONParser.JsonParser;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    String json = "";
    String temps;
    LiveData<List<Employee>> myarraylist;

//    @Override
//    public void onBackPressed() {
//        this.showlogoutDialog(this,"Are you sure you want to Log Out");
//    }


    public void showlogoutDialog(final Activity context, String msg) {
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
                finish();

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        //getting Initial data fro Json
        JsonParser jsonParser = new JsonParser();
        json = jsonParser.loadJSONFromAsset(MainActivity.this);

        if(json!=null)
        {
            Toast.makeText(MainActivity.this,"json read successful",Toast.LENGTH_LONG).show();
            final EmployeeDB employeeDB = EmployeeDB.getInstance(this);
            final Integer count = employeeDB.daoObjct().count();
            if(count == 0)
            {
                Gson gson = new Gson();

                try {
                    JSONArray jsonarray = new JSONArray(json);

                    for(int i =0 ; i<=jsonarray.length();i++)
                    {

                        temps = jsonarray.get(i).toString();
                        Employee employee = gson.fromJson(temps,Employee.class);
                        employeeDB.daoObjct().insert(employee);

                    }
                }catch (JSONException e)
                {
                    e.printStackTrace();
                }
                //end of data from json

            }

            //myarraylist = employeeDB.daoObjct().getUserDetails();
        }
        //json data end

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_help, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }




}
