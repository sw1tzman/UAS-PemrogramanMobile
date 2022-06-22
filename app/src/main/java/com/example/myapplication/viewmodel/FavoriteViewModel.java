package com.example.myapplication.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.database.Favorite;
import com.example.myapplication.repository.FavoriteRepository;
import java.util.List;

public class FavoriteViewModel extends ViewModel {

    private final FavoriteRepository favoriteRepository;

    public FavoriteViewModel(Application application){
        favoriteRepository = new FavoriteRepository(application);
    }

    public void insert(Favorite favorite){ favoriteRepository.insertFavoriteVideo(favorite); }

    public LiveData<List<Favorite>> getAllFavVideo(){ return favoriteRepository.getFavoriteVideo(); }

    public void delete(String judul){ favoriteRepository.deleteFavoriteVideo(judul); }

    public Integer cekFavVideo(String judul){return favoriteRepository.cekFavoriteVideo(judul);}
}
