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


public class RV_Paint {
    private static Context mContext;
    private PaintAdapter mPaintAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Garage> garages, List<String> keys){
        mContext = context;
        mPaintAdapter = new PaintAdapter(garages,keys);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.rv_paint);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mPaintAdapter);

    }


    static class PaintItemView extends RecyclerView.ViewHolder{
        private TextView mGarageName;
        private TextView mPlace;
        private TextView mPhone;


        private String key;

        public PaintItemView(ViewGroup parent){
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
    static class PaintAdapter extends RecyclerView.Adapter<PaintItemView>{
        private List<Garage> mPaintList;
        private List<String> mKeys;

        public PaintAdapter(List<Garage> mPaintList, List<String> mKeys) {
            this.mPaintList = mPaintList;
            this.mKeys = mKeys;
        }

        public PaintAdapter() {
            super();
        }

        @NonNull
        @Override
        public PaintItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PaintItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PaintItemView holder, int position) {
        holder.bind(mPaintList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mPaintList.size();
        }
    }

}
