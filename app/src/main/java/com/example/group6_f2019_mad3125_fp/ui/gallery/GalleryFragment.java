package com.example.group6_f2019_mad3125_fp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group6_f2019_mad3125_fp.Adapters.CustomerDataAdapter;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;

import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    List<Employee> employees;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_employeelist,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        CustomerDataAdapter customerDataAdapter = new CustomerDataAdapter(getContext());
        EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
        employees = employeeDB.daoObjct().getUserDetails();
        customerDataAdapter.setMyaaraylist(employees);
        recyclerView.setAdapter(customerDataAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;


    }
}