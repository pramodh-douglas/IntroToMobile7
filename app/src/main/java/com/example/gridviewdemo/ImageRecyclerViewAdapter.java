package com.example.gridviewdemo;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageRecyclerViewAdapter
        extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageViewHolder> {
    //define data
    List<GalleryImage> AdapterImages;

    //define constructor

    public ImageRecyclerViewAdapter(List<GalleryImage> adapterImages) {
        AdapterImages = adapterImages;
    }

    //implement methods
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.layout_item,parent,false);
        ImageViewHolder holder = new ImageViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imgViewItem
                .setImageResource(AdapterImages.get(position).getImgPic());
        holder.txtViewItem.setText(AdapterImages.get(position).getImgName());
        holder.txtViewItem.setGravity(Gravity.CENTER);
        holder.itemView.setBackgroundColor(Color.parseColor("#FAFAFA"));
    }

    @Override
    public int getItemCount() {
        return AdapterImages.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imgViewItem;
        TextView txtViewItem;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewItem = itemView.findViewById(R.id.imgViewExtItem);
            txtViewItem = itemView.findViewById(R.id.txtViewExtItem);
        }
    }

}
