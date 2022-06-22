package com.example.myapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final Application application;

    public ViewModelFactory(Application application){ this.application = application; }

    public static ViewModelFactory getInstance(Application application){
        if(INSTANCE == null){
            synchronized (ViewModelFactory.class){
                INSTANCE = new ViewModelFactory(application);
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel>T create(@NonNull Class<T> modelClass){
        if(modelClass.isAssignableFrom(FavoriteViewModel.class)){
            return (T) new FavoriteViewModel(application);
        }
        throw new IllegalArgumentException("Unknown View Model Class : " + modelClass.getName());
    }
}
