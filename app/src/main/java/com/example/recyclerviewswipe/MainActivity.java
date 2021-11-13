package com.example.recyclerviewswipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // o'zgaruvchini ishga tushuring

    RecyclerView recyclerView;
    ArrayList<String> arrayList = new ArrayList<>();
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // O'zgaruvchini tayinlash
        recyclerView = findViewById(R.id.recycler_view);

        // Ro'yhat qatoriga qiymatlarni qo'shing

        arrayList.addAll(Arrays.asList("Java","Kotlin","Android studio","JavaScript","Python","PHP","NodeJS","C++","Java1","Kotlin2","Android studio3","JavaScript4","Python5","PHP6","NodeJS7","C++8"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainAdapter(this,arrayList);

        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                arrayList.remove(viewHolder.getAdapterPosition());

                adapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);
    }
}