package com.example.listandviewmodel.models;

public class Student {
    private String studentName;
    private String studentEmailAddress;
    private int studentImage;

    private String studentMatricule;

    public Student(String studentName, String studentEmailAddress, int studentImage, String studentMatricule) {
        this.studentName = studentName;
        this.studentEmailAddress = studentEmailAddress;
        this.studentImage = studentImage;
        this.studentMatricule = studentMatricule;
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
