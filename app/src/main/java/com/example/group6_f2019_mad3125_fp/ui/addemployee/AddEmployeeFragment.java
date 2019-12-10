package com.example.group6_f2019_mad3125_fp.ui.addemployee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;

import java.util.Objects;


public class AddEmployeeFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener
{
    Spinner spinner;
    EditText empType,empID,empFname,empAge,empEmail,empSchool,empSalary,empBonus,empFixedAmount,empHoursWorked,empHoursWorkedFT,empCommision,empHourlyRate, empHourlyRateFT;
    View empFT,empComm,empIntern,empFixed;
    Button addEmp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_addemployee,container,false);
        empType = view.findViewById(R.id.editTextEmpType);
        empID = view.findViewById(R.id.textEmpID);
        EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
        Integer x = employeeDB.daoObjct().count();
        empID.setText(x);
        empFname = view.findViewById(R.id.editTextEmpfname);
        empAge = view.findViewById(R.id.textEmpAge);
        empEmail = view.findViewById(R.id.editTextEmpemail);
        empFT =  view.findViewById(R.id.FullTime);
        empComm = view.findViewById(R.id.CommisionBasedPartTime);
        empIntern = view.findViewById(R.id.Intern);
        empFixed  = view.findViewById(R.id.FixedBasedPartTime);
        addEmp = view.findViewById(R.id.addCustomer);
        empSchool = view.findViewById(R.id.textEmpschool);
        empSalary = view.findViewById(R.id.editTextSalary);
        empBonus = view.findViewById(R.id.editTextBonus);
        empFixedAmount = view.findViewById(R.id.editTextFixed);
        empHoursWorked = view.findViewById(R.id.editTextHoursWorked);
        empHoursWorkedFT = view.findViewById(R.id.editTextHoursWorkedFT);
        empCommision  =view.findViewById(R.id.editTextCommision);
        empHourlyRate = view.findViewById(R.id.editTextHrate);
        empHourlyRateFT = view.findViewById(R.id.editTextHrateFT);





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
        else if(textposition.equalsIgnoreCase("Fixed Based Part Time"))
        {
            empIntern.setVisibility(View.GONE);
            empFixed.setVisibility(View.VISIBLE);
            empComm.setVisibility(View.GONE);
            empFT.setVisibility(View.GONE);
        }
        else if(textposition.equalsIgnoreCase("Commision Based Part Time"))
        {
            empIntern.setVisibility(View.GONE);
            empFixed.setVisibility(View.GONE);
            empComm.setVisibility(View.VISIBLE);
            empFT.setVisibility(View.GONE);
        }
        else if(textposition.equalsIgnoreCase("Full Time"))
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

                EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
                Integer x = employeeDB.daoObjct().count();

                String empname = empFname.getText().toString();
                String empemail = empEmail.getText().toString();
                String empage =  empAge.getText().toString();
                String emptype = empType.getText().toString();

                switch (emptype)
                {
                    case "Intern":

                        String schoolname = empSchool.getText().toString();
                        Employee myemp = new Employee(x+1,empname,Integer.parseInt(empage),schoolname,emptype,0.0,0.0,0.0,0,0.0,0);
                                employeeDB.daoObjct().insert(myemp);
                                break;
                    case "Full Time":
                        Double salaryftime = Double.parseDouble(empSalary.getText().toString());
                        Double bonusftime = Double.parseDouble(empBonus.getText().toString());
                        Employee myempftime = new Employee(x+1,empname,Integer.parseInt(empage),"",emptype,salaryftime,bonusftime,0.0,0,0.0,0);
                        employeeDB.daoObjct().insert(myempftime);
                        break;
                    case "Commision Based Part Time":
                        Integer hourscptime = Integer.parseInt(empHoursWorked.getText().toString());
                        Double ratecptime = Double.parseDouble(empHourlyRate.getText().toString());
                        Integer cmsncptime = Integer.parseInt(empCommision.getText().toString());

                        Employee myempcptime = new Employee(x+1,empname,Integer.parseInt(empage),"",emptype,0.0,0.0,ratecptime,hourscptime,0.0,cmsncptime);
                        employeeDB.daoObjct().insert(myempcptime);
                        break;
                    case "Fixed Based Part Time":
                        Integer hoursfptime = Integer.parseInt(empHoursWorkedFT.getText().toString());
                        Double ratefptime = Double.parseDouble(empHourlyRateFT.getText().toString());
                        Double fixedamountcptime = Double.parseDouble(empFixedAmount.getText().toString());

                        Employee myempfptime = new Employee(x+1,empname,Integer.parseInt(empage),"",emptype,0.0,0.0,ratefptime,hoursfptime,fixedamountcptime,0);
                        employeeDB.daoObjct().insert(myempfptime);
                        break;

                }


                break;

            case R.id.textEmptype:
                spinner.performClick();
                break;

        }

    }
}
