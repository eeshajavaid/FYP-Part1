package com.example.finalfyp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Check_in extends Fragment {
    ImageView image;
    TextView placename, description;
    Button review;


    public Check_in() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_in, container, false);
        final String name = getArguments().getString("placeName");
        final String details = getArguments().getString("description");
        final int image_id = getArguments().getInt("image");

        image = view.findViewById(R.id.placeImage);
        placename = view.findViewById(R.id.placeName);
        description = view.findViewById(R.id.placeDescription);
        image.setImageResource(image_id);
        placename.setText(name);
        description.setText(details);
        review = view.findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putInt("image", image_id);
                review review_fragment = new review();
                PlaceDetails.fragmentManager.beginTransaction().replace(R.id.PlaceFragment_container, review_fragment,null).addToBackStack(null).commit();
                review_fragment.setArguments(bundle);
            }
        });

        return view;
    }
}
