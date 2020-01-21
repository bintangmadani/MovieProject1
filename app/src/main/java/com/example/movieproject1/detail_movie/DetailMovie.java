package com.example.movieproject1.detail_movie;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movieproject1.R;
import com.example.movieproject1.list_movie.ListMovie;
import com.example.movieproject1.list_movie.MovieModel;

public class DetailMovie extends AppCompatActivity {
    private TextView tvtitle, tvoverview;
    private ImageView imageposter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        tvtitle = findViewById(R.id.tvTitle);
        tvoverview = findViewById(R.id.tv_text_overview);
        imageposter = findViewById(R.id.image_poster);
        MovieModel movieModel = getIntent().getParcelableExtra(ListMovie.SELECTED_PROJECT);
        tvtitle.setText(movieModel.getTitle());
        tvoverview.setText(movieModel.getOverview());
        imageposter.setImageResource(movieModel.getPoster());
        setTitle(movieModel.getTitle());


    }
}
