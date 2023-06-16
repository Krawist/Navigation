package com.example.listandviewmodel.ui.student.list;

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
import com.example.listandviewmodel.adapter.StudentAdapter;
import com.example.listandviewmodel.databinding.MainFragmentBinding;
import com.example.listandviewmodel.listener.ToDoOnActions;
import com.example.listandviewmodel.models.Student;
import com.example.listandviewmodel.ui.MainViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class StudentListFragment extends Fragment {

    private MainFragmentBinding dataBinding;
    private NavController navController;

    private MainViewModel viewModel;
    private StudentAdapter studentAdapter = new StudentAdapter(new ToDoOnActions(){
        @Override
        public void onClick(Object item) {
            super.onClick(item);
        }

        @Override
        public boolean onLongClick(Object item) {
            new MaterialAlertDialogBuilder(requireContext())
                    .setMessage("Vous êtes sur le point de supprimer cet étudiant. Cliquez sur Supprimer pour valider la supression")
                    .setPositiveButton("Supprimer", (dialog, which) -> {
                        viewModel.deleteStudent((Student)item);
                    })
                    .setNegativeButton("Annuler",(dialog, which) ->{

                    }).show();

            return true;
        }
    });

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this, ViewModelProvider.Factory.from(MainViewModel.getInitialiser(requireActivity().getApplication()))).get(MainViewModel.class);

        navController = NavHostFragment.findNavController(StudentListFragment.this);
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
        dataBinding.buttonAdd.setOnClickListener(v -> navController.navigate(R.id.studentFormFragment));
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
