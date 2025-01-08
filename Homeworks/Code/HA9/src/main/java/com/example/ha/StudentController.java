package com.example.ha;



import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        try {
            // Ensure the ID is not manually set for new records
            if (student.getId() != null) {
                return ResponseEntity.badRequest().body("ID must not be provided for new students.");
            }

            // Validate other fields
            if (student.getName() == null || student.getMatNr() == null || student.getSubject() == null) {
                return ResponseEntity.badRequest().body("All fields (name, matNr, subject) are required.");
            }

            // Save the student
            Student savedStudent = studentRepository.save(student);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while saving the student.");
        }
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
