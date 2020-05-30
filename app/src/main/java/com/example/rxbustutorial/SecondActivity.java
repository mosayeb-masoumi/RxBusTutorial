package com.example.rxbustutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class SecondActivity extends AppCompatActivity {

    Disposable disposable = new CompositeDisposable();
    MovieList movieList;
    Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        disposable = RxBus.subscribeModel(result -> {

            if (result instanceof MovieList) {
                movieList = (MovieList) result;
            } else if (result instanceof Country) {
                country = (Country) result;
            }

        });
    }

    @Override
    public void onStop() {
        super.onStop();
        disposable.dispose(); //very important to avoid leak memory
    }
}




