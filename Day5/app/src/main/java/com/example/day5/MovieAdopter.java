package com.example.day5;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

class MovieAdopter extends RecyclerView.Adapter {
     ArrayList<Movie> mArray;
     Context context;


    public MovieAdopter(ArrayList<Movie> mArray, Context context) {
        this.mArray = mArray;
        this.context = context;
    }

    @NonNull
     @Override
     public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // added a constractor linking to xml from the perent
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,parent,false);
        //connecting to the list
        ViewHolder viewHolder = new ViewHolder(view);
         return viewHolder;
     }

     @Override
     public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // linking to the data
         ((ViewHolder) holder).rate.setText(mArray.get(position).getRate()+"");
         ((ViewHolder) holder).name.setText(mArray.get(position).getName()+"");
         ((ViewHolder) holder).typ.setText(mArray.get(position).getG()+"");
         ((ViewHolder) holder).ratingBar.setRating((float) mArray.get(position).getRate());
         ((ViewHolder) holder).img.setImageResource(mArray.get(position).getImg());
         ((ViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });
         ((ViewHolder) holder).view.setOnClickListener(view -> {
             Intent  intent =  new Intent(context, detailed.class);
             intent.putExtra("movie",  mArray.get(position));
             context.startActivity(intent); });



     }

     @Override
     public int getItemCount() {
         return mArray.size();
     }

     public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        public TextView rate;
        public TextView typ;
        public RatingBar ratingBar;
        public ImageView delete;
        public View view;
         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             view = itemView;
             img = itemView.findViewById(R.id.imageView);
             name = itemView.findViewById(R.id.movieName);
             rate = itemView.findViewById(R.id.rating);
             typ = itemView.findViewById(R.id.type);
             ratingBar = itemView.findViewById(R.id.ratingBar);

         }
     }
 }
