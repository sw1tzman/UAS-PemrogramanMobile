package com.example.myapplication.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.database.Favorite;
import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private final ArrayList<Favorite> listFav = new ArrayList<>();

    public FavoriteAdapter() {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView txtJudulVideo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJudulVideo = itemView.findViewById(R.id.txt_judulVideo);
        }
    }

    public void setData(List<Favorite> favorite){
        listFav.clear();
        listFav.addAll(favorite);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Favorite favoriteVideo = listFav.get(position);
        holder.txtJudulVideo.setText(favoriteVideo.getJudulVideo());
        holder.itemView.setOnClickListener(View -> {
            Intent intent = new Intent(holder.itemView.getContext(),VideoActivity.class);
            intent.putExtra("JUDUL_VIDEO", favoriteVideo.getJudulVideo());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listFav.size();
    }
}
