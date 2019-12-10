package com.example.group6_f2019_mad3125_fp.ui.ListOfEmployee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group6_f2019_mad3125_fp.Adapters.EmployeeDataAdapter;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;
import com.example.group6_f2019_mad3125_fp.SwipeToDeleteCallbackForEmployee;

import java.util.List;

public class ListOfEmployeeFragment extends Fragment {

    LiveData<List<Employee>> employees1;




    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_employeelist,container,false);


        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        final EmployeeDataAdapter employeeDataAdapter = new EmployeeDataAdapter(getContext());
        EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
        employeeDataAdapter.setMyaaraylist(employeeDB.daoObjct().getDefault());
        recyclerView.setAdapter(employeeDataAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new SwipeToDeleteCallbackForEmployee(employeeDataAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
        employeeDB.daoObjct().getUserDetails().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged( @Nullable List<Employee> employees) {


                    employeeDataAdapter.setMyaaraylist(employees);
                    employeeDataAdapter.notifyDataSetChanged();
            }
        });

    }
}