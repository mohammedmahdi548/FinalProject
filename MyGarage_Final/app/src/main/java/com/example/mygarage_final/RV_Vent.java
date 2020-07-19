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


public class RV_Vent {
    private static Context mContext;
    private VentAdapter mVentAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Garage> garages, List<String> keys){
        mContext = context;
        mVentAdapter = new VentAdapter(garages,keys);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.rv_vent);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mVentAdapter);

    }


    static class VentItemView extends RecyclerView.ViewHolder{
        private TextView mGarageName;
        private TextView mPlace;
        private TextView mPhone;

        private String key;

        public VentItemView(ViewGroup parent){
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
    static class VentAdapter extends RecyclerView.Adapter<VentItemView>{
        private List<Garage> mVentList;
        private List<String> mKeys;

        public VentAdapter(List<Garage> mVentList, List<String> mKeys) {
            this.mVentList = mVentList;
            this.mKeys = mKeys;
        }

        public VentAdapter() {
            super();
        }

        @NonNull
        @Override
        public VentItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new VentItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull VentItemView holder, int position) {
        holder.bind(mVentList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mVentList.size();
        }
    }

}
