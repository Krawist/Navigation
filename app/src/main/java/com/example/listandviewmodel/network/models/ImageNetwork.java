package com.example.listandviewmodel.network.models;

import com.example.listandviewmodel.models.Image;
import com.google.gson.annotations.SerializedName;

public class ImageNetwork {

    @SerializedName("albumId")
    private String albumId;

    @SerializedName("id")
    private String imageId;

    @SerializedName("title")
    private String imageLabel;

    @SerializedName("url")
    private String imageUrl;

    public ImageNetwork(String albumId, String imageId, String imageLabel, String imageUrl) {
        this.albumId = albumId;
        this.imageId = imageId;
        this.imageLabel = imageLabel;
        this.imageUrl = imageUrl;
    }

    public Image toDomainModel(){
        return new Image(albumId,imageId,imageLabel,imageUrl);
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
