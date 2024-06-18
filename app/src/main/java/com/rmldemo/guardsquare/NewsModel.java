package com.rmldemo.guardsquare;


import android.util.Log;

import com.rmldemo.guardsquare.api.NewApiClient;
import com.rmldemo.guardsquare.model.NewsArticle;
import com.rmldemo.guardsquare.model.NewsResponse;
import com.rmldemo.guardsquare.services.NewsApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsModel {

    public interface OnFinishedListener {
        void onFinished(List<NewsArticle> articles);
        void onFailure(Throwable t);
    }

    public void getNews(String country, String category, String apiKey, OnFinishedListener listener) {
        NewsApiService apiService = NewApiClient.getClient();
        Call<NewsResponse> call = apiService.getTopHeadlines("us", "general", apiKey);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
//                if (response.isSuccessful()) {
//                    NewsResponse newsResponse = response.body();
//                    if (newsResponse != null) {
//                        for (NewsArticle article : newsResponse.getArticles()) {
//                            Log.d("News", "Title: " + article.getTitle() + ", Author: " + article.getAuthor());
//
//                        }
//                    }
//                } else {
//                    Log.e("News", "Failed to fetch news. Error: " + response.message());
//                }
                if (response.isSuccessful()) {
                        List<NewsArticle> articles = response.body().getArticles();
                        for (NewsArticle article : articles) {
                            Log.d("News", "Title: " + article.getTitle() + ", Author: " + article.getAuthor());
                        }
                    //List<NewsArticle> articles = response.body().getArticles();
                    listener.onFinished(articles);
                } else {
                    listener.onFailure(new Exception("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("News", "Error: " + t.getMessage());
            }
        });
    }
}
