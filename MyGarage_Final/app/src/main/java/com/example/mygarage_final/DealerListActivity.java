package com.example.mygarage_final;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DealerListActivity extends AppCompatActivity {
private RecyclerView mRecyclerView;
private RV_Dealer.DealerAdapter mDealerAdapter;
private List<Garage> mDealerList = new ArrayList<>();
private List<String> mKeys = new ArrayList<>();
private ImageView GaragePic ;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_list);
        mRecyclerView = findViewById(R.id.rv_dealer);
        mDealerAdapter = new RV_Dealer.DealerAdapter(mDealerList,mKeys);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mDealerAdapter);





        new FirebaseDatabaseHelper().findDealer(new FirebaseDatabaseHelper.DataStatus() {
@Override
public void DataIsLoaded(List<Garage> garages, List<String> keys) {
        new RV_Dealer().setConfig(mRecyclerView, DealerListActivity.this, garages, keys);
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

