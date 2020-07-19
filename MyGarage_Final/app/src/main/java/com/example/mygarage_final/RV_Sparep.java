package com.example.mygarage_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RV_Sparep {
    private static Context mContext;
    private SparepAdapter mSparepAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Garage> garages, List<String> keys){
        mContext = context;
        mSparepAdapter = new SparepAdapter(garages,keys);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.rv_sparep);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mSparepAdapter);

    }


    static class SparepItemView extends RecyclerView.ViewHolder{
        private TextView mGarageName;
        private TextView mPlace;
        private TextView mPhone;

        private String key;

        public SparepItemView(ViewGroup parent){
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
    static class SparepAdapter extends RecyclerView.Adapter<SparepItemView>{
        private List<Garage> mSparepList;
        private List<String> mKeys;

        public SparepAdapter(List<Garage> mSparepList, List<String> mKeys) {
            this.mSparepList = mSparepList;
            this.mKeys = mKeys;
        }

        public SparepAdapter() {
            super();
        }

        @NonNull
        @Override
        public SparepItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SparepItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SparepItemView holder, int position) {
        holder.bind(mSparepList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mSparepList.size();
        }
    }

}
