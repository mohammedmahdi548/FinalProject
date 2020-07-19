package com.example.mygarage_final;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OthersListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RV_Others.OthersAdapter mOthersAdapter;
    private List<Garage> mOthersList = new ArrayList<>();
    private List<String> mKeys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others_list);
        mRecyclerView = findViewById(R.id.rv_other);
        mOthersAdapter = new RV_Others.OthersAdapter(mOthersList,mKeys);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mOthersAdapter);





        new FirebaseDatabaseHelper().findOthers(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Garage> garages, List<String> keys) {
                new RV_Others().setConfig(mRecyclerView, OthersListActivity.this, garages, keys);
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

