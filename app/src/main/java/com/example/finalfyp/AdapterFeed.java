package com.example.finalfyp;

//import android.support.v7.widget.Rec

import android.content.Context;
import android.icu.text.Normalizer2;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterFeed extends RecyclerView.Adapter<AdapterFeed.MyViewHolder> {

    Context context;
    ArrayList<ModelFeed> modelFeedArrayList = new ArrayList<>();
    RequestManager glide;

    public AdapterFeed(Context context, ArrayList<ModelFeed> modelFeedArrayList) {

        this.context = context;
        this.modelFeedArrayList = modelFeedArrayList;
        glide = Glide.with(context);

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_feed, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {


        final ModelFeed modelFeed = modelFeedArrayList.get(position);

        holder.tv_name.setText(modelFeed.getName());
        holder.tv_time.setText(modelFeed.getTime());
        String text = String.valueOf(modelFeed.getLikes());
        holder.tv_likes.setText(text);
        holder.tv_status.setText(modelFeed.getStatus());

        glide.load(modelFeed.getPropic()).into(holder.imgView_proPic);

        if(modelFeed.getPostpic() == 0){
            holder.imgView_postPic.setVisibility(View.GONE);
        } else {
            holder.imgView_postPic.setVisibility(View.VISIBLE);
            glide.load(modelFeed.getPostpic()).into(holder.imgView_postPic);
        }



        holder.likeButtonIcon.setOnClickListener(new View.OnClickListener() {

            Boolean likeCheck = false;
            @Override
            public void onClick(View view) {

                TextView tv = (TextView) view.findViewById(R.id.tv_like);
                String text = holder.tv_likes.getText().toString();
                int no_of_Likes = Integer.parseInt(text);

                if(!likeCheck) {
                    no_of_Likes++;
                    likeCheck = true;
                }
                else {
                    no_of_Likes--;
                    likeCheck = false;
                }

                text= String.valueOf(no_of_Likes);
                holder.tv_likes.setText(text);
            }
        });


        holder.reportButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast toast = Toast.makeText(context.getApplicationContext(), "You have reported this post.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return modelFeedArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_time, tv_likes, tv_status;
        ImageView imgView_proPic, imgView_postPic, likeButtonIcon, reportButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView_proPic = (ImageView)itemView.findViewById(R.id.imgView_proPic);
            imgView_postPic = (ImageView)itemView.findViewById(R.id.imgView_postPic);
            likeButtonIcon = (ImageView)itemView.findViewById(R.id.likeButton);
            reportButton = (ImageView) itemView.findViewById(R.id.reportButton);

            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_likes = (TextView) itemView.findViewById(R.id.tv_like);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);


        }
    }

}
