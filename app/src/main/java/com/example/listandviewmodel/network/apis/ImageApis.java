package com.example.listandviewmodel.network.apis;

import com.example.listandviewmodel.network.models.AlbumNetwork;
import com.example.listandviewmodel.network.models.ImageNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ImageApis {

    @GET("/albums")
    Call<List<AlbumNetwork>> getAlbums();

    @GET("/albums/{albumId}/photos")
    Call<List<ImageNetwork>> getImageOfAlbum(
        @Path("albumId") String albumId
    );

}
