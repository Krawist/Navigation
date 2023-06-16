package com.example.listandviewmodel.repositories.student;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.listandviewmodel.database.CtiDatabase;
import com.example.listandviewmodel.database.dao.StudentDao;
import com.example.listandviewmodel.database.models.StudentCache;
import com.example.listandviewmodel.models.Student;

import java.util.List;
import java.util.stream.Collectors;

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
    public LiveData<List<Student>> getLiveDataAllStudent() {
        return Transformations.map(studentDao.getLiveDataAllStudent(), studentsCaches -> studentsCaches.stream().map(studentCache -> studentCache.toDomainModel()).collect(Collectors.toList()));
    }

    @Override
    public void deleteStudent(Student student) {
        CtiDatabase.databaseWriteExecutor.execute(() -> studentDao.deleteStudent(student.toCacheModel()));
    }
}
