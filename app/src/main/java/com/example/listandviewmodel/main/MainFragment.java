package com.example.listandviewmodel.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.listandviewmodel.R;
import com.example.listandviewmodel.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {

    private MainFragmentBinding dataBinding;
    private NavController navController;

    private MainFragmentViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainFragmentViewModel.class);
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
        navController = NavHostFragment.findNavController(MainFragment.this);
        observeViews();
        observeData();
    }

    private void observeData() {

    }

    private void observeViews() {
        dataBinding.buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.counterLiveData.observe(getViewLifecycleOwner(), new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        dataBinding.mainTextValue.setText(String.valueOf(integer));
                        if(integer % 5 == 0){
                            viewModel.increment();
                            navController.navigate(R.id.secondFragment);
                        }
                    }
                });

                viewModel.increment();
            }
        });
    }
}
