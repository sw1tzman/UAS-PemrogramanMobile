package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.database.Favorite;
import com.example.myapplication.viewmodel.FavoriteViewModel;
import com.example.myapplication.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private FavoriteViewModel favoriteViewModel;
    private RecyclerView rvFavorite;
    private FavoriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        favoriteViewModel = viewModelConfig(FavoriteActivity.this);
        recycleViewConfig();
        getFavVideo();
    }

    private FavoriteViewModel viewModelConfig(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return new ViewModelProvider(activity,factory).get(FavoriteViewModel.class);
    }

    private void recycleViewConfig() {
        rvFavorite = findViewById(R.id.rv_favorite);
        adapter = new FavoriteAdapter();
        rvFavorite.setLayoutManager(new LinearLayoutManager(FavoriteActivity.this));
        rvFavorite.setHasFixedSize(true);
        getFavVideo();
        rvFavorite.setAdapter(adapter);
    }

    private void getFavVideo() {
        favoriteViewModel.getAllFavVideo().observe(this,it -> {
            if(it != null){
                adapter.setData(it);
            }
        });
    }
}