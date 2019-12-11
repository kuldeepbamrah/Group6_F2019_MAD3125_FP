package com.example.group6_f2019_mad3125_fp.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group6_f2019_mad3125_fp.Activities.EmployeeDetailActivity;
import com.example.group6_f2019_mad3125_fp.CustomDialog;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.ModelClasses.Vehicle;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;

import java.util.EnumMap;
import java.util.List;


public class VehicleDataAdapter extends RecyclerView.Adapter<VehicleDataAdapter.ViewHolder> {

    private Context context;
    private List<Vehicle> myaaraylist;
    private Employee myemployee;

    public Employee getMyemployee() {
        return myemployee;
    }

    public void setMyemployee(Employee myemployee) {
        this.myemployee = myemployee;
    }

    public VehicleDataAdapter(Context context)
    {
        this.context = context;
    }




    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Vehicle> getMyaaraylist() {
        return myaaraylist;
    }

    public void setMyaaraylist(List<Vehicle> myaaraylist) {
        this.myaaraylist = myaaraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_detail_cell,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {

        final Vehicle mydata = myaaraylist.get(position);


            holder.plate.setText("Vehicle's Plate: " + mydata.getPlate());
            holder.type.setText("Vehicle Type : " + mydata.getType());



        holder.mycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String alldatavehicle = "Vehicle Plate: " + mydata.getPlate() + "\n" + "Vehicle Type: " + mydata.getType()  + "\n" + "Vehicle Make: " + mydata.getMake()  + "\n" + "Vehicle Model: " + mydata.getModel()  + "\n" + "Vehicle Insurance: " + mydata.getInsurance().toString() ;
                CustomDialog mydialog = new CustomDialog();
                mydialog.showSingleDialog((Activity) context,alldatavehicle);

//                Intent myintent = new Intent(context, EmployeeDetailActivity.class);
//                myintent.putExtra("empobject", mydata);
//                context.startActivity(myintent);
                //  Toast.makeText(context,"position = "+position,Toast.LENGTH_LONG).show();

            }
        });

    }





    @Override
    public int getItemCount() {
        return myaaraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView plate, type;
        CardView mycardview;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            mycardview = itemView.findViewById(R.id.newcardvehicle);
            plate = itemView.findViewById(R.id.textViewVehicle1);
            type = itemView.findViewById(R.id.textViewVehicle2);




        }
    }

    public void deleteItem(int position) {

        Vehicle vehicle = myaaraylist.get(position);
        EmployeeDB employeeDB = EmployeeDB.getInstance(getContext());
        List<Vehicle> myvehicles = myemployee.getVehicle();
        myvehicles.remove(vehicle);
        employeeDB.daoObjct().update(myemployee);
        Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();
        myaaraylist.remove(position);
        notifyDataSetChanged();

    }
//    public void deleteItem(int position) {
//
//        Customer customer = myaaraylist.get(position);
//        UserDatabase userDatabase = UserDatabase.getInstance(getContext());
//        userDatabase.daoObjct().delete(customer);
//        Toast.makeText(getContext(),"Deleted",Toast.LENGTH_SHORT).show();
//        myaaraylist.remove(position);
//        notifyDataSetChanged();
//    }


}
