package com.example.group6_f2019_mad3125_fp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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

import java.util.List;


public class CustomerDataAdapter extends RecyclerView.Adapter<CustomerDataAdapter.ViewHolder> {

    private Context context;
    private List<Employee> myaaraylist;


    public CustomerDataAdapter(Context context)
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

        holder.name.setText("Customer Name: "+ fname);
        holder.id.setText("Customer ID: "+mydata.getId().toString());
        holder.age.setText("Customer Age: "+mydata.getAge().toString()+" Years");

        holder.mycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myintent = new Intent(context, EmployeeDetailActivity.class);
                myintent.putExtra("empobject", mydata);
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
            id = (TextView)itemView.findViewById(R.id.textView2);
            name = (TextView)itemView.findViewById(R.id.textView3);
            age = (TextView)itemView.findViewById(R.id.textView5);




        }
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
