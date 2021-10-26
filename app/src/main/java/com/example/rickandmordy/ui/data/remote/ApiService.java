package com.example.rickandmordy.ui.data.remote;

import com.example.rickandmordy.ui.data.models.LocationDto;
import com.example.rickandmordy.ui.data.models.MainResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/character")
    Call<MainResponse>fetcharakters();


}

