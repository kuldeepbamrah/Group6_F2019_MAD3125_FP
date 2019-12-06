package com.example.group6_f2019_mad3125_fp.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;

import java.util.List;

public interface EmployeeDao {
    @Insert
    void insert(Employee employee);

    @Delete
    void delete(Employee employee);

    @Update
    void update(Employee employee);

    @Query("Select * from employee")
    LiveData<List<Employee>> getUserDetails();
}
