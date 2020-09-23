package com.example.finalfyp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalfyp.ui.main.SectionsPagerAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    public static DrawerLayout drawerLayout;
    NavigationView navigationView;
    CircleImageView profilePic;
    TextView profileName;
    String email, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = getIntent().getStringExtra("email");
        name = Start.myAppDb.myDao().getUserName(email);
        String path = (Start.myAppDb.myDao().getUserImage(email));

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        View headerView = navigationView.getHeaderView(0);
        profileName = headerView.findViewById(R.id.profileName);
        profileName.setText(name);
        profilePic = headerView.findViewById(R.id.profileImg);
        profilePic.setImageDrawable(Drawable.createFromPath(path));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.profile:
                        item.setChecked(true);
                        Intent intent1 = new Intent(MainActivity.this,Profile.class);
                        intent1.putExtra("email", email);
                        startActivity(intent1);
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.friendList:
                        item.setChecked(true);
                        Intent intent2 = new Intent (MainActivity.this, FriendListMain.class);
                        startActivity(intent2);
                        displayMessage("View friend list");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.friendRequests:
                        item.setChecked(true);
                        Intent intent3 = new Intent (MainActivity.this, FriendRequestMain.class);
                        startActivity(intent3);
                        displayMessage("View friend requests");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.changePassword:
                        item.setChecked(true);
                        displayMessage("Change Password");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.help:
                        item.setChecked(true);
                        displayMessage("Help");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.logout:
                        item.setChecked(true);
                        Intent intent = new Intent(MainActivity.this,Login.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        return true;
                }
                return false;
            }
        });
    }
    private void displayMessage(String message)
    {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
    }
}