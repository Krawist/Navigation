package com.example.listandviewmodel.models;

import com.google.gson.annotations.SerializedName;

public class Image {

    private String albumId;
    private String imageId;
    private String imageLabel;
    private String imageUrl;

    public Image(String albumId, String imageId, String imageLabel, String imageUrl) {
        this.albumId = albumId;
        this.imageId = imageId;
        this.imageLabel = imageLabel;
        this.imageUrl = imageUrl;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageLabel() {
        return imageLabel;
    }

    public void setImageLabel(String imageLabel) {
        this.imageLabel = imageLabel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
