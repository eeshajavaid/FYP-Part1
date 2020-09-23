package com.example.finalfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class PlaceDetails extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    String placeName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        fragmentManager = this.getSupportFragmentManager();

        if(findViewById(R.id.PlaceFragment_container )!= null)
        {
            if(savedInstanceState!= null)
                return;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PlaceDetailFragment placeDetailFragment = new PlaceDetailFragment();
            fragmentTransaction.add(R.id.PlaceFragment_container, placeDetailFragment,null).addToBackStack(null);
            fragmentTransaction.commit();
            Bundle bundle = new Bundle();
            placeName = getIntent().getStringExtra("placeName");
            bundle.putString("placeName",placeName);
            placeDetailFragment.setArguments(bundle);

        }

    }
    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 1) {
            // getSupportFragmentManager().popBackStack();
            Intent intent = new Intent(this, Places.class);
            startActivity(intent);
        }
        else {
            super.onBackPressed();
        }
    }
    }

