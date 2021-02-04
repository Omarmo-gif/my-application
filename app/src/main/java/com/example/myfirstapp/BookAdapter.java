package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {





    private ArrayList<BookItem> bookItems;
    private Context context;
    private FavDB favDB;

    public BookAdapter(ArrayList<BookItem> bookItems, Context context) {
        this.bookItems = bookItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        favDB = new FavDB(context);
        //create table on first
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart) {
            createTableOnFirstStart();
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,
                parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, final int position) {
        final BookItem bookItem = bookItems.get(position);

        readCursorData(bookItem, holder);
        holder.imageViewframe.setImageResource(bookItem.getFrame());
        holder.titleTextView.setText(bookItem.getTitle());
        holder.authorTextView.setText(bookItem.getAuthor());
        holder.imageViewbookimage.setImageResource(bookItem.getBookimage());
        holder.pagerevTextView.setText(bookItem.getPagesandreviews());
        holder.ratingBar.setRating(bookItem.getRate());
       // holder.desc.setText(bookItem.getDescription());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Description.class);
                intent.putExtra("images",bookItems.get(position).getBookimage());
                intent.putExtra("frame",bookItems.get(position).getFrame());
                intent.putExtra("title",bookItems.get(position).getTitle());
                intent.putExtra("author",bookItems.get(position).getAuthor());
                intent.putExtra("pagesandreviews",bookItems.get(position).getPagesandreviews());
                intent.putExtra("description",bookItems.get(position).getDescription());
                intent.putExtra("rating",bookItems.get(position).getRate());

                context.startActivity(intent);

            }
        });
    }



    @Override
    public int getItemCount() {
        return bookItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView desc;
        ImageView imageViewframe,imageViewbookimage;
        TextView titleTextView,pagerevTextView,authorTextView;
        Button favBtn;
        RatingBar ratingBar;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewbookimage = itemView.findViewById(R.id.book_item_bookimage);
            titleTextView = itemView.findViewById(R.id.book_item_title);
            favBtn = itemView.findViewById(R.id.favBtn1);
            imageViewframe=itemView.findViewById(R.id.book_frame);
            pagerevTextView=itemView.findViewById(R.id.book_item_pages_rev);
            authorTextView=itemView.findViewById(R.id.book_item_author);
            ratingBar=itemView.findViewById(R.id.book_item_ratingBar);
            mainLayout=itemView.findViewById(R.id.mainLayout);
            desc=itemView.findViewById(R.id.dettails_desc);
            //add to fav btn
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    BookItem bookItem = bookItems.get(position);
                    if(bookItem.getFavStatus().equals("0")){
                        bookItem.setFavStatus("1");
                        favDB.insertIntoTheDatabase(bookItem.getTitle(),bookItem.getBookimage(),bookItem.getKey_id(),bookItem.getFavStatus(),bookItem.getAuthor(),bookItem.getFrame(),bookItem.getPagesandreviews(),bookItem.getRate());
                        favBtn.setBackgroundResource(R.drawable.ic_favorite_red_24dp);


                    }
                    else{
                        bookItem.setFavStatus("0");
                        favDB.remove_fav(bookItem.getKey_id());
                        favBtn.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);




                    }

                }
            });
        }
    }

    private void createTableOnFirstStart() {
        favDB.insertEmpty();

        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    private void readCursorData(BookItem coffeeItem, ViewHolder viewHolder) {
        Cursor cursor = favDB.read_all_data(coffeeItem.getKey_id());
        SQLiteDatabase db = favDB.getReadableDatabase();
        try {
            while (cursor.moveToNext()) {
                String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVORITE_STATUS));
                coffeeItem.setFavStatus(item_fav_status);

                //check fav status
                if (item_fav_status != null && item_fav_status.equals("1")) {
                    viewHolder.favBtn.setBackgroundResource(R.drawable.ic_favorite_red_24dp);
                } else if (item_fav_status != null && item_fav_status.equals("0")) {
                    viewHolder.favBtn.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);
                }
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }











    }
    public void filterList(ArrayList<BookItem> filteredList){
        bookItems=filteredList;
        notifyDataSetChanged();

    }
}
