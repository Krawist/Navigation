package com.example.listandviewmodel.repositories.student;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.listandviewmodel.database.CtiDatabase;
import com.example.listandviewmodel.database.dao.StudentDao;
import com.example.listandviewmodel.database.models.StudentCache;
import com.example.listandviewmodel.models.Student;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{

    private StudentDao studentDao;

    public StudentRepositoryImpl(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(Student student) {
        CtiDatabase.databaseWriteExecutor.execute(() -> studentDao.saveStudent(student.toCacheModel()));
    }

    @Override
    public LiveData<List<StudentCache>> getLiveDataAllStudent() {
        return studentDao.getLiveDataAllStudent();
    }
}
