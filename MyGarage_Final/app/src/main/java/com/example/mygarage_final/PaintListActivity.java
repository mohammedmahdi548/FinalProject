package com.example.mygarage_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PaintListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RV_Paint.PaintAdapter mPaintAdapter;
    private List<Garage> mPaintList = new ArrayList<>();
    private List<String> mKeys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_list);
        mRecyclerView = findViewById(R.id.rv_paint);
        mPaintAdapter = new RV_Paint.PaintAdapter(mPaintList,mKeys);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mPaintAdapter);





        new FirebaseDatabaseHelper().findPaint(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Garage> garages, List<String> keys) {
                new RV_Paint().setConfig(mRecyclerView, PaintListActivity.this, garages, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }


        });


    }
}

