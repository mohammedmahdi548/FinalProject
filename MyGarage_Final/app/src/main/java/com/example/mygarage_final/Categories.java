package com.example.mygarage_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ImageView ven = findViewById(R.id.vent);
        ven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vent = new Intent(Categories.this, VentListActivity.class);
                startActivity(vent);
            }
        });
        ImageView tir = findViewById(R.id.tires);
        tir.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            Intent tire = new Intent(Categories.this, TiresListActivity.class);
            startActivity(tire);
        }
    });
        ImageView mec = findViewById(R.id.mechanic);
        mec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mech = new Intent(Categories.this, MechanicListActivity.class);
                startActivity(mech);
            }
        });
        ImageView met = findViewById(R.id.metal);
        met.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent met = new Intent(Categories.this, MetalListActivity.class);
                startActivity(met);
            }
        });
        ImageView pnt = findViewById(R.id.paint);
        pnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pant = new Intent(Categories.this, PaintListActivity.class);
                startActivity(pant);
            }
        });
        ImageView del = findViewById(R.id.dealer);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dlr = new Intent(Categories.this, DealerListActivity.class);
                startActivity(dlr);
            }
        });
        ImageView ele = findViewById(R.id.electric);
        ele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent elect = new Intent(Categories.this, ElectricListActivity.class);
                startActivity(elect);
            }
        });
        ImageView oth = findViewById(R.id.other);
        oth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otr = new Intent(Categories.this, OthersListActivity.class);
                startActivity(otr);
            }
        });
        ImageView spr = findViewById(R.id.spareparts);
        spr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spp = new Intent(Categories.this, SparepListActivity.class);
                startActivity(spp);
            }
        });

    }
}