package com.example.dell.jokes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<String>  jokes;
    int num;
    public MyAdapter(JokesActivity jokesActivity, ArrayList<String> list, int count1) {
        context=jokesActivity;
        jokes=list;
        num=count1;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(jokes.get(position));
    }

    @Override
    public int getItemCount() {
        return num;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.joke_text);
        }
    }
}
