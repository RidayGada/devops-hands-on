package com.example.student_management.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository sr;


    @Override
    public List<Student> getAllStudents() {

        return sr.findAll();
    }


    @Override
    public Student getStudentById(Long id) {

        return sr.findById(id).orElse(null);
    }


    @Override
    public Student insertStudent(Student student) {

        System.out.println(student);

        return sr.save(student);
    }


    @Override
    public List<Student> findAllStudents() {

        return sr.findAll();
    }


    @Override
    public Student findStudent(Long id) {

        return sr.findById(id).orElse(null);
    }


    @Override
    public void deleteStudent(Long id) {

        sr.deleteById(id);
    }


    @Override
    public Student updateStudentById(Long id, Student student) {


        Student existingStudent = sr.findById(id).orElse(null);


        if(existingStudent != null) {

            existingStudent.setName(student.getName());

            existingStudent.setCourse(student.getCourse());


            return sr.save(existingStudent);
        }


        return null;
    }

}