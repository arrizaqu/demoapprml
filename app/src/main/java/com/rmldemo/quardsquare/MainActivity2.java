package com.rmldemo.quardsquare;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rmldemo.quardsquare.api.NewApiClient;
import com.rmldemo.quardsquare.model.NewsArticle;
import com.rmldemo.quardsquare.model.NewsResponse;
import com.rmldemo.quardsquare.services.NewsApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends Activity implements NewsView{

    private NewsPresenter presenter;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter();
        recyclerView.setAdapter(newsAdapter);

        NewsModel newsModel = new NewsModel();
        presenter = new NewsPresenter(this, newsModel);

        presenter.getNews("ID", "Test", "979f40a757fb4ec28b2f5841d33fe645");
        //getDataApi();
    }

//        public void getDataApi(){
//        // Ganti dengan kunci API NewsAPI.org Anda
//        String apiKey = "979f40a757fb4ec28b2f5841d33fe645";
//        NewsApiService apiService = NewApiClient.getClient();
//        Call<NewsResponse> call = apiService.getTopHeadlines("us", "general", apiKey);
//        call.enqueue(new Callback<NewsResponse>() {
//            @Override
//            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
//                if (response.isSuccessful()) {
//                    NewsResponse newsResponse = response.body();
//                    if (newsResponse != null) {
//                        for (NewsArticle article : newsResponse.getArticles()) {
//                            Log.d("News", "Title: " + article.getTitle() + ", Author: " + article.getAuthor());
//                            // Tambahkan tindakan lain sesuai kebutuhan
//                        }
//                    }
//                } else {
//                    Log.e("News", "Failed to fetch news. Error: " + response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NewsResponse> call, Throwable t) {
//                Log.e("News", "Error: " + t.getMessage());
//            }
//        });
//    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setNews(List<NewsArticle> articles) {
        this.newsAdapter.setNewsList(articles);
    }

    @Override
    public void showError(String message) {

    }
}

