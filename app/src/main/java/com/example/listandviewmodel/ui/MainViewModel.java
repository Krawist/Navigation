package com.example.listandviewmodel.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.listandviewmodel.R;
import com.example.listandviewmodel.models.Student;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    public MutableLiveData<List<Student>> students = new MutableLiveData();
    private List<Student> baseStudents = new ArrayList<>();


    public MainViewModel(){
        baseStudents.add(new Student("Hello", "brown", R.drawable.image_3, "1"));
        students.setValue(baseStudents);
    }

    public void createStudent(Student student) {
        List<Student> previousStudent = students.getValue();
        students.setValue(previousStudent);

        if(previousStudent == null){
            previousStudent = new ArrayList<>();
        }
        previousStudent.add(student);

        students.setValue(previousStudent);
    }
}
