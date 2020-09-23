package com.example.finalfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Start extends AppCompatActivity {
    Button login ;
    Button signup;
    public static MyAppDb myAppDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

       //this.deleteDatabase("database");

        myAppDb = Room.databaseBuilder(getApplicationContext(),MyAppDb.class,"database").allowMainThreadQueries().build();

        setContentView(R.layout.activity_start);

        login = (Button) findViewById(R.id.signIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        signup = (Button) findViewById(R.id.signup_start);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });
        final Place BadshahiMosque = new Place(1,1,"Badshahi Mosque", (float)4.7, "The Badshahi Mosque is a Mughal era mosque in Lahore, capital of the Pakistani province of Punjab, Pakistan. The mosque is located west of Lahore Fort along the outskirts of the Walled City of Lahore, and is widely considered to be one of Lahore's most iconic landmarks.", R.drawable.badshahimosque,31.588131, 74.310724);
        Place Minar = new Place(2,1,"Minar-e-Pakistan", (float)4.6, "Minar-e-Pakistan is a national monument located in Lahore, Pakistan. The tower was built between 1960 and 1968 on the site where the All-India Muslim League passed the Lahore Resolution on 23 March 1940", R.mipmap.minarepakistan, 31.592718, 74.309507);
        Place LahoreFort = new Place(3,1,"Lahore Fort", (float)4.5, "The Lahore Fort is a citadel in the city of Lahore, Punjab, Pakistan. The fortress is located at the northern end of walled city Lahore, and spreads over an area greater than 20 hectares. It contains 21 notable monuments, some of which date to the era of Emperor Akbar.", R.mipmap.lahorefort, 31.588176,74.314968);
        ArrayList<Place> historical = new ArrayList<Place>();
        historical.add(BadshahiMosque);
        historical.add(Minar);
        historical.add(LahoreFort);
        CategoryDb Historical = new CategoryDb("Historical Places",1,R.drawable.history);
        ArrayList<CategoryDb> categories = new ArrayList<>();
        categories.add(Historical);
      /*  myAppDb.myDao().addPlace(Minar);
        myAppDb.myDao().addPlace(BadshahiMosque);
        myAppDb.myDao().addPlace(LahoreFort);
        myAppDb.myDao().addCategory(Historical);
*/

        final Place PC = new Place(4,2,"Pearl Continental", (float)4.7, "Classic rooms with antique-style furnishings feature free Wi-Fi, flat-screens and minifridges; some have sofas and 4-poster beds. Club rooms include access to a lounge offering complimentary breakfast and drinks. Refined suites add separate living areas; 1 has a washer/dryer and a whirlpool tub. Room service is available.", R.drawable.pearlcontinentalhotel, 31.552836,74.338463);
        Place nishat = new Place(5,2,"The Nishat Hotel", (float)4.6, "Chic rooms offer free Wi-Fi and cable TV, plus tea and coffeemaking facilities. Suites add sitting areas or living rooms, and apartments have dining areas and kitchenettes. Room service is available 24/7.", R.drawable.thenishathotel, 31.507191, 74.356080);
        Place luxus = new Place(6,2,"Luxus Grand Hotel", (float)4.5, "The sophisticated rooms offer glass-enclosed bathrooms, and come with free Wi-Fi, flat-screen TVs and safes, as well as minibars, and tea and coffeemaking facilities. Suites add living areas. There's 24-hour room service.", R.drawable.luxusgrandhotel, 31.562212, 74.330280);
        ArrayList<Place> hotels = new ArrayList<Place>();
        hotels.add(PC);
        hotels.add(nishat);
        hotels.add(luxus);
        CategoryDb Hotels = new CategoryDb("Hotels",2,R.drawable.hotels);
        categories.add(Historical);
        categories.add(Hotels);

        Questions q1 = new Questions(1,1,"Cleanliness");
        Questions q2 = new Questions(2,1,"Ambiance");

        Questions q3 = new Questions(3,2,"Cleanliness");
        Questions q4 = new Questions(4,2,"Ambiance");

   /*     myAppDb.myDao().addQuestions(q1);
        myAppDb.myDao().addQuestions(q2);
        myAppDb.myDao().addQuestions(q3);
        myAppDb.myDao().addQuestions(q4);

       myAppDb.myDao().addPlace(PC);
        myAppDb.myDao().addPlace(nishat);
        myAppDb.myDao().addPlace(luxus);
        myAppDb.myDao().addCategory(Hotels);*/
    }
    }

