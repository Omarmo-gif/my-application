package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    private Context context;
    private List<FavItem> favItemList;
    private FavDB favDB;

    public FavAdapter(Context context, List<FavItem> favItemList) {
        this.context = context;
        this.favItemList = favItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item,
                parent, false);
        favDB = new FavDB(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.favTextView_title.setText(favItemList.get(position).getTitle());
        holder.favImageViewframe.setImageResource(favItemList.get(position).getFrame());
        holder.favTextView_author.setText(favItemList.get(position).getAuthor());
        holder.favImageViewbook.setImageResource(favItemList.get(position).getBookimage());
        holder.favTextView_pagrevi.setText(favItemList.get(position).getPagesandreviews());
        holder.ratebar.setRating(favItemList.get(position).getRate());
    }

    @Override
    public int getItemCount() {
        return favItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView favTextView_title,favTextView_author,favTextView_pagrevi;
        Button favBtn;
        ImageView favImageViewframe,favImageViewbook;
        RatingBar ratebar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favTextView_title = itemView.findViewById(R.id.fav_item_title);
            favBtn = itemView.findViewById(R.id.favBtn);
            favImageViewframe = itemView.findViewById(R.id.fav_frame);
            favTextView_author = itemView.findViewById(R.id.fav_item_author);
            favImageViewbook = itemView.findViewById(R.id.fav_item_bookimage);
            favTextView_pagrevi = itemView.findViewById(R.id.fav_item_pages_rev);
            ratebar=itemView.findViewById(R.id.fav_item_ratingBar);
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    FavItem favItem = favItemList.get(position);
                    favDB.remove_fav(favItem.getKey_id());
                    favBtn.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);
                    notifyItemRemoved(position);


                    favItemList.remove(position);
                    notifyItemRangeChanged(position,favItemList.size());





                }
            });
        }
    }

    private void removeItem(int position) {
        favItemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,favItemList.size());
    }
}




