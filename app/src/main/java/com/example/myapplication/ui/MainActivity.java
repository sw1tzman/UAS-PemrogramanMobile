package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    public static final String[] judulVideo = {
            "video1",
            "video2",
            "video3",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleViewConfig();
        moveToFavoriteActivity();
    }

    private void recycleViewConfig() {
        RecyclerView rvListVideo = findViewById(R.id.rv_listVideo);
        MainActivityAdapter adapter = new MainActivityAdapter(judulVideo);
        rvListVideo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvListVideo.setAdapter(adapter);
    }

    private void moveToFavoriteActivity(){
        Button btnFavorite = findViewById(R.id.btn_favorite);
        btnFavorite.setOnClickListener(View -> {
            Intent intent = new Intent(this, FavoriteActivity.class);
            startActivity(intent);
        });
    }
}