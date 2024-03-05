package com.example.experimentrus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListSiswa10PPLG1 extends AppCompatActivity implements Adapter.ItemClickListener {
    RecyclerView recyclerView;
    List<siswa> listData;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_siswa10_pplg1);

        recyclerView = findViewById(R.id.rvData);
        listData = new ArrayList<>();

        siswa siswa1 = new siswa();
        siswa1.setNama("Nafi");
        siswa1.setKelas("10 PPLG 1");
        siswa1.setAbsen("1");
        siswa1.setImage("https://c4.wallpaperflare.com/wallpaper/732/170/347/hololive-nakiri-ayame-hd-wallpaper-preview.jpg");
        listData.add(siswa1);

        siswa siswa2 = new siswa();
        siswa2.setNama("Aldi");
        siswa2.setKelas("10 PPLG 1");
        siswa2.setAbsen("2");
        siswa2.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjkENLb8uftX3KJDxCkzGacWUPpYsWz9nBTyvIyEGgrA&s");
        listData.add(siswa2);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, listData);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        String name = listData.get(position).getNama();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

}