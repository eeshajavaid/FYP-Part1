package com.example.finalfyp;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CategoryandPlace {
    @Embedded
    CategoryDb category;
    @Relation(
            parentColumn = "categoryId",
            entityColumn = "categoryPid"
    )
    public List<Place> places;
}
