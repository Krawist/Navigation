package com.example.listandviewmodel.models;

import com.google.gson.annotations.SerializedName;

public class Album {
    private String albumUserId;
    private String albumId;
    private String albumTitle;

    public Album(String albumUserId, String albumId, String albumTitle) {
        this.albumUserId = albumUserId;
        this.albumId = albumId;
        this.albumTitle = albumTitle;
    }

    public String getAlbumUserId() {
        return albumUserId;
    }

    public void setAlbumUserId(String albumUserId) {
        this.albumUserId = albumUserId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
}
