package com.example.mygarage_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MetalListActivity extends AppCompatActivity {
private RecyclerView mRecyclerView;
private RV_Metal.MetalAdapter mMetalAdapter;
private List<Garage> mMetalList = new ArrayList<>();
private List<String> mKeys = new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metal_list);
        mRecyclerView = findViewById(R.id.rv_metal);
        mMetalAdapter = new RV_Metal.MetalAdapter(mMetalList,mKeys);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mMetalAdapter);





        new FirebaseDatabaseHelper().findMetal(new FirebaseDatabaseHelper.DataStatus() {
@Override
public void DataIsLoaded(List<Garage> garages, List<String> keys) {
        new RV_Metal().setConfig(mRecyclerView, MetalListActivity.this, garages, keys);
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

