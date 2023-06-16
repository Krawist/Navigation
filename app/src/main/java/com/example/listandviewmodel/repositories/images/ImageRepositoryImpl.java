package com.example.listandviewmodel.repositories.images;

import com.example.listandviewmodel.listener.OnApiCallListener;
import com.example.listandviewmodel.models.Album;
import com.example.listandviewmodel.models.Image;
import com.example.listandviewmodel.network.ApiClientBuilder;
import com.example.listandviewmodel.network.apis.ImageApis;
import com.example.listandviewmodel.network.models.AlbumNetwork;
import com.example.listandviewmodel.network.models.ImageNetwork;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageRepositoryImpl implements ImageRepository{

    private ImageApis imageApis;

    public ImageRepositoryImpl(){
        imageApis = ApiClientBuilder.getInstance().create(ImageApis.class);
    }

    @Override
    public void getAllAlbums(OnApiCallListener<List<Album>> onApiCallListener) {
        Call<List<AlbumNetwork>> call = imageApis.getAlbums();
        call.enqueue(new Callback<List<AlbumNetwork>>() {
            @Override
            public void onResponse(Call<List<AlbumNetwork>> call, Response<List<AlbumNetwork>> response) {
                onApiCallListener.onSuccess(response.body().stream().map(albumNetwork -> albumNetwork.toDomainModel()).collect(Collectors.toList()));
            }

            @Override
            public void onFailure(Call<List<AlbumNetwork>> call, Throwable t) {
                onApiCallListener.onFailed();
            }
        });
    }

    @Override
    public void getImageOfAlbum(String albumId, OnApiCallListener<List<Image>> onApiCallListener) {
        Call<List<ImageNetwork>> call = imageApis.getImageOfAlbum(albumId);
        call.enqueue(new Callback<List<ImageNetwork>>() {
            @Override
            public void onResponse(Call<List<ImageNetwork>> call, Response<List<ImageNetwork>> response) {
                onApiCallListener.onSuccess(response.body().stream().map(imageNetwork -> imageNetwork.toDomainModel()).collect(Collectors.toList()));
            }

            @Override
            public void onFailure(Call<List<ImageNetwork>> call, Throwable t) {
                onApiCallListener.onFailed();
            }
        });
    }
}
