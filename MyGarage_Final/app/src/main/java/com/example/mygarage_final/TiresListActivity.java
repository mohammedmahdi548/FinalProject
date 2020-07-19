package com.example.mygarage_final;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TiresListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RV_Tires.TiresAdapter mTiresAdapter;
    private List<Garage> mTiresList = new ArrayList<>();
    private List<String> mKeys = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tires_list);
       mRecyclerView = findViewById(R.id.rv_tires);
       mTiresAdapter = new RV_Tires.TiresAdapter(mTiresList,mKeys);
       RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
       mRecyclerView.setLayoutManager(manager);
       mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
       mRecyclerView.setAdapter(mTiresAdapter);





                new FirebaseDatabaseHelper().findTires(new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Garage> garages, List<String> keys) {
                        new RV_Tires().setConfig(mRecyclerView, TiresListActivity.this, garages, keys);
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