package com.example.mygarage_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class VentListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RV_Vent.VentAdapter mVentAdapter;
    private List<Garage> mVentList = new ArrayList<>();
    private List<String> mKeys = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vent_list);
        mRecyclerView = findViewById(R.id.rv_vent);
        mVentAdapter = new RV_Vent.VentAdapter(mVentList, mKeys);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mVentAdapter);





                new FirebaseDatabaseHelper().findVent(new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Garage> garages, List<String> keys) {
                        new RV_Vent().setConfig(mRecyclerView, VentListActivity.this, garages, keys);
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












