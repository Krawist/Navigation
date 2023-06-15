package com.example.listandviewmodel.ui;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

import com.example.listandviewmodel.R;
import com.example.listandviewmodel.database.CtiDatabase;
import com.example.listandviewmodel.database.dao.StudentDao;
import com.example.listandviewmodel.models.Student;
import com.example.listandviewmodel.repositories.student.StudentRepository;
import com.example.listandviewmodel.repositories.student.StudentRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainViewModel extends ViewModel {

    private StudentRepository studentRepository;

    public LiveData<List<Student>> students;
    private List<Student> baseStudents = new ArrayList<>();

    public MainViewModel(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        students = Transformations.map(studentRepository.getLiveDataAllStudent(), studentsCache -> studentsCache.stream().map(studentCache -> studentCache.toDomainModel()).collect(Collectors.toList()));
    }

    public void createStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public static ViewModelInitializer<MainViewModel> getInitialiser(Application applicationContext) {
        return new ViewModelInitializer<>(MainViewModel.class, creationExtras -> {
            StudentDao studentDao = CtiDatabase.getInstance(applicationContext).getStudentDao();
            return new MainViewModel(new StudentRepositoryImpl(studentDao));
        });
    }
}
