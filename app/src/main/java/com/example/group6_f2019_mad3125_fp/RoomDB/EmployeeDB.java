package com.example.group6_f2019_mad3125_fp.RoomDB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;

@Database(entities = Employee.class , exportSchema = false , version = 2)
@TypeConverters({EmpVehicleTypeConverter.class})
public abstract class EmployeeDB extends RoomDatabase
{

    public static final String DB_NAME = "user_db";

    private static  EmployeeDB uInstance;


    public static EmployeeDB getInstance(Context context)
    {
        if(uInstance == null)
        {
            uInstance = Room.databaseBuilder(context.getApplicationContext(),EmployeeDB.class,EmployeeDB.DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return uInstance;
    }


    public abstract EmployeeDao daoObjct();
}
