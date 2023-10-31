package com.example.gridviewdemo;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    List<GalleryImage> adapterGalleryImages;

    public ImageAdapter(List<GalleryImage> adapterGalleryImages) {
        this.adapterGalleryImages = adapterGalleryImages;
    }

    @Override
    public int getCount() {
        return adapterGalleryImages.size();
    }

    @Override
    public Object getItem(int i) {
        return adapterGalleryImages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return adapterGalleryImages.get(i).getImgId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //inflate external layout if view is null
        //ImageView imgViewItem;
        if (view == null) {
            ImageView imgViewItem = new ImageView(viewGroup.getContext());
            imgViewItem.setLayoutParams(
                    new ViewGroup.LayoutParams(GridView.AUTO_FIT,120));
            imgViewItem.setImageResource(adapterGalleryImages.get(i).getImgPic());
            imgViewItem.setBackgroundColor(Color.LTGRAY);
            view = imgViewItem;
        }
        //populate data based on i - this has already been done

        //return view
        return view;
    }
}
