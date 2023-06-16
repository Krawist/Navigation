package com.example.listandviewmodel.network.models;

import com.example.listandviewmodel.models.Album;
import com.google.gson.annotations.SerializedName;

public class AlbumNetwork {

    @SerializedName("userId")
    private String albumUserId;

    @SerializedName("id")
    private String albumId;

    @SerializedName("title")
    private String albumTitle;

    public AlbumNetwork(String albumUserId, String albumId, String albumTitle) {
        this.albumUserId = albumUserId;
        this.albumId = albumId;
        this.albumTitle = albumTitle;
    }

    public Album toDomainModel(){
        return new Album(albumUserId, albumId, albumTitle);
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
