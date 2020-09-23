package com.example.finalfyp;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CategoryandQuestions{
    @Embedded
    CategoryDb category;
    @Relation(
            parentColumn = "categoryId",
            entityColumn = "category_pid"
    )
    public List<Questions> questions;
}

