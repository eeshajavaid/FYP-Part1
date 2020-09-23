package com.example.finalfyp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalfyp.ModelFriendList;
import com.example.finalfyp.FriendListAdapter;
import com.example.finalfyp.R;

import java.util.ArrayList;

public class FriendListMain extends AppCompatActivity {
    private static final String TAG = "FriendListMain";

    RecyclerView recyclerView;
    ArrayList<ModelFriendList> modelFriendListArrayList = new ArrayList<>();
    FriendListAdapter friendListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_main);

        Log.d(TAG, "onCreate: started.");

       // intImageBitmaps();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        FriendListAdapter adapter = new FriendListAdapter(this,intImageBitmaps());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));







    }


    private ArrayList<ModelFriendList> intImageBitmaps() {
        Log.d(TAG, "intImageBitmaps: Preparing bitmaps");

        ModelFriendList modelFriendList = new ModelFriendList("John Smith", "https://i.redd.it/obx4zydshg601.jpg");
        modelFriendListArrayList.add(modelFriendList);

        modelFriendList = new ModelFriendList("Emma Stone", "https://i.redd.it/glin0nwndo501.jpg" );
        modelFriendListArrayList.add(modelFriendList);

        modelFriendList = new ModelFriendList("Jay Rod", "https://i.picsum.photos/id/1000/5626/3635.jpg?hmac=qWh065Fr_M8Oa3sNsdDL8ngWXv2Jb-EE49ZIn6c0P-g");
        modelFriendListArrayList.add(modelFriendList);

        modelFriendList = new ModelFriendList("Salman Khan", "https://i.picsum.photos/id/1002/4312/2868.jpg?hmac=5LlLE-NY9oMnmIQp7ms6IfdvSUQOzP_O3DPMWmyNxwo");
        modelFriendListArrayList.add(modelFriendList);

        return modelFriendListArrayList;
    }
  /* private void initRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        FriendListAdapter adapter = new FriendListAdapter (this, modelFriendListArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }*/
}
