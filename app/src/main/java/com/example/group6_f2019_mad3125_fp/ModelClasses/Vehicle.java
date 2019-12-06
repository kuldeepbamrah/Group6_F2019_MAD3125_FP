package com.example.group6_f2019_mad3125_fp.ModelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("plate")
    @Expose
    private String plate;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("insurance")
    @Expose
    private Boolean insurance;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public Vehicle() {
    }

    /**
     *
     * @param insurance
     * @param plate
     * @param model
     * @param id
     * @param type
     * @param make
     */
    public Vehicle(Integer id, String make, String plate, String model, Boolean insurance, String type) {
        super();
        this.id = id;
        this.make = make;
        this.plate = plate;
        this.model = model;
        this.insurance = insurance;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
