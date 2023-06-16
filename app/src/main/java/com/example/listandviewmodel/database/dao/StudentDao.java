package com.example.listandviewmodel.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.listandviewmodel.database.models.StudentCache;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM students")
    LiveData<List<StudentCache>> getLiveDataAllStudent();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveStudent(StudentCache studentCache);

    @Delete
    void deleteStudent(StudentCache studentCache);
}
