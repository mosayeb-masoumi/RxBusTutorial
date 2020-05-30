package com.example.rxbustutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    Button btnPublishList ,btnPublishObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPublishList = findViewById(R.id.btnPublishList);
        btnPublishObject = findViewById(R.id.btnPublishObject);

        btnPublishList.setOnClickListener(view -> {

            List<Movie> movies = new ArrayList<>();
            movies.add(new Movie("Star wars","George Lucas"));
            movies.add(new Movie("Lord of the rings","Peter Jackson"));

            MovieList movieList = new MovieList();
            movieList.movieList = movies;
            RxBus.publishModel(movieList);

            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        });

        btnPublishObject.setOnClickListener(view -> {

            Country country = new Country("Iran","+98");
            RxBus.publishModel(country);
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        });
    }
}
