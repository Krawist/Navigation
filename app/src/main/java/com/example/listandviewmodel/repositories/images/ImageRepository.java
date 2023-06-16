package com.example.listandviewmodel.repositories.images;

import com.example.listandviewmodel.listener.OnApiCallListener;
import com.example.listandviewmodel.models.Album;
import com.example.listandviewmodel.models.Image;

import java.util.List;

public interface ImageRepository {

    void getAllAlbums(OnApiCallListener<List<Album>> onApiCallListener);

    void getImageOfAlbum(String albumId, OnApiCallListener<List<Image>> onApiCallListener);

}
