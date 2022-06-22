package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface FavoriteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFav(Favorite favorite);

    @Query("SELECT * FROM favorite")
    LiveData<List<Favorite>> getFavoriteVideo();

    @Query("DELETE FROM favorite WHERE favorite.judulVideo = :judulVideo")
    void deleteFav(String judulVideo);

    @Query("SELECT count(*) FROM favorite WHERE favorite.judulVideo = :judul")
    Integer cekFavoriteVideo(String judul);
}
