package com.example.listandviewmodel.ui.form;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.listandviewmodel.R;
import com.example.listandviewmodel.databinding.SecondFragmentBinding;
import com.example.listandviewmodel.models.Student;
import com.example.listandviewmodel.ui.MainViewModel;

import java.util.UUID;

public class FormFragment extends Fragment {

    private SecondFragmentBinding dataBinding;
    private MainViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, ViewModelProvider.Factory.from(MainViewModel.getInitialiser(requireActivity().getApplication()))).get(MainViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = SecondFragmentBinding.inflate(inflater, container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        observeViews();
    }

    private void observeViews() {
        dataBinding.studentName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO document why this method is empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO document why this method is empty
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s.toString())){
                    dataBinding.inputLayoutStudentName.setErrorEnabled(true);
                    dataBinding.inputLayoutStudentName.setError("Veuillez remplir le nom de l'étudiant");
                }else{
                    dataBinding.inputLayoutStudentName.setErrorEnabled(false);
                    dataBinding.inputLayoutStudentName.setError(null);
                }
            }
        });
        dataBinding.studentEmailAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO document why this method is empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO document why this method is empty
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s.toString())){
                    dataBinding.inputLayoutStudentName.setErrorEnabled(true);
                    dataBinding.inputLayoutStudentName.setError("Veuillez remplir l'adresse mail de l'étudiant");
                }else{
                    dataBinding.inputLayoutStudentName.setErrorEnabled(false);
                    dataBinding.inputLayoutStudentName.setError(null);
                }
            }
        });

        dataBinding.buttonSaveStudent.setOnClickListener(v -> {
            String studentName = dataBinding.studentName.getText().toString();
            String studentEmailAddress = dataBinding.studentEmailAddress.getText().toString();

            if(!TextUtils.isEmpty(studentName) && !TextUtils.isEmpty(studentEmailAddress)){
                viewModel.createStudent(new Student(studentName, studentEmailAddress, R.drawable.image_3, UUID.randomUUID().toString()));
                Toast.makeText(requireContext(),"Nouvel étudiant créé", Toast.LENGTH_SHORT).show();
                requireActivity().getOnBackPressedDispatcher().onBackPressed();
            }else{
                Toast.makeText(requireContext(),"Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
