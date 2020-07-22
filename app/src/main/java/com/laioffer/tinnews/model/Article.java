package com.laioffer.tinnews.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Article {
    @Ignore
    public Source source; // (need converter https://developer.android.com/training/data-storage/room/referencing-data#java)
    public String author;
    public String content;
    public String description;
    public String publishedAt;
    public String title;

    @NonNull
    @PrimaryKey
    public String url;
    public String urlToImage;
    public boolean favorite;
}
