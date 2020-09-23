package com.example.finalfyp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder>{
    //  private float[] ratings;
    //private List<String> places;
    List<Place> places;
    private Context context;

    public PlaceAdapter(List<Place> places, Context context) {
        //this.ratings = ratings;
        //this.places = places;
        this.places = places;
        this.context = context;
    }

    @NonNull
    @Override
    public PlaceAdapter.PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listofplaces,parent,false);
        PlaceHolder placeHolder = new PlaceHolder(view, context,places );
        return placeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        float rating = places.get(position).getRatings();
        rating = Float.parseFloat(numberFormat.format(rating));
        holder.placeRatings.setRating(rating);
        String text = places.get(position).getPlaceName() + " (" + rating+")";
        holder.nameOfPlace.setText(text );

        //holder.getRatings.setText(Float.toString(rating));

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public static class PlaceHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView nameOfPlace, getRatings;
        RatingBar placeRatings;
        Context context;
        //float [] ratings;
        //List<String> places;
        List <Place> places;

        public PlaceHolder(@NonNull View itemView, Context context, List<Place> places) {
            super(itemView);
            nameOfPlace = itemView.findViewById(R.id.nameOfPlace);
            placeRatings = itemView.findViewById(R.id.ratingOfPlace);
            // getRatings = itemView.findViewById(R.id.numstars);
            this.context = context;
            //this.ratings = ratings;
            this.places = places;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, PlaceDetails.class);
            intent.putExtra("ratings", places.get(getAdapterPosition()).getRatings());
            intent.putExtra("placeName", places.get(getAdapterPosition()).getPlaceName());
            //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            context.startActivity(intent);
        }
    }
}
