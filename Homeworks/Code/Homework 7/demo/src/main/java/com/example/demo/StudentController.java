package com.example.ha;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // GET-Endpunkt: Student nach ID abrufen
    @GetMapping
    public ResponseEntity<Student> getStudent(@RequestParam Long id) {
        return studentRepository.findById(id) // Korrektur: Verwende die ID direkt
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
        if (studentRepository.existsById(id)) { // Korrektur: Verwende die ID direkt
            studentRepository.deleteById(id); // Korrektur: ID wird verwendet
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
