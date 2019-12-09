package com.example.group6_f2019_mad3125_fp.RoomDB;

import androidx.room.TypeConverter;

import com.example.group6_f2019_mad3125_fp.ModelClasses.Vehicle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class EmpVehicleTypeConverter
{
    @TypeConverter
    public static List<Vehicle> fromString(String value)
    {
        Type listType = new TypeToken<List<Vehicle>>() {}.getType();
        return new Gson().fromJson(value,listType);
    }

    @TypeConverter
    public static  String fromVehicle(List<Vehicle> vehicles)
    {
        Gson gson = new Gson();
        String json = gson.toJson(vehicles);
        return json;
    }
}
