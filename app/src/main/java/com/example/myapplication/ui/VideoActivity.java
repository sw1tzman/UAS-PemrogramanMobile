package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;

import com.example.myapplication.R;
import com.example.myapplication.database.Favorite;
import com.example.myapplication.viewmodel.FavoriteViewModel;
import com.example.myapplication.viewmodel.ViewModelFactory;

public class VideoActivity extends AppCompatActivity {

    FavoriteViewModel favoriteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        favoriteViewModel = viewModelConfig(VideoActivity.this);
        configVideo();
        favToggleButtonConfig();
    }

    private static FavoriteViewModel viewModelConfig(AppCompatActivity activity){
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return new ViewModelProvider(activity,factory).get(FavoriteViewModel.class);
    }

    private void configVideo() {
        String judulVideo = getIntent().getStringExtra("JUDUL_VIDEO");
        TextView txtJudul = findViewById(R.id.txt_DetailJudulVideo);
        txtJudul.setText(judulVideo);
        VideoView videoView = findViewById(R.id.vv_Video);
        if(judulVideo.equals("video1")){
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1));
        }else if(judulVideo.equals("video2")){
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video2));
        }else if(judulVideo.equals("video3")){
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video3));
        }
        videoView.setMediaController(new MediaController(VideoActivity.this));
        videoView.requestFocus();
        videoView.start();
    }

    private void favToggleButtonConfig() {
        ToggleButton btnFav = findViewById(R.id.toggle_Favorite);
        String judulVideo = getIntent().getStringExtra("JUDUL_VIDEO");
        boolean _isChecked = false;
        if(favoriteViewModel.cekFavVideo(judulVideo) != 0){
            _isChecked = true;
        }
        btnFav.setChecked(_isChecked);
        boolean final_isChecked = _isChecked;
        btnFav.setOnClickListener(View -> {
            if(final_isChecked){
                favoriteViewModel.delete(judulVideo);
            }else{
                favoriteViewModel.insert(new Favorite(judulVideo));
            }
        });
    }
}