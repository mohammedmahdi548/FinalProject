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


public class RV_Tires {
    private static Context mContext;
    private TiresAdapter mTiresAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Garage> garages, List<String> keys){
        mContext = context;
        mTiresAdapter = new TiresAdapter(garages,keys);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.rv_tires);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mTiresAdapter);

    }


    static class TiresItemView extends RecyclerView.ViewHolder{
        private TextView mGarageName;
        private TextView mPlace;
        private TextView mPhone;


        private String key;

        public TiresItemView(ViewGroup parent){
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
    static class TiresAdapter extends RecyclerView.Adapter<TiresItemView>{
        private List<Garage> mTiresList;
        private List<String> mKeys;

        public TiresAdapter(List<Garage> mTiresList, List<String> mKeys) {
            this.mTiresList = mTiresList;
            this.mKeys = mKeys;
        }

        public TiresAdapter() {
            super();
        }

        @NonNull
        @Override
        public TiresItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TiresItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TiresItemView holder, int position) {
        holder.bind(mTiresList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mTiresList.size();
        }
    }

}
