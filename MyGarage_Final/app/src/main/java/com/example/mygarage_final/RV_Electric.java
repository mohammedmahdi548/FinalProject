package com.example.mygarage_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RV_Electric {
    private static Context mContext;
    private ElectricAdapter mElectricAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Garage> garages, List<String> keys){
        mContext = context;
        mElectricAdapter = new ElectricAdapter(garages,keys);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.rv_electric);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mElectricAdapter);

    }


    static class ElectricItemView extends RecyclerView.ViewHolder{
        private TextView mGarageName;
        private TextView mPlace;
        private TextView mPhone;

        private String key;

        public ElectricItemView(ViewGroup parent){
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
    static class ElectricAdapter extends RecyclerView.Adapter<ElectricItemView>{
        private List<Garage> mElectricList;
        private List<String> mKeys;

        public ElectricAdapter(List<Garage> mElectricList, List<String> mKeys) {
            this.mElectricList = mElectricList;
            this.mKeys = mKeys;
        }

        public ElectricAdapter() {
            super();
        }

        @NonNull
        @Override
        public ElectricItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ElectricItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ElectricItemView holder, int position) {
        holder.bind(mElectricList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mElectricList.size();
        }
    }

}
