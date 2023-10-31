package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements ImageRecyclerViewAdapter.OnItemClickListener {
    List<GalleryImage> ImageList = new ArrayList<>();

    ImageView imgViewLarge2;

    int selectedInd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        AddData();

        // set stored preferences
        SharedPreferences preferences = this.getPreferences(Context.MODE_PRIVATE);
        // set selected index from the preferences
        selectedInd = preferences.getInt(getString(R.string.txtImgInd), -1);

        RecyclerView recyclerViewImages = findViewById(R.id.recyclerViewImages);
        imgViewLarge2 = findViewById(R.id.imgViewLarge2);

        if(selectedInd != -1) {
            imgViewLarge2.setImageResource(ImageList.get(selectedInd).getImgPic());
        } else {
            imgViewLarge2.setImageResource(0);
        }

        // ImageRecyclerViewAdapter myAdapter
        //        = new ImageRecyclerViewAdapter(ImageList);

        /*ImageRecyclerViewAdapter myAdapter = new ImageRecyclerViewAdapter(ImageList, new ImageRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                Log.d("MINE", "i " + ImageList.get(i).getImgPic());
                if(i != 1)
                    imgViewLarge2.setImageResource(ImageList.get(i).getImgPic());
            }
        });*/

        ImageRecyclerViewAdapter myAdapter = new ImageRecyclerViewAdapter(ImageList, this);

        // linear layout manager
        // LinearLayoutManager lm = new LinearLayoutManager(this);

        GridLayoutManager gm = new GridLayoutManager(this,2);
        recyclerViewImages.setAdapter(myAdapter);
        recyclerViewImages.setLayoutManager(gm);

        Button btnShowImage = findViewById(R.id.btnShowImage);
        btnShowImage.setOnClickListener((View view) -> {
            int selId = myAdapter.getSelectedInd();
            if (selId != -1)
                imgViewLarge2.setImageResource(ImageList.get(selId).getImgPic());
            else
                imgViewLarge2.setImageResource(0);

        });

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

    @Override
    public void onItemClick(int i) {
        if(i != -1) {
            selectedInd = i;
            imgViewLarge2.setImageResource(ImageList.get(i).getImgPic());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        // add data using following method
        editor.putInt(getString(R.string.txtImgInd), selectedInd);
        editor.apply();
    }
}