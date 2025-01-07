package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // GET-Endpunkt: Student nach ID abrufen
    @GetMapping
    public ResponseEntity<Student> getStudent(@RequestParam Long id) {
        return studentRepository.findById(Student.Id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST-Endpunkt: Neuen Studenten hinzufügen
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    // DELETE-Endpunkt: Studenten nach ID löschen
    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@RequestParam Long id) {
        if (studentRepository.existsById(Student.Id)) {
            studentRepository.deleteById(Student.Id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}