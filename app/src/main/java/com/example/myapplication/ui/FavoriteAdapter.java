package com.example.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private final String[]favoriteVideo;

    public FavoriteAdapter(String[] favoriteVideo) {
        this.favoriteVideo = favoriteVideo;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView txtJudulVideo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJudulVideo = itemView.findViewById(R.id.txt_judulVideo);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtJudulVideo.setText(favoriteVideo[position]);
        holder.itemView.setOnClickListener(View -> {
            Intent intent = new Intent(holder.itemView.getContext(),VideoActivity.class);
            intent.putExtra("JUDUL_VIDEO", favoriteVideo[position]);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return favoriteVideo.length;
    }
}
