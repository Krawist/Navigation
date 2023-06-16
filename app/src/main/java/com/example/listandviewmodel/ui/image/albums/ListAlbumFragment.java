package com.example.listandviewmodel.ui.image.albums;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.listandviewmodel.R;
import com.example.listandviewmodel.adapter.AlbumAdapter;
import com.example.listandviewmodel.databinding.ListLayoutBinding;
import com.example.listandviewmodel.listener.ToDoOnActions;
import com.example.listandviewmodel.models.Album;
import com.example.listandviewmodel.ui.image.ImageViewModel;

public class ListAlbumFragment extends Fragment {

    private ImageViewModel viewModel;
    private ListLayoutBinding dataBinding;
    private NavController navController;
    private AlbumAdapter albumAdapter = new AlbumAdapter(new ToDoOnActions(){
        @Override
        public void onClick(Object item) {
            Album album = (Album)item;
            viewModel.loadImageOfAlbum(album);
            navController.navigate(R.id.imageListFragment);
        }
    });

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ImageViewModel.class);
        navController = NavHostFragment.findNavController(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = ListLayoutBinding.inflate(inflater, container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setupViews();
        observeData();
    }

    private void setupViews() {
        dataBinding.pageTitle.setText("Liste des albums");
        dataBinding.backButton.setVisibility(View.GONE);
        dataBinding.list.setLayoutManager(new LinearLayoutManager(requireContext()));
        dataBinding.list.setAdapter(albumAdapter);
    }

    private void observeData() {
        viewModel.albums.observe(getViewLifecycleOwner(), albums -> albumAdapter.submitList(albums));
    }
}
