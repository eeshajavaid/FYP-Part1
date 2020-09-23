package com.example.finalfyp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.ViewHolder> {
   // private static final String TAG = "RecyclerViewAdapter";

    private static final String TAG = "FriendRequestAdapter";

    private Context mContext;
    ArrayList<ModelFriendRequest> modelFriendRequestArrayList = new ArrayList<>();

    public FriendRequestAdapter(Context Context, ArrayList<ModelFriendRequest> modelFriendRequestArrayList) {
        this.mContext = Context;
        this.modelFriendRequestArrayList = modelFriendRequestArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false) ;
        ViewHolder holder = new ViewHolder(view) ;


        return holder;
    }




    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        final ModelFriendRequest modelFriendRequest = modelFriendRequestArrayList.get(position);

        Glide.with(mContext)
                .asBitmap()
                .load(modelFriendRequest.getmImages())
                .into(holder.image);

        holder.imageName.setText(modelFriendRequest.getmImageNames());


        holder.buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Friend request declined", Toast.LENGTH_SHORT).show();
            }
        });

        holder.buttons1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Friend request accepted", Toast.LENGTH_SHORT).show();

            }
        });



        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + modelFriendRequestArrayList.get(position).getmImageNames());

                Toast.makeText(mContext, modelFriendRequestArrayList.get(position).getmImageNames(), Toast.LENGTH_SHORT).show(); //prints out the name

                Intent intent = new Intent (mContext, FriendRequestGallery.class);
                intent.putExtra("image_url", modelFriendRequestArrayList.get(position).getmImages());
                intent.putExtra("image_name", modelFriendRequestArrayList.get(position).getmImageNames());
                intent.putExtra("button_id", modelFriendRequestArrayList.get(position).getmButtons());
                intent.putExtra("button1_id", modelFriendRequestArrayList.get(position).getmButtons1());


                mContext.startActivity(intent);  //Recycle Adapter file needs the reference of context

                //Now retrieve intents and assign them to widgets in Gallery_Activity

            }
        });
    }



    @Override
    public int getItemCount() {
        return modelFriendRequestArrayList.size();      //tells total items
    }

    public class ViewHolder extends RecyclerView.ViewHolder{ //holds each item in memory

        //Declare all widgets here below
        CircleImageView image;
        TextView imageName;
        ConstraintLayout parentLayout;
        Button buttons;
        Button buttons1;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (CircleImageView) itemView.findViewById(R.id.image);
            imageName = (TextView)itemView.findViewById(R.id.image_name);
            parentLayout = (ConstraintLayout)itemView.findViewById(R.id.parent_layout);
            buttons = (Button)itemView.findViewById(R.id.button_id);
            buttons1 = (Button)itemView.findViewById(R.id.button1_id);


        }
    }
}
