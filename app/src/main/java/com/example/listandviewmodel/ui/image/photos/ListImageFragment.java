package com.example.listandviewmodel.ui.image.photos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.listandviewmodel.adapter.ImageAdapter;
import com.example.listandviewmodel.databinding.ListLayoutBinding;
import com.example.listandviewmodel.listener.ToDoOnActions;
import com.example.listandviewmodel.ui.image.ImageViewModel;

public class ListImageFragment extends Fragment {

    private ImageViewModel viewModel;
    private ListLayoutBinding dataBinding;
    private ImageAdapter imageAdapter = new ImageAdapter(new ToDoOnActions());

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ImageViewModel.class);
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
        observeViews();
    }

    private void observeViews() {
        dataBinding.backButton.setOnClickListener(v -> requireActivity().getOnBackPressedDispatcher().onBackPressed());
    }

    private void setupViews() {
        dataBinding.pageTitle.setText("Image d'un album");
        dataBinding.backButton.setVisibility(View.VISIBLE);
        dataBinding.list.setLayoutManager(new GridLayoutManager(requireContext(),2));
        dataBinding.list.setAdapter(imageAdapter);
    }

    private void observeData() {
        viewModel.imageOfAlbums.observe(getViewLifecycleOwner(), images -> imageAdapter.submitList(images));
    }
}
