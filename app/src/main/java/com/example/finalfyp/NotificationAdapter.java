package com.example.finalfyp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{

    private static final String TAG = "NotificationAdapter";



    ArrayList<ModelNotification> modelNotificationArrayList = new ArrayList<>();

    private Context mContext;



    public NotificationAdapter(Context Context, ArrayList<ModelNotification> modelNotificationArrayList){

        this.mContext = Context;
        this.modelNotificationArrayList = modelNotificationArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_list, parent, false) ;
       ViewHolder holder = new ViewHolder(view) ;

        return holder;

    }



    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        final ModelNotification modelNotification = modelNotificationArrayList.get(position);

        holder.imageName.setText(modelNotification.getmImageNames());
        holder.notification.setText(modelNotification.getmNotification());
        holder.time.setText(modelNotification.getmTime());

        Glide.with(mContext)
                .asBitmap()
                .load(modelNotification.getmImages())
                .into(holder.image);



        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Toast.makeText(mContext, modelNotificationArrayList.get(position).getmImageNames(), Toast.LENGTH_SHORT).show(); //prints out the name

                Intent intent = new Intent (mContext, NotificationGallery.class);


                intent.putExtra("image_url",modelNotificationArrayList.get(position).getmImages());
                intent.putExtra("image_name",modelNotificationArrayList.get(position).getmImageNames());
                intent.putExtra("notification", modelNotificationArrayList.get(position).getmNotification());
                intent.putExtra("time", modelNotificationArrayList.get(position).getmTime());


                mContext.startActivity(intent);  //Recycle Adapter file needs the reference of context

                //Now retrieve intents and assign them to widgets in Gallery_Activity

            }
        });

    }


    @Override
    public int getItemCount() {

        return modelNotificationArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView imageName;
        ConstraintLayout parentLayout;
        TextView notification;
        TextView time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (CircleImageView) itemView.findViewById(R.id.image);
            imageName = (TextView)itemView.findViewById(R.id.image_name);
            parentLayout = (ConstraintLayout)itemView.findViewById(R.id.parent_layout);
            notification = (TextView)itemView.findViewById(R.id.notification);
            time = (TextView)itemView.findViewById(R.id.time);
        }
    }
}
