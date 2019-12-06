package com.example.group6_f2019_mad3125_fp.ModelClasses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "employee")
public class Employee {

    @PrimaryKey(autoGenerate = true)
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
    private List<Vehicle> vehicle;
    @SerializedName("schoolName")
    @Expose
    private String schoolName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("salary")
    @Expose
    private Double salary;
    @SerializedName("bonus")
    @Expose
    private Double bonus;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("hoursWorked")
    @Expose
    private Integer hoursWorked;
    @SerializedName("fixedAmount")
    @Expose
    private Double fixedAmount;

    /**
     * No args constructor for use in serialization
     *
     */
    public Employee() {
    }

    /**
     *
     * @param rate
     * @param bonus
     * @param name
     * @param id
     * @param fixedAmount
     * @param schoolName
     * @param type
     * @param salary
     * @param age
     * @param hoursWorked
     * @param vehicle
     */
    public Employee(Integer id, String name, Integer age, Vehicle vehicle, String schoolName, String type, Double salary, Double bonus, Double rate, Integer hoursWorked, Double fixedAmount) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
        this.schoolName = schoolName;
        this.type = type;
        this.salary = salary;
        this.bonus = bonus;
        this.rate = rate;
        this.hoursWorked = hoursWorked;
        this.fixedAmount = fixedAmount;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Double getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(Double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

}