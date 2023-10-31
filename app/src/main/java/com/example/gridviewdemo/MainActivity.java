package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<GalleryImage> ImageList = new ArrayList<>();
    Toast CurrToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddData();
        GridView gridViewImages = findViewById(R.id.gridViewImages);
        ImageView imgViewLarge = findViewById(R.id.imgViewLarge);
        ImageAdapter myAdapter = new ImageAdapter(ImageList);
        gridViewImages.setAdapter(myAdapter);
        gridViewImages.setNumColumns(3);
        gridViewImages.setVerticalSpacing(8);
        gridViewImages.setHorizontalSpacing(8);

        gridViewImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imgViewLarge.setImageResource(ImageList.get(i).getImgPic());
                if (CurrToast != null){
                    CurrToast.cancel();
                }
                CurrToast = Toast.makeText(MainActivity.this,
                        "click on " + ImageList.get(i).getImgName(),Toast.LENGTH_LONG);
                CurrToast.show();
            }
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
}