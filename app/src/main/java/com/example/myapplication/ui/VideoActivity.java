package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.myapplication.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        configVideo();
    }

    private void configVideo() {
        String judulVideo = getIntent().getStringExtra("JUDUL_VIDEO");
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
}