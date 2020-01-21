package com.example.movieproject1.list_movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproject1.R;
import com.example.movieproject1.detail_movie.DetailMovie;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListMovieAdapter madapter;

    private ArrayList<MovieModel> modelMovie = new ArrayList<>();
    public static final String SELECTED_PROJECT = "selected_project";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        findViews();
        setAdapter();
    }

    private void findViews() {
        recyclerView  = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void setAdapter() {
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_joker), getString(R.string.overview_joker), R.drawable.poster_joker));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_zombieland), getString(R.string.overview_zombieland), R.drawable.poster_zombieland));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_doctor), getString(R.string.overview_doctor), R.drawable.poster_doctor));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_spiderman), getString(R.string.overview_spiderman), R.drawable.poster_spiderman));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_fast), getString(R.string.overview_fast), R.drawable.poster_fast));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_frozen), getString(R.string.overview_frozen), R.drawable.frozen));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_good), getString(R.string.overview_good), R.drawable.good));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_it), getString(R.string.overview_it), R.drawable.it));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_jumanji), getString(R.string.overview_jumanji), R.drawable.jumanji));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_aladdin), getString(R.string.overview_aladdin), R.drawable.poster_aladdin));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_lion), getString(R.string.overview_lion), R.drawable.poster_thelion));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_gemini), getString(R.string.overview_gemini), R.drawable.gemini));
        modelMovie.add(new MovieModel(getResources().getString(R.string.title_john), getString(R.string.overview_john), R.drawable.john));


        madapter = new ListMovieAdapter(ListMovie.this, modelMovie);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(madapter);

        madapter.SetOnItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position, MovieModel model) {
                Intent goToDetailMovie = new Intent(ListMovie.this, DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_PROJECT,model);
                startActivity(goToDetailMovie);
            }
        });
        
    }
}
