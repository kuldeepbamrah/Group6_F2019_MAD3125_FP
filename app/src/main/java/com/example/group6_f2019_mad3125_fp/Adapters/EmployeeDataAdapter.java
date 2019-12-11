package com.example.group6_f2019_mad3125_fp.Adapters;

import android.annotation.SuppressLint;
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
import com.example.group6_f2019_mad3125_fp.ModelClasses.Employee;
import com.example.group6_f2019_mad3125_fp.R;
import com.example.group6_f2019_mad3125_fp.RoomDB.EmployeeDB;

import java.util.List;


public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.ViewHolder> {

    private Context context;
    private List<Employee> myaaraylist;


    public EmployeeDataAdapter(Context context)
    {
        this.context = context;
    }




    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Employee> getMyaaraylist() {
        return myaaraylist;
    }

    public void setMyaaraylist(List<Employee> myaaraylist) {
        this.myaaraylist = myaaraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_detail_cell,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {

        final Employee mydata = myaaraylist.get(position);

        String fname = mydata.getName();

        holder.name.setText("Employee Name: "+ fname);
        holder.id.setText("Employee ID: "+mydata.getId().toString());
        holder.age.setText("Employee Age: "+mydata.getAge().toString()+" Years");

        holder.mycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myintent = new Intent(context, EmployeeDetailActivity.class);
                myintent.putExtra("empobject", mydata);
                myintent.putExtra("empindex",position);
                context.startActivity(myintent);
                //  Toast.makeText(context,"position = "+position,Toast.LENGTH_LONG).show();

            }
        });

    }





    @Override
    public int getItemCount() {
        return myaaraylist.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, age, id;
        CardView mycardview;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            mycardview = itemView.findViewById(R.id.newcard);
            id = itemView.findViewById(R.id.textView2);
            name = itemView.findViewById(R.id.textView3);
            age = itemView.findViewById(R.id.textView5);




        }
    }

    public void deleteItem(int position) {

        Employee employee = myaaraylist.get(position);
        EmployeeDB userDatabase = EmployeeDB.getInstance(getContext());
        userDatabase.daoObjct().delete(employee);
        Toast.makeText(getContext(),"Deleted",Toast.LENGTH_SHORT).show();
        myaaraylist.remove(position);
        notifyDataSetChanged();
    }


}
