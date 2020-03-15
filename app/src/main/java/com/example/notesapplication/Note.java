package com.example.notesapplication;

public class Note {
    private String title;
    private String content;
    private boolean isFavorite;

    public Note(String title, String content, boolean isFavorite) {
        this.title = title;
        this.content = content;
        this.isFavorite = isFavorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
