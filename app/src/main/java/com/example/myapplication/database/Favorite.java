package com.example.myapplication.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite")
public class Favorite {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "judulVideo")
    private String judulVideo;

    public String getJudulVideo(){ return judulVideo;}
    public void setJudulVideo(String judulVideo) { this.judulVideo = judulVideo;}

    public Favorite(String judulVideo){
        this.judulVideo = judulVideo;
    }
}
