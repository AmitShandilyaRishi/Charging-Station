package com.amit.chargingstations;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;

    public RecyclerAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder
    {
        private TextView place_name;
        private TextView latitude;
        private TextView longitude;
        private TextView type;
        private TextView rating;
        private TextView availability;

        public ItemViewHolder(View itemView){
            super(itemView);
            place_name  = itemView.findViewById(R.id.place_name);
            latitude  = itemView.findViewById(R.id.latitude);
            longitude  = itemView.findViewById(R.id.longitude);
            type  = itemView.findViewById(R.id.type);
            rating  = itemView.findViewById(R.id.rating);
            availability = itemView.findViewById(R.id.availability1);


        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case TYPE:
                default:
                    View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

                    return new ItemViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType =getItemViewType(position);
        switch (viewType){
            case TYPE:
            default:
                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                data data = (com.amit.chargingstations.data) listRecyclerItem.get(position);

                itemViewHolder.place_name.setText(data.getLocation());
                itemViewHolder.latitude.setText(data.getLatitude());
                itemViewHolder.longitude.setText(data.getLongitude());
                itemViewHolder.type.setText(data.getType());
                itemViewHolder.rating.setText(data.getRating());
                itemViewHolder.availability.setText(data.getAvailability());

                if (data.getAvailability().equals("Free")){
                    itemViewHolder.availability.setTextColor(Color.GREEN);
                }else {
                    itemViewHolder.availability.setTextColor(Color.RED);
                }


        }

    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}
