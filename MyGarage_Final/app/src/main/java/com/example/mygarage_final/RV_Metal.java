package com.example.mygarage_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RV_Metal {
    private static Context mContext;
    private MetalAdapter mMetalAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Garage> garages, List<String> keys){
        mContext = context;
        mMetalAdapter = new MetalAdapter(garages,keys);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.rv_metal);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mMetalAdapter);

    }


    static class MetalItemView extends RecyclerView.ViewHolder{
        private TextView mGarageName;
        private TextView mPlace;
        private TextView mPhone;

        private String key;

        public MetalItemView(ViewGroup parent){
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
    static class MetalAdapter extends RecyclerView.Adapter<MetalItemView>{
        private List<Garage> mMetalList;
        private List<String> mKeys;

        public MetalAdapter(List<Garage> mMetalList, List<String> mKeys) {
            this.mMetalList = mMetalList;
            this.mKeys = mKeys;
        }

        public MetalAdapter() {
            super();
        }

        @NonNull
        @Override
        public MetalItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MetalItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MetalItemView holder, int position) {
        holder.bind(mMetalList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mMetalList.size();
        }
    }

}
