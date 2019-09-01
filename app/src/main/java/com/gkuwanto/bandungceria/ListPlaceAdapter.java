package com.gkuwanto.bandungceria;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPlaceAdapter extends RecyclerView.Adapter<ListPlaceAdapter.ListViewHolder> {
    private ArrayList<Place> listPlace;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListPlaceAdapter(ArrayList<Place> list){
        this.listPlace = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_place, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, int i) {
        Place place = listPlace.get(i);

        Glide.with(listViewHolder.itemView.getContext())
                .load(place.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(listViewHolder.imgPhoto);
        listViewHolder.tvName.setText(place.getName());
        listViewHolder.tvSummary.setText(place.getSummary());

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onItemClickCallback.onItemClicked(listPlace.get(listViewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPlace.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvSummary;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvSummary = itemView.findViewById(R.id.tv_item_summary);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Place data);
    }

}
