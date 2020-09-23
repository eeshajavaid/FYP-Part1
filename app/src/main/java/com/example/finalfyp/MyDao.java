package com.example.finalfyp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void addPlace(Place place);

    @Insert
    void addCategory(CategoryDb category);

    @Query("select * from CategoryDb")
    List<CategoryDb> getcategories();

    @Transaction
    @Query("select * from Place WHERE categoryPid like :category order by ratings desc")
    List<Place> getPlaces(int category);

    @Query("select categoryId from CategoryDb where categoryName like :category")
    int getCategoryId(String category);

    @Query("select * from Place where placeName like :placeName")
    Place placeDetails(String placeName);

    @Insert
    void addUser(User user);

    @Query("select email from User where email like :email")
    String getUserEmail(String email);

    @Query("select password from User where password like :pass")
    String getUserPass(String pass);

    @Query("select username from User where email like :email")
    String getUserName(String email);

    @Query("select profileuri from User where email like :email")
    String getUserImage(String email);

    @Query("select latitude from Place where placeName like :name")
    double getPlaceLatitude(String name);

    @Query("select longitude from Place where placeName like :name")
    double getPlaceLongitude(String name);

    @Insert
    void addQuestions(Questions question);

    @Query("select categoryPid from Place where placeName like :name")
    int getCategoryPid(String name);

    @Transaction
    @Query("select * from Questions where category_pid like :categoryId")
    List<Questions> getQuestions(int categoryId);

    @Query("UPDATE Place SET ratings = :ratings WHERE placeName=:PlaceName")
    void updateRatings(String PlaceName, float ratings);

    @Query("select categoryName from CategoryDb where categoryId like :categoryId")
    String getCategoryName(int categoryId);

}
