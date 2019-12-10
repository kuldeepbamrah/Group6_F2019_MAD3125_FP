package com.example.group6_f2019_mad3125_fp.ui.addemployee;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.group6_f2019_mad3125_fp.CustomDialog;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;

import java.util.Objects;


public class AddEmployeeFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener
{
    Spinner spinner;
    EditText empType,empID,empFname,empAge,empSchool,empSalary,empBonus,empFixedAmount,empHoursWorked,empHoursWorkedFT,empCommision,empHourlyRate, empHourlyRateFT;
    View empFT,empComm,empIntern,empFixed;
    Button addEmp;

    String  empname, empage, emptype, schoolname, salaryftime, bonusftime, hourscptime, ratecptime;
    String cmsncptime;
    String hoursfptime;
    String ratefptime ;
    String fixedamountcptime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_addemployee,container,false);
        empType = view.findViewById(R.id.editTextEmpType);
        empID = view.findViewById(R.id.editTextEmpID);

        empFname = view.findViewById(R.id.editTextEmpfname);
        empAge = view.findViewById(R.id.editTextEmpage);
        empFT =  view.findViewById(R.id.FullTime);
        empComm = view.findViewById(R.id.CommisionBasedPartTime);
        empIntern = view.findViewById(R.id.Intern);
        empFixed  = view.findViewById(R.id.FixedBasedPartTime);
        addEmp = view.findViewById(R.id.addCustomer);
        empSchool = view.findViewById(R.id.editTextEmpSchoolName);
        empSalary = view.findViewById(R.id.editTextSalary);
        empBonus = view.findViewById(R.id.editTextBonus);
        empFixedAmount = view.findViewById(R.id.editTextFixed);
        empHoursWorked = view.findViewById(R.id.editTextHoursWorked);
        empHoursWorkedFT = view.findViewById(R.id.editTextHoursWorkedFT);
        empCommision  =view.findViewById(R.id.editTextCommision);
        empHourlyRate = view.findViewById(R.id.editTextHrate);
        empHourlyRateFT = view.findViewById(R.id.editTextHrateFT);

        EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
        Integer x = employeeDB.daoObjct().count();

        empID.setText(String.valueOf(x+1));





        spinner =view.findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(this.getActivity()),
                R.array.emptype, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        empType.setOnClickListener(this);


        addEmp.setOnClickListener(this);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {

        String textposition =  adapterView.getSelectedItem().toString();
        empType.setText(textposition);


        if(textposition.equalsIgnoreCase("Intern"))
        {
            empIntern.setVisibility(View.VISIBLE);
            empFixed.setVisibility(View.GONE);
            empComm.setVisibility(View.GONE);
            empFT.setVisibility(View.GONE);

        }
        else if(textposition.equalsIgnoreCase("PartTime / Fixed Amount"))
        {
            empIntern.setVisibility(View.GONE);
            empFixed.setVisibility(View.VISIBLE);
            empComm.setVisibility(View.GONE);
            empFT.setVisibility(View.GONE);
        }
        else if(textposition.equalsIgnoreCase("PartTime / Commissioned"))
        {
            empIntern.setVisibility(View.GONE);
            empFixed.setVisibility(View.GONE);
            empComm.setVisibility(View.VISIBLE);
            empFT.setVisibility(View.GONE);
        }
        else if(textposition.equalsIgnoreCase("FullTime"))
        {
            empIntern.setVisibility(View.GONE);
            empFixed.setVisibility(View.GONE);
            empComm.setVisibility(View.GONE);
            empFT.setVisibility(View.VISIBLE);
        }
        //Toast.makeText(view.getContext(),textposition,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {
        empType.setText("");
    }

    @Override
    public void onClick(View view)
    {
        
        switch (view.getId())
        {
            case R.id.addCustomer:




                createemployee();



                break;

            case R.id.editTextEmpType:
                spinner.performClick();
                break;

        }

    }



    public void createemployee() {

        EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
        Integer x = employeeDB.daoObjct().count();

        empname = empFname.getText().toString();
        empage = empAge.getText().toString();
        emptype = empType.getText().toString();
        schoolname = empSchool.getText().toString();
        salaryftime = empSalary.getText().toString();
        bonusftime = empBonus.getText().toString();
        hourscptime = empHoursWorked.getText().toString();
        ratecptime = empHourlyRate.getText().toString();
        cmsncptime = empCommision.getText().toString();
        hoursfptime = empHoursWorkedFT.getText().toString();
        ratefptime = empHourlyRateFT.getText().toString();
        fixedamountcptime = empFixedAmount.getText().toString();




        if (empname.equals("") || empage.equals("") || emptype.equals("")) {
            CustomDialog mydialog = new CustomDialog();
           mydialog.showSingleDialog(getActivity(), "Please Insert all common fields to complete the add employee form");

        } else {

            switch (emptype) {
                case "Intern":

                    if(schoolname.equals(""))
                    {

                        CustomDialog mydialog = new CustomDialog();
                        mydialog.showSingleDialog(getActivity(), "Please Insert School Name field to complete the add employee form");


                    }
                    else {

                        showDialog(getActivity(),"Are you sure you want to submit?");


                    }
                    break;
                case "FullTime":

                    if(salaryftime.equals("") || bonusftime.equals(""))
                    {

                        CustomDialog mydialog = new CustomDialog();
                        mydialog.showSingleDialog(getActivity(), "Please insert All Full Time Employee fields to complete the add employee form");


                    }
                    else {
                        showDialog(getActivity(),"Are you sure you want to submit?");



                    }
                    break;
                case "PartTime / Commissioned":
                    if(hourscptime.equals("") || ratecptime.equals("") || cmsncptime.equals(""))
                    {

                        CustomDialog mydialog = new CustomDialog();
                        mydialog.showSingleDialog(getActivity(), "Please insert All Part Time Commision Employee fields to complete the add employee form");


                    }
                    else {

                        showDialog(getActivity(),"Are you sure you want to submit?");



                    }
                    break;
                case "PartTime / Fixed Amount":

                    if(hoursfptime.equals("") || ratefptime.equals("") || fixedamountcptime.equals(""))
                    {

                        CustomDialog mydialog = new CustomDialog();
                        mydialog.showSingleDialog(getActivity(), "Please insert All Part Time Fixed Employee fields to complete the add employee form");


                    }
                    else {

                        showDialog(getActivity(),"Are you sure you want to submit?");


                        Employee myempfptime = new Employee(x + 1, empname, Integer.parseInt(empage), "", emptype, 0.0, 0.0, Double.parseDouble(ratefptime), Integer.parseInt(hoursfptime), Double.parseDouble(fixedamountcptime), 0);
                        employeeDB.daoObjct().insert(myempfptime);
                        Toast.makeText(getContext(),"Part Time Fixed Amt Employee Added Successfully",Toast.LENGTH_SHORT).show();

                        getActivity().onBackPressed();
                    }
                    break;

            }

        }
    }



    public void showDialog(final Activity context, String msg) {
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

                EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
                Integer x = employeeDB.daoObjct().count();



                switch (emptype) {
                    case "Intern":
                        Employee myemp = new Employee(x + 1, empname, Integer.parseInt(empage), schoolname, emptype, 0.0, 0.0, 0.0, 0, 0.0, 0);
                        employeeDB.daoObjct().insert(myemp);
                        Toast.makeText(getContext(),"Intern Employee Added Successfully",Toast.LENGTH_SHORT).show();

                        dialog.dismiss();

                        getActivity().onBackPressed();
                        break;
                    case "FullTime":
                        Employee myempftime = new Employee(x + 1, empname, Integer.parseInt(empage), "", emptype, Double.parseDouble(salaryftime), Double.parseDouble(bonusftime), 0.0, 0, 0.0, 0);
                        employeeDB.daoObjct().insert(myempftime);
                        Toast.makeText(getContext(),"Full Time Employee Added Successfully",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                        getActivity().onBackPressed();
                        break;
                    case "PartTime / Commissioned":
                        Employee myempcptime = new Employee(x + 1, empname, Integer.parseInt(empage), "", emptype, 0.0, 0.0, Double.parseDouble(ratecptime), Integer.parseInt(hourscptime), 0.0, Integer.parseInt(cmsncptime));
                        employeeDB.daoObjct().insert(myempcptime);
                        Toast.makeText(getContext(),"Part Time Commisioned Employee Added Successfully",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                        getActivity().onBackPressed();
                        break;
                    case "PartTime / Fixed Amount":
                        Employee myempfptime = new Employee(x + 1, empname, Integer.parseInt(empage), "", emptype, 0.0, 0.0, Double.parseDouble(ratefptime), Integer.parseInt(hoursfptime), Double.parseDouble(fixedamountcptime), 0);
                        employeeDB.daoObjct().insert(myempfptime);
                        Toast.makeText(getContext(),"Part Time Fixed Amt Employee Added Successfully",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                        getActivity().onBackPressed();
                        break;





                }

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
}
