package com.rmldemo.guardsquare.model;

import com.google.gson.annotations.SerializedName;

public class NewsArticle {
    @SerializedName("title")
    private String title;

    @SerializedName("author")
    private String author;

    // Tambahkan field lain sesuai kebutuhan

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
