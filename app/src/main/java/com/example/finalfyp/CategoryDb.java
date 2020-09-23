package com.example.finalfyp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CategoryDb {
    String categoryName;
    @PrimaryKey
    int categoryId;
    int categoryImage;

    public CategoryDb(String categoryName, int categoryId, int categoryImage) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;

        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }
}
