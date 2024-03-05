package com.example.experimentrus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.HolderData> {
    List<siswa> listData;
    LayoutInflater inflater;
    private ItemClickListener mClickListener;

    public Adapter(Context context, List<siswa> listData) {
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
        siswa siswa = listData.get(position);
        holder.textNama.setText(siswa.getNama());
        holder.textKelas.setText(siswa.getKelas());

        Glide.with(holder.itemView.getContext())
                .load(siswa.getImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textNama;
        TextView textKelas;
        ImageView imageView;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            textNama = itemView.findViewById(R.id.textNama);
            textKelas = itemView.findViewById(R.id.textKelas);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}
