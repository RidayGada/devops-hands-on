package com.example.student_management.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;



@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private StudentService studentService;



    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }



    // Get student by id
    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable Long id) {

        return studentService.getStudentById(id);
    }



    // Add new student
    @PostMapping
    public Student addStudent(
            @RequestBody Student student) {

        return studentService.insertStudent(student);
    }



    // Update student
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return studentService.updateStudentById(id, student);
    }



    // Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);

        return "Student deleted successfully";
    }

}