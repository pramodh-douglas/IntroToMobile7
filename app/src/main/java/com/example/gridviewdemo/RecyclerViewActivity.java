package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    List<GalleryImage> ImageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        AddData();

        RecyclerView recyclerViewImages = findViewById(R.id.recyclerViewImages);
        ImageView imgViewLarge2 = findViewById(R.id.imgViewLarge2);

        ImageRecyclerViewAdapter myAdapter
                = new ImageRecyclerViewAdapter(ImageList);

        GridLayoutManager gm = new GridLayoutManager(this,2);
        recyclerViewImages.setAdapter(myAdapter);
        recyclerViewImages.setLayoutManager(gm);

    }
    private void AddData(){
        ImageList.add(
                new GalleryImage(101,"Eagle",R.drawable.eagle));
        ImageList.add(
                new GalleryImage(102,"Elephant",R.drawable.elephant));
        ImageList.add(
                new GalleryImage(103,"Gorilla",R.drawable.gorilla));
        ImageList.add(
                new GalleryImage(104,"Panda",R.drawable.panda));
        ImageList.add(
                new GalleryImage(105,"Panther",R.drawable.panther));
        ImageList.add(
                new GalleryImage(106,"Polar Bear",R.drawable.polar));

    }
}