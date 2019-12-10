package com.example.group6_f2019_mad3125_fp.ModelClasses;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressLint("ParcelCreator")
@Entity(tableName = "employee")
public class Employee implements Parcelable {

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

    @SerializedName("commissionPercent")
    @Expose
    private Integer commissionPercent;


    /**
     * No args constructor for use in serialization
     *
     */


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

     */
    public Employee(Integer id, String name, Integer age, String schoolName, String type, Double salary, Double bonus, Double rate, Integer hoursWorked, Double fixedAmount, Integer commissionPercent) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.vehicle = null;
        this.schoolName = schoolName;
        this.type = type;
        this.salary = salary;
        this.bonus = bonus;
        this.rate = rate;
        this.hoursWorked = hoursWorked;
        this.fixedAmount = fixedAmount;
        this.commissionPercent = commissionPercent;
    }


    protected Employee(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        if (in.readByte() == 0) {
            age = null;
        } else {
            age = in.readInt();
        }
        vehicle = in.createTypedArrayList(Vehicle.CREATOR);
        schoolName = in.readString();
        type = in.readString();
        if (in.readByte() == 0) {
            salary = null;
        } else {
            salary = in.readDouble();
        }
        if (in.readByte() == 0) {
            bonus = null;
        } else {
            bonus = in.readDouble();
        }
        if (in.readByte() == 0) {
            rate = null;
        } else {
            rate = in.readDouble();
        }
        if (in.readByte() == 0) {
            hoursWorked = null;
        } else {
            hoursWorked = in.readInt();
        }
        if (in.readByte() == 0) {
            fixedAmount = null;
        } else {
            fixedAmount = in.readDouble();
        }
        if (in.readByte() == 0) {
            commissionPercent = null;
        } else {
            commissionPercent = in.readInt();
        }
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public Integer getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(Integer commissionPercent) {
        this.commissionPercent = commissionPercent;
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

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public void setmyVehicle(Vehicle vehicle) {
        this.vehicle.add(vehicle);
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        if (age == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(age);
        }
        dest.writeTypedList(vehicle);
        dest.writeString(schoolName);
        dest.writeString(type);
        if (salary == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(salary);
        }
        if (bonus == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(bonus);
        }
        if (rate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(rate);
        }
        if (hoursWorked == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hoursWorked);
        }
        if (fixedAmount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(fixedAmount);
        }
        if (commissionPercent == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(commissionPercent);
        }
    }
}