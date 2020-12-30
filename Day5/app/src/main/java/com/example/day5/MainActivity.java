package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Movie> movieArrayList = new ArrayList<>();

        Movie a = new Movie("toy story", 4.0, genre.action, R.drawable.toystory);
        Movie b = new Movie("toy story2", 3, genre.comedy,R.drawable.toystory2);
        Movie c = new Movie("toy story3", 2.5, genre.horror,R.drawable.toystory3);

        movieArrayList.add(a);
        movieArrayList.add(b);
        movieArrayList.add(c);

        RecyclerView movieList = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        movieList.setHasFixedSize(true);
        movieList.setLayoutManager(lm);

        MovieAdopter ma = new MovieAdopter(movieArrayList,MainActivity.this);
        movieList.setAdapter(ma);




    }
}