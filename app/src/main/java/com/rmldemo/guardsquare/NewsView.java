package com.rmldemo.guardsquare;

import com.rmldemo.guardsquare.model.NewsArticle;

import java.util.List;

public interface NewsView {
    void showProgress();
    void hideProgress();
    void setNews(List<NewsArticle> articles);
    void showError(String message);
}
