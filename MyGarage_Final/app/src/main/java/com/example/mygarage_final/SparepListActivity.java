package com.example.mygarage_final;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SparepListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RV_Sparep.SparepAdapter mSparepAdapter;
    private List<Garage> mSparepList = new ArrayList<>();
    private List<String> mKeys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sparep_list);
        mRecyclerView = findViewById(R.id.rv_sparep);
        mSparepAdapter = new RV_Sparep.SparepAdapter(mSparepList,mKeys);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mSparepAdapter);





        new FirebaseDatabaseHelper().findSparep(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Garage> garages, List<String> keys) {
                new RV_Sparep().setConfig(mRecyclerView, SparepListActivity.this, garages, keys);
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

