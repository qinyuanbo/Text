package com.example.text;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadpet extends RecyclerView.Adapter<Myadpet.Myviewhodel> {
    ArrayList<String> data;
    int anInt=0;
    int baind=0;

    public Myadpet(ArrayList data) {
        this.data = data;
    }

    @NonNull
    @Override

    public Myadpet.Myviewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        anInt++;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        Myviewhodel myviewhodel = new Myviewhodel(inflate);
        Log.d("itim",anInt+"");
        return myviewhodel;
    }

    @Override
    public void onBindViewHolder(@NonNull Myadpet.Myviewhodel holder, int position) {
        baind++;
        holder.viewById.setText(data.get(position));
        Log.d("baind",baind+"");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Myviewhodel extends RecyclerView.ViewHolder {
        TextView viewById;
        public Myviewhodel(@NonNull View itemView) {
            super(itemView);
            viewById= (TextView)itemView.findViewById(R.id.text1);
        }
    }
}
