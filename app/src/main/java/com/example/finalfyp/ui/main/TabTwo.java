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

import com.example.finalfyp.CategoryDb;
import com.example.finalfyp.R;
import com.example.finalfyp.RecyclerAdapter;
import com.example.finalfyp.Start;

import java.util.List;

public class TabTwo extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_two, container, false);

        List<CategoryDb> categories = Start.myAppDb.myDao().getcategories();

        recyclerView = view.findViewById(R.id.recyclerView);
        //list = Arrays.asList(getResources().getStringArray(R.array.categories));
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(categories, this.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }
}
