package com.example.finalfyp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Gallery_Activity extends AppCompatActivity {
    private static final String TAG = "Gallery_Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started");

        getIncomingIntent();
    }

    //Now retrieve intents and assign them to widgets

    private void getIncomingIntent()
    {
        Log.d(TAG, "getIncomingIntent: checking for incoming intent");

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name"))
         {
            Log.d(TAG, "getIncomingIntent: found intent extras");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageUrl, imageName);  //now call the methods
        }


    }

    private void setImage(String imageUrl, String imageName){
        Log.d(TAG, "setImage: setting to image and name to widgets");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image);

            Glide.with(this)
                .asBitmap()
                    .load(imageUrl)
                    .into(image);




    }
}

