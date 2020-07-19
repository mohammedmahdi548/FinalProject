package com.example.mygarage_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RV_Others {
    private static Context mContext;
    private OthersAdapter mOthersAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Garage> garages, List<String> keys){
        mContext = context;
        mOthersAdapter = new OthersAdapter(garages,keys);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.rv_other);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mOthersAdapter);

    }


    static class OthersItemView extends RecyclerView.ViewHolder{
        private TextView mGarageName;
        private TextView mPlace;
        private TextView mPhone;

        private String key;

        public OthersItemView(ViewGroup parent){
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
    static class OthersAdapter extends RecyclerView.Adapter<OthersItemView>{
        private List<Garage> mOthersList;
        private List<String> mKeys;

        public OthersAdapter(List<Garage> mOthersList, List<String> mKeys) {
            this.mOthersList = mOthersList;
            this.mKeys = mKeys;
        }

        public OthersAdapter() {
            super();
        }

        @NonNull
        @Override
        public OthersItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new OthersItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull OthersItemView holder, int position) {
        holder.bind(mOthersList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mOthersList.size();
        }
    }

}
