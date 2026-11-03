package com.spriingboot.student_managment_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @GetMapping
    public ResponseEntity<String> getStudents(){
        return ResponseEntity.ok("student retrieved successfully ");
    }

    @PostMapping
    public ResponseEntity<String> creteStudent(){
        return ResponseEntity.ok("student created successfully ");
    }
    @PutMapping
    public ResponseEntity<String> updateStudent(){
        return ResponseEntity.ok("student update successfully ");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAStudent(){
        return ResponseEntity.ok("student deleted successfully ");
    }

    @GetMapping("/csrf")
    public CsrfToken getToken (CsrfToken csrfToken){
        return csrfToken;
    }

    @GetMapping("/display")
    public String display(){
        return "display data show";
    }
}

