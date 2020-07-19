package com.example.mygarage_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RV_Mechanic {
    private static Context mContext;
    private MechanicAdapter mMechanicAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Garage> garages, List<String> keys){
        mContext = context;
        mMechanicAdapter = new MechanicAdapter(garages,keys);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.rv_mechanic);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mMechanicAdapter);

    }


    static class MechanicItemView extends RecyclerView.ViewHolder{
        private TextView mGarageName;
        private TextView mPlace;
        private TextView mPhone;


        private String key;

        public MechanicItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.garage_list_item,parent,false));

            mGarageName = (TextView) itemView.findViewById(R.id.garagename_txt);
            mPhone = (TextView) itemView.findViewById(R.id.phone_txt);
            mPlace = (TextView) itemView.findViewById(R.id.place_txt);


        }
        public void bind(Garage garage, String key){
            mGarageName.setText(garage.getGarageName());
            mPhone.setText(garage.getPhone());
            mPlace.setText(garage.getPlace());
            this.key = key;

        }
    }
    static class MechanicAdapter extends RecyclerView.Adapter<MechanicItemView>{
        private List<Garage> mMechanicList;
        private List<String> mKeys;

        public MechanicAdapter(List<Garage> mMechanicList, List<String> mKeys) {
            this.mMechanicList = mMechanicList;
            this.mKeys = mKeys;
        }

        public MechanicAdapter() {
            super();
        }

        @NonNull
        @Override
        public MechanicItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MechanicItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MechanicItemView holder, int position) {
        holder.bind(mMechanicList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mMechanicList.size();
        }
    }

}
