package com.example.finalfyp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceDetailFragment extends Fragment {
    TextView placeName, placeDescription;
    ImageView placeImage, map;
    Button check_in;

    public PlaceDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place_detail, container, false);
        view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        final String text = getArguments().getString("placeName");
        placeName = view.findViewById(R.id.placeName);
        placeImage = view.findViewById(R.id.placeImage);
        check_in = view.findViewById(R.id.check_in);
        map = view.findViewById(R.id.maps);

        placeDescription = view.findViewById(R.id.placeDescription);
        placeName.setText(text);
        final Place place = Start.myAppDb.myDao().placeDetails(text);
        Glide.with(this).load(place.imageId).into(placeImage);
        //placeImage.setImageResource(place.imageId);
        placeDescription.setText(place.getDescription());

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                intent.putExtra("placeName1", text);
                startActivity(intent);
            }
        });

        check_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("placeName",text);
                bundle.putString("description",place.getDescription());
                bundle.putInt("image",place.imageId);
                Check_in check_in_fragment = new Check_in();
                PlaceDetails.fragmentManager.beginTransaction().replace(R.id.PlaceFragment_container, check_in_fragment,null).addToBackStack(null).commit();
                check_in_fragment.setArguments(bundle);

            }
        });

        return view;
    }
}
