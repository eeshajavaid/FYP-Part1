package com.example.finalfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    TextView username;
    ImageView user_image;
    RecyclerView recyclerView;
    ArrayList<ModelFeed> modelFeedArrayList = new ArrayList<>();
    AdapterProfile adapterProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String email = getIntent().getStringExtra("email");
        String name = Start.myAppDb.myDao().getUserName(email);
        String image = (Start.myAppDb.myDao().getUserImage(email));

        user_image = findViewById(R.id.profileImage);
        username = findViewById(R.id.profileName);

        user_image.setImageDrawable(Drawable.createFromPath(image));
        username.setText(name);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adapterProfile = new AdapterProfile(this, modelFeedArrayList);
        recyclerView.setAdapter(adapterProfile);
        populateRecyclerView();
    }

    public void populateRecyclerView(){

        ModelFeed modelFeed = new ModelFeed(1, 35, R.drawable.ic_propic1, R.drawable.img_post1,
                "Shahrukh Khan", "2hrs", "It's not who I am underneath, but what I do that defines me.");
        modelFeedArrayList.add(modelFeed);

        adapterProfile.notifyDataSetChanged();
    }
}