package com.example.myapplication.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Favorite.class}, version = 1, exportSchema = false)
public abstract class FavoriteDatabase extends RoomDatabase {
    public abstract FavoriteDAO favoriteDAO();

    public static volatile FavoriteDatabase INSTANCE;

    public static FavoriteDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (FavoriteDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FavoriteDatabase.class, "favorite_database")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }
}
