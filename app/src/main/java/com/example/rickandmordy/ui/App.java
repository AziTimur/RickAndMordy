package com.example.rickandmordy.ui;

import android.app.Application;

import com.example.rickandmordy.ui.data.remote.ApiService;
import com.example.rickandmordy.ui.data.remote.RetrofitClient;

public class App extends Application {
    public static ApiService service;

    @Override
    public void onCreate() {
        super.onCreate();
        service = new RetrofitClient().provideApiService();

    }
}

