package com.example.finalfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Places extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    TextView textView;
    // private List<String> places;
    private RecyclerView.LayoutManager layoutManager;
    private float[] ratings;
    private PlaceAdapter adapter;
    private List<Place> places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        String text;
        // if (getIntent().getStringExtra("categoryName") != null)
        text = getIntent().getStringExtra("categoryName");
        textView = findViewById(R.id.name_category);
        textView.setText(text);
        List <Place> places = Start.myAppDb.myDao().getPlaces(Start.myAppDb.myDao().getCategoryId(text));

        RecyclerView recyclerViewPlaces = findViewById(R.id.recyclerViewPlaces);
        layoutManager = new LinearLayoutManager(this);
        //recyclerViewPlaces.setHasFixedSize(true);
        recyclerViewPlaces.setLayoutManager(layoutManager);
        adapter = new PlaceAdapter(places, this);
        recyclerViewPlaces.setAdapter(adapter);

    }

    @Override
    protected void onPostResume() {
        String text = getIntent().getStringExtra("categoryName");
        textView = findViewById(R.id.name_category);
        textView.setText(text);
        List <Place> places = Start.myAppDb.myDao().getPlaces(Start.myAppDb.myDao().getCategoryId(text));
        RecyclerView recyclerViewPlaces = findViewById(R.id.recyclerViewPlaces);
        layoutManager = new LinearLayoutManager(this);
        //recyclerViewPlaces.setHasFixedSize(true);
        recyclerViewPlaces.setLayoutManager(layoutManager);
        adapter = new PlaceAdapter(places, this);
        recyclerViewPlaces.setAdapter(adapter);
        super.onPostResume();
    }
}
