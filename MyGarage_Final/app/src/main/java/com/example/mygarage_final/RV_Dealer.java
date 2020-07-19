package com.example.mygarage_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RV_Dealer {
    private static Context mContext;
    private DealerAdapter mDealerAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Garage> garages, List<String> keys){
        mContext = context;
        mDealerAdapter = new DealerAdapter(garages,keys);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.rv_dealer);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mDealerAdapter);

    }


    static class DealerItemView extends RecyclerView.ViewHolder{
        private TextView mGarageName;
        private TextView mPlace;
        private TextView mPhone;

        private String key;

        public DealerItemView(ViewGroup parent){
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
    static class DealerAdapter extends RecyclerView.Adapter<DealerItemView>{
        private List<Garage> mDealerList;
        private List<String> mKeys;

        public DealerAdapter(List<Garage> mDealerList, List<String> mKeys) {
            this.mDealerList = mDealerList;
            this.mKeys = mKeys;
        }

        public DealerAdapter() {
            super();
        }

        @NonNull
        @Override
        public DealerItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new DealerItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull DealerItemView holder, int position) {
        holder.bind(mDealerList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mDealerList.size();
        }
    }

}
