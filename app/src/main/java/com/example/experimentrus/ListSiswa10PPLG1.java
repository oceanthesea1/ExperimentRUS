package com.example.experimentrus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ListSiswa10PPLG1 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<TemanKelas> listData;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_siswa10_pplg1);

        recyclerView = findViewById(R.id.rvData);
        listData = new ArrayList<>();

        TemanKelas siswa1 = new TemanKelas();
        siswa1.setNama("Ocean");
        siswa1.setKelas("10 PPLG 1");
        siswa1.setAbsen("29");
        siswa1.setImage("https://i.pinimg.com/736x/ea/5c/5c/ea5c5cec244c144c1b2e9de01866907f.jpg");
        listData.add(siswa1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, listData);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}