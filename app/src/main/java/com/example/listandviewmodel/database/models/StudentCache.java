package com.example.listandviewmodel.database.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.listandviewmodel.models.Student;

@Entity(tableName = "students")
public class StudentCache {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "student_matricule")
    private String studentMatricule;

    @ColumnInfo(name = "student_name")
    private String studentName;

    @ColumnInfo(name = "student_email_address")
    private String studentEmailAddress;
    @ColumnInfo(name = "student_image")
    private int studentImage;

    public StudentCache(String studentMatricule, String studentName, String studentEmailAddress, int studentImage) {
        this.studentMatricule = studentMatricule;
        this.studentName = studentName;
        this.studentEmailAddress = studentEmailAddress;
        this.studentImage = studentImage;
    }

    public Student toDomainModel(){
        return new Student(studentName, studentEmailAddress, studentImage, studentMatricule);
    }

    public String getStudentMatricule() {
        return studentMatricule;
    }

    public void setStudentMatricule(String studentMatricule) {
        this.studentMatricule = studentMatricule;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmailAddress() {
        return studentEmailAddress;
    }

    public void setStudentEmailAddress(String studentEmailAddress) {
        this.studentEmailAddress = studentEmailAddress;
    }

    public int getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(int studentImage) {
        this.studentImage = studentImage;
    }


}
