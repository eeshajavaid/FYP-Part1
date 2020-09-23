package com.example.finalfyp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalfyp.ModelNotification;
import com.example.finalfyp.NotificationAdapter;
import com.example.finalfyp.R;

import java.util.ArrayList;

public class TabThree extends Fragment  {


        RecyclerView recyclerView;
        ArrayList<ModelNotification> modelNotificationArrayListList = new ArrayList<>();
        NotificationAdapter notificationAdapter;




        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);

                View view = inflater.inflate(R.layout.tab_three, container, false);

                recyclerView=view.findViewById(R.id.notification_list);

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                recyclerView.setAdapter(new NotificationAdapter(getContext(),intImageBitmaps()));

            //  RecyclerView notificationList = (RecyclerView) getActivity().findViewById(R.id.notification_list);


                notificationAdapter = new NotificationAdapter(getContext(), modelNotificationArrayListList);
                
                return view;

        }



        private ArrayList<ModelNotification> intImageBitmaps() {

                ModelNotification modelNotification = new ModelNotification("John Smith", "https://i.redd.it/obx4zydshg601.jpg","liked your post","2 hours ago" );
                modelNotificationArrayListList.add(modelNotification);

                modelNotification = new ModelNotification("Emma Stone", "https://i.redd.it/glin0nwndo501.jpg","liked your post","4 hours ago" );
                modelNotificationArrayListList.add(modelNotification);

                modelNotification = new ModelNotification("Jay Rod", "https://i.picsum.photos/id/1000/5626/3635.jpg?hmac=qWh065Fr_M8Oa3sNsdDL8ngWXv2Jb-EE49ZIn6c0P-g","commented on your post","5 hours ago" );
                modelNotificationArrayListList.add(modelNotification);

                modelNotification = new ModelNotification("Salman Khan", "https://i.picsum.photos/id/1002/4312/2868.jpg?hmac=5LlLE-NY9oMnmIQp7ms6IfdvSUQOzP_O3DPMWmyNxwo","liked your post","8 hours ago" );
                modelNotificationArrayListList.add(modelNotification);


                return modelNotificationArrayListList;


        }

       /* private void initRecyclerView() {
                RecyclerView recyclerView = getActivity().findViewById(R.id.notification_list);
                NotificationAdapter adapter = new NotificationAdapter(myContext,modelNotificationArrayListList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(myContext));
        }*/




}
