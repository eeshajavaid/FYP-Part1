package com.example.finalfyp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import com.example.finalfyp.ModelFriendRequest;
import com.example.finalfyp.FriendRequestAdapter;
import com.example.finalfyp.R;



import java.util.ArrayList;

public class FriendRequestMain extends AppCompatActivity {

    private static final String TAG = "FriendRequestMain";

    RecyclerView recyclerView;
    ArrayList<ModelFriendRequest> modelFriendRequestArrayList = new ArrayList<>();
    FriendRequestAdapter friendRequestAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclermain);

        Log.d(TAG, "onCreate: started.");


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_req);

        FriendRequestAdapter adapter = new FriendRequestAdapter(this,intImageBitmaps());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }

    private ArrayList<ModelFriendRequest> intImageBitmaps() {
        Log.d(TAG, "intImageBitmaps: Preparing bitmaps");

        ModelFriendRequest modelFriendRequest = new ModelFriendRequest("John Smith", "https://i.redd.it/obx4zydshg601.jpg","Accept","Decline");
        modelFriendRequestArrayList.add(modelFriendRequest);

        modelFriendRequest = new ModelFriendRequest("Emma Stone", "https://i.redd.it/glin0nwndo501.jpg","Accept","Decline");
        modelFriendRequestArrayList.add(modelFriendRequest);

        modelFriendRequest = new ModelFriendRequest("Salman Khan", "https://i.picsum.photos/id/1002/4312/2868.jpg?hmac=5LlLE-NY9oMnmIQp7ms6IfdvSUQOzP_O3DPMWmyNxwo","Accept","Decline");
        modelFriendRequestArrayList.add(modelFriendRequest);


        return modelFriendRequestArrayList;
    }

    //set up a method for recycle view
   /*private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        FriendRequestAdapter adapter = new FriendRequestAdapter(this, intImageBitmaps());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }*/




}
