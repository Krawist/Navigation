package com.example.listandviewmodel.repositories.student;

import androidx.lifecycle.LiveData;

import com.example.listandviewmodel.database.models.StudentCache;
import com.example.listandviewmodel.models.Student;

import java.util.List;

public interface StudentRepository {

    void saveStudent(Student student);

    LiveData<List<Student>> getLiveDataAllStudent();

    void deleteStudent(Student student);
}
