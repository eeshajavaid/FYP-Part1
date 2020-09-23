package com.example.finalfyp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CategoryDb.class, Place.class, User.class, Questions.class}, version = 1, exportSchema = true )

public abstract class MyAppDb extends RoomDatabase {
    public abstract MyDao myDao();
}
