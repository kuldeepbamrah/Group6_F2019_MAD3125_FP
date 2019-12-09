package com.example.group6_f2019_mad3125_fp.ui.ListOfEmployee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group6_f2019_mad3125_fp.Adapters.EmployeeDataAdapter;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;

import java.util.List;

public class ListOfEmployeeFragment extends Fragment {

    List<Employee> employees;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_employeelist,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        EmployeeDataAdapter customerDataAdapter = new EmployeeDataAdapter(getContext());
        EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
        employees = employeeDB.daoObjct().getUserDetails();
        customerDataAdapter.setMyaaraylist(employees);
        recyclerView.setAdapter(customerDataAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;


    }
}