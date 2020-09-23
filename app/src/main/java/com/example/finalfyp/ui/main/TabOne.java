package com.example.finalfyp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalfyp.AdapterFeed;
import com.example.finalfyp.ModelFeed;
import com.example.finalfyp.R;

import java.util.ArrayList;

public class TabOne extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ModelFeed> modelFeedArrayList = new ArrayList<>();
    AdapterFeed adapterFeed;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_one, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        adapterFeed = new AdapterFeed(getContext(), modelFeedArrayList);
        recyclerView.setAdapter(adapterFeed);
        populateRecyclerView();
        return view;
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
