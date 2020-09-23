package com.example.finalfyp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.ViewHolder> {
    private static final String TAG = "FriendListAdapter";

    ArrayList<ModelFriendList> modelFriendListArrayList = new ArrayList<>();
    private Context mContext;

    public FriendListAdapter(Context Context, ArrayList<ModelFriendList> modelFriendListArrayList) {

        this.mContext = Context;
        this.modelFriendListArrayList = modelFriendListArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called");

        final ModelFriendList modelFriendList = modelFriendListArrayList.get(position);

        Glide.with(mContext).asBitmap().
                        load(modelFriendList.getmImages()).
                        into(holder.image);

        holder.imageName.setText(modelFriendList.getmImageNames());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on" + modelFriendListArrayList.get(position).getmImageNames());

                Toast.makeText(mContext,modelFriendListArrayList.get(position).getmImageNames(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent (mContext, FriendListGallery.class);

                intent.putExtra("image_url", modelFriendListArrayList.get(position).getmImages());
                intent.putExtra("image_name", modelFriendListArrayList.get(position).getmImageNames());

                mContext.startActivity(intent);
            }
        });



    }





    @Override
    public int getItemCount() {
        return modelFriendListArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
             super(itemView);
             image = (CircleImageView) itemView.findViewById(R.id.image);
             imageName = (TextView) itemView.findViewById(R.id.image_name);
             parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);

        }
    }
}
