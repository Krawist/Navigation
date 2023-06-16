package com.example.listandviewmodel.ui.image;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.listandviewmodel.listener.OnApiCallListener;
import com.example.listandviewmodel.models.Album;
import com.example.listandviewmodel.models.Image;
import com.example.listandviewmodel.repositories.images.ImageRepository;
import com.example.listandviewmodel.repositories.images.ImageRepositoryImpl;

import java.util.List;

public class ImageViewModel extends ViewModel {

    private ImageRepository imageRepository = new ImageRepositoryImpl();

    public MutableLiveData<List<Album>> albums = new MutableLiveData<>();

    public MutableLiveData<List<Image>> imageOfAlbums = new MutableLiveData<>();

    private OnApiCallListener<List<Image>> imageOnApiCallListener = new OnApiCallListener<List<Image>>(){
        @Override
        public void onSuccess(List<Image> data) {
            imageOfAlbums.setValue(data);
        }
    };

    private OnApiCallListener<List<Album>> albumOnApiCallListener = new OnApiCallListener<List<Album>>(){
        @Override
        public void onSuccess(List<Album> data) {
            albums.setValue(data);
        }
    };

    public ImageViewModel(){
        imageRepository.getAllAlbums(albumOnApiCallListener);
    }

    public void loadImageOfAlbum(Album album){
        imageRepository.getImageOfAlbum(album.getAlbumId(),imageOnApiCallListener);
    }

}
