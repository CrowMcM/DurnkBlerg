package com.example.durnkblerg;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

import androidx.recyclerview.widget.RecyclerView;


public class ListOfAppAdapter extends RecyclerView.Adapter<ListOfAppAdapter.MyViewHolder> {

    private List<AppList>appList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView app_name;
        public ImageView app_icon,status;

        public MyViewHolder(View view){
            super(view);
            app_name=(TextView)view.findViewById ( R.id.list_app_name );
            app_icon=(ImageView)view.findViewById ( R.id.app_icon );
            status=(ImageView)view.findViewById ( R.id.lock_icon );
        }
    }

    public ListOfAppAdapter(List<AppList>appLists){this.appList=appLists;}



    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView=LayoutInflater.from(parent.getContext ())
                .inflate ( R.layout.activity_app_list,parent,false );

        return new MyViewHolder ( itemView );
    }

    public void onBindViewHolder(MyViewHolder holder, int position){
        AppList applist=appList.get(position);
        holder.app_icon.setImageDrawable ( AppList.getIcon() );
        holder.app_name.setText(AppList.getName());
        holder.status.setImageResource ( AppList.getLocked() );
    }

    public int getItemCount(){return appList.size();}

}
