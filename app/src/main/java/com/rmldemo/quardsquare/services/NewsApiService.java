package com.rmldemo.quardsquare.services;

import com.rmldemo.quardsquare.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {
    @GET("top-headlines")
    Call<NewsResponse> getTopHeadlines(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );
}
