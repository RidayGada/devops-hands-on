package com.example.student_management.service;

import java.util.List;

import com.example.student_management.entity.Student;


public interface StudentService {


    List<Student> getAllStudents();


    Student getStudentById(Long id);


    Student insertStudent(Student student);


    List<Student> findAllStudents();


    Student findStudent(Long id);


    void deleteStudent(Long id);


    Student updateStudentById(Long id, Student student);

}