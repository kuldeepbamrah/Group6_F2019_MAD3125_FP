package com.example.group6_f2019_mad3125_fp.ModelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("vehicle")
    @Expose
    private Vehicle vehicle;
    @SerializedName("schoolName")
    @Expose
    private String schoolName;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public Employee() {
    }

    /**
     *
     * @param name
     * @param id
     * @param schoolName
     * @param type
     * @param age
     * @param vehicle
     */
    public Employee(Integer id, String name, Integer age, Vehicle vehicle, String schoolName, String type) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
        this.schoolName = schoolName;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}