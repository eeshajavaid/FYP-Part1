package com.example.finalfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewsFeedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelFeed> modelFeedArrayList = new ArrayList<>();
    AdapterFeed adapterFeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_one);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adapterFeed = new AdapterFeed(this, modelFeedArrayList);
        recyclerView.setAdapter(adapterFeed);
        populateRecyclerView();
    }

    public void populateRecyclerView(){

        ModelFeed modelFeed = new ModelFeed(1, 35, R.drawable.ic_propic1, R.drawable.img_post1,
                "Shahrukh Khan", "2hrs", "It's not who I am underneath, but what I do that defines me.");
        modelFeedArrayList.add(modelFeed);

        modelFeed = new ModelFeed(2, 28, R.drawable.ic_propic2, 0,
                "Eesha Javed", "5hrs", "The real crime would be not to finish what we started.");
        modelFeedArrayList.add(modelFeed);

        modelFeed = new ModelFeed(3, 17, R.drawable.ic_propic3, R.drawable.img_post2,
                "Faraz Tauqeer", "8hrs", "With great power, comes great responsibility.");
        modelFeedArrayList.add(modelFeed);


        adapterFeed.notifyDataSetChanged();
    }
}