package com.example.experimentrus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.HolderData> {
    List<TemanKelas> listData;
    LayoutInflater inflater;

    public Adapter(Context context, List<TemanKelas> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_data, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        TemanKelas temanKelas = listData.get(position);
        holder.textNama.setText(temanKelas.getNama());
        holder.textKelas.setText(temanKelas.getKelas());

        Glide.with(holder.itemView.getContext())
                .load(temanKelas.getImage())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = temanKelas.getNama();
                Toast.makeText(holder.itemView.getContext(), name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView textNama;
        TextView textKelas;
        ImageView imageView;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            textNama = itemView.findViewById(R.id.textNama);
            textKelas = itemView.findViewById(R.id.textKelas);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
