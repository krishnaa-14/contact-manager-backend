package com.example.quizapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(path ="api/v1/student")
public class StudentController {

    @Autowired
    public final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173") // Replace with your frontend URL
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173") // Replace with your frontend URL
    public ResponseEntity<Map<String, String>> registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Contact added successfully !!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

}
