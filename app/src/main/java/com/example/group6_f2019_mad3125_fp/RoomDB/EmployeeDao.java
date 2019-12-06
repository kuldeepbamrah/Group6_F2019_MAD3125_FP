package com.example.group6_f2019_mad3125_fp.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;

import java.util.List;
@Dao
public interface EmployeeDao {
    @Insert
    void insert(Employee employee);

    @Delete
    void delete(Employee employee);

    @Update
    void update(Employee employee);
    @Query("Select count(id) from employee")
    Integer count();

    @Query("Select * from employee")
    List<Employee> getUserDetails();
}
