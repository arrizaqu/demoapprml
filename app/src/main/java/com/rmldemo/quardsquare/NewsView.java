package com.rmldemo.quardsquare;

import com.rmldemo.quardsquare.model.NewsArticle;

import java.util.List;

public interface NewsView {
    void showProgress();
    void hideProgress();
    void setNews(List<NewsArticle> articles);
    void showError(String message);
}
