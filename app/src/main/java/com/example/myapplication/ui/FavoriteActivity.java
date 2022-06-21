package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

public class FavoriteActivity extends AppCompatActivity {

    public static final String[] judulVideo = {
            "video1",
            "video2",
            "video3",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        recycleViewConfig();
    }

    private void recycleViewConfig() {
        RecyclerView rvFavorite = findViewById(R.id.rv_favorite);
        FavoriteAdapter adapter = new FavoriteAdapter(judulVideo);
        rvFavorite.setLayoutManager(new LinearLayoutManager(FavoriteActivity.this));
        rvFavorite.setAdapter(adapter);
    }
}