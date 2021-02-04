package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Description extends AppCompatActivity {
    TextView pagerev,desc;
    TextView author;
    TextView title;
    ImageView frame;
    ImageView bookImage;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        int image1=getIntent().getExtras().getInt("images");
        int frame1=getIntent().getExtras().getInt("frame");
        float rate1= getIntent().getExtras().getFloat("rating");
        String title1=getIntent().getExtras().getString("title");
        String author1=getIntent().getExtras().getString("author");
        String pagrev1=getIntent().getExtras().getString("pagesandreviews");
        String desc1=getIntent().getExtras().getString("description");

        pagerev=findViewById(R.id.desc_pagrev);
        author=findViewById(R.id.desc_author);
        title=findViewById(R.id.desc_title);
        frame=findViewById(R.id.desc_frame);
        bookImage=findViewById(R.id.desc_imagebook);
        desc=findViewById(R.id.dettails_desc);
        ratingBar=findViewById(R.id.ratingBardesc);


        pagerev.setText(pagrev1);
        author.setText(author1);
        title.setText(title1);
        bookImage.setImageResource(image1);
        frame.setImageResource(frame1);
        desc.setText(desc1);
       ratingBar.setRating(rate1);
    }

}
