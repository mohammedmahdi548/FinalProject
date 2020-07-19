package com.example.mygarage_final;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceGarages;
    private List<Garage> garages = new ArrayList<>();
    private Query mReferenceGarageQuery;







    public interface DataStatus{
        void DataIsLoaded(List<Garage> garages, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
//        mDatabase = FirebaseDatabase.getInstance();
//        mReferenceGarages =FirebaseDatabase.getInstance().getReference("GarageCategory");
//        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("GarageCategory");
//        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("vent");
    }

    public void findVent(final DataStatus dataStatus) {
        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("vent");


        mReferenceGarageQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                garages.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
//                    Garage garage = keyNode.getValue(Garage.class);
                    garages.add(keyNode.getValue(Garage.class));
                }
                dataStatus.DataIsLoaded(garages, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

        public void findTires(final DataStatus dataStatus){
            mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("tires");


            mReferenceGarageQuery.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    garages.clear();
                    List<String> keys = new ArrayList<>();
                    for (DataSnapshot keyNode : snapshot.getChildren()){
                        keys.add(keyNode.getKey());
//                        Garage garage = keyNode.getValue(Garage.class);
                        garages.add(keyNode.getValue(Garage.class));
                    }
                    dataStatus.DataIsLoaded(garages, keys);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

    }

    public void findMechanic( final DataStatus dataStatus) {
        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("mechanic");

        mReferenceGarageQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                garages.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
//                    Garage garage = keyNode.getValue(Garage.class);
                    garages.add(keyNode.getValue(Garage.class));
                }
                dataStatus.DataIsLoaded(garages, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void findPaint( final DataStatus dataStatus) {
        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("paint");

        mReferenceGarageQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                garages.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
//                    Garage garage = keyNode.getValue(Garage.class);
                    garages.add(keyNode.getValue(Garage.class));
                }
                dataStatus.DataIsLoaded(garages, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void findMetal( final DataStatus dataStatus) {
        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("metal");

        mReferenceGarageQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                garages.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
//                    Garage garage = keyNode.getValue(Garage.class);
                    garages.add(keyNode.getValue(Garage.class));
                }
                dataStatus.DataIsLoaded(garages, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void findDealer( final DataStatus dataStatus) {
        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("dealer");

        mReferenceGarageQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                garages.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
//                    Garage garage = keyNode.getValue(Garage.class);
                    garages.add(keyNode.getValue(Garage.class));
                }
                dataStatus.DataIsLoaded(garages, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void findElectric( final DataStatus dataStatus) {
        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("electric");

        mReferenceGarageQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                garages.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
//                    Garage garage = keyNode.getValue(Garage.class);
                    garages.add(keyNode.getValue(Garage.class));
                }
                dataStatus.DataIsLoaded(garages, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void findSparep( final DataStatus dataStatus) {
        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("sparep");

        mReferenceGarageQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                garages.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
//                    Garage garage = keyNode.getValue(Garage.class);
                    garages.add(keyNode.getValue(Garage.class));
                }
                dataStatus.DataIsLoaded(garages, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void findOthers( final DataStatus dataStatus) {
        mReferenceGarageQuery = FirebaseDatabase.getInstance().getReference("others");

        mReferenceGarageQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                garages.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
//                    Garage garage = keyNode.getValue(Garage.class);
                    garages.add(keyNode.getValue(Garage.class));
                }
                dataStatus.DataIsLoaded(garages, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
