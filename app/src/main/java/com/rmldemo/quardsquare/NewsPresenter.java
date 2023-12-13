package com.rmldemo.quardsquare;

import com.rmldemo.quardsquare.model.NewsArticle;

import java.util.List;

public class NewsPresenter {

    private NewsView view;
    private NewsModel model;

    public NewsPresenter(NewsView view, NewsModel model) {
        this.view = view;
        this.model = model;
    }

    public void getNews(String country, String category, String apiKey) {
        view.showProgress();

        model.getNews(country, category, apiKey, new NewsModel.OnFinishedListener() {
            @Override
            public void onFinished(List<NewsArticle> articles) {
                view.hideProgress();
                view.setNews(articles);
            }

            @Override
            public void onFailure(Throwable t) {
                view.hideProgress();
                view.showError(t.getMessage());
            }
        });
    }
}
