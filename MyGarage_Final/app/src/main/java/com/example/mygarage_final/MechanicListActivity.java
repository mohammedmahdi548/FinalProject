package com.example.mygarage_final;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MechanicListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RV_Mechanic.MechanicAdapter mMechanicAdapter;
    private List<Garage> mMechanicList = new ArrayList<>();
    private List<String> mKeys = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_list);
        mRecyclerView = findViewById(R.id.rv_mechanic);
        mMechanicAdapter = new RV_Mechanic.MechanicAdapter(mMechanicList,mKeys);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mMechanicAdapter);





        new FirebaseDatabaseHelper().findMechanic(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Garage> garages, List<String> keys) {
                new RV_Mechanic().setConfig(mRecyclerView, MechanicListActivity.this, garages, keys);
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