package com.example.finalfyp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class review extends Fragment {
    ImageView image;
    TextView place_name;
    Button button;
    String name;
    LinearLayout linearLayout;
    public review() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        name = getArguments().getString("name");
        final int image_id = getArguments().getInt("image");
        int pid = Start.myAppDb.myDao().getCategoryPid(name);
        List<Questions> questions = new ArrayList<>();
        questions = Start.myAppDb.myDao().getQuestions(pid);
        linearLayout = view.findViewById(R.id.linear);

        for(int i=0; i <questions.size(); i++)
        {
            TextView textView = new TextView(this.getContext());
            textView.setTextSize(16);
            textView.setMaxEms(4);
            textView.setText(questions.get(i).question);
            RatingBar ratingBar = new RatingBar(this.getContext());
            ratingBar.setNumStars(5);
            ratingBar.setMax(5);
            linearLayout.addView(textView);
            linearLayout.addView(ratingBar);
        }

        image = view.findViewById(R.id.placeImage);
        place_name = view.findViewById(R.id.placeName);
        // image.setImageResource(image_id);
        Glide.with(this).load(image_id).into(image);
        place_name.setText(name);

        button = view.findViewById(R.id.rate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = calculateRatings();
                Start.myAppDb.myDao().updateRatings(name,rating);
                int id = Start.myAppDb.myDao().getCategoryPid(name);
                String categoryName = Start.myAppDb.myDao().getCategoryName(id);
                Toast.makeText(getContext(),"You ratings have been received",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),Places.class);
                intent.putExtra("categoryName", categoryName);
                startActivity(intent);
            }
        });

        return view;
    }

    float calculateRatings()
    {
        float ratings = Start.myAppDb.myDao().placeDetails(name).getRatings();
        float current = 0;
        for(int i = 0; i < linearLayout.getChildCount(); i++)
        {
            if( (i%2) != 0)
            {
                RatingBar ratingBar = (RatingBar)linearLayout.getChildAt(i);
                current += ratingBar.getRating();
            }
        }
        current = (current/((linearLayout.getChildCount()/2)*5))*5;
        ratings = (ratings + current)/2;
        return ratings;
    }



}
