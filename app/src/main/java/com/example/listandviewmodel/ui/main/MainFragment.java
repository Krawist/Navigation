package com.example.listandviewmodel.ui.main;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.listandviewmodel.R;
import com.example.listandviewmodel.adapter.StudentAdapter;
import com.example.listandviewmodel.databinding.MainFragmentBinding;
import com.example.listandviewmodel.ui.MainViewModel;

public class MainFragment extends Fragment {

    private MainFragmentBinding dataBinding;
    private NavController navController;

    private MainViewModel viewModel;
    private StudentAdapter studentAdapter = new StudentAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this, ViewModelProvider.Factory.from(MainViewModel.getInitialiser(requireActivity().getApplication()))).get(MainViewModel.class);

        navController = NavHostFragment.findNavController(MainFragment.this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        dataBinding = MainFragmentBinding.inflate(inflater, container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setupList();
        observeData();
        observeView();
    }

    private void observeView() {
        dataBinding.buttonAdd.setOnClickListener(v -> navController.navigate(R.id.secondFragment));
    }

    private void observeData() {
        viewModel.students.observe(getViewLifecycleOwner(), students -> {
            studentAdapter.submitList(students);
        });
    }

    private void setupList() {
        dataBinding.listview.setLayoutManager(new LinearLayoutManager(requireContext()));
        dataBinding.listview.setAdapter(studentAdapter);
    }
}
