package com.example.myapplication.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite")
public class Favorite {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "judulVideo")
    private String judulVideo;

    public int getId(){
        return  id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getJudulVideo(){ return judulVideo;}
    public void setJudulVideo(String judulVideo) { this.judulVideo = judulVideo;}

    public Favorite(int id, String judulVideo){
        this.id = id;
        this.judulVideo = judulVideo;
    }
}
