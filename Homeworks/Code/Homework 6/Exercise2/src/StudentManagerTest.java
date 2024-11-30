import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentManagerTest {

    @Mock
    private ExerciseGroup mockGroup1;

    @Mock
    private ExerciseGroup mockGroup2;

    @Mock
    private Student mockStudent1;

    @Mock
    private Student mockStudent2;

    private Course mockCourse;

    private StudentManager studentManager;

    @BeforeEach
    public void setUp() {
        // Verwende die empfohlene Methode openMocks() statt initMocks()
        MockitoAnnotations.openMocks(this);

        // Verwende direkt Mockito für Mocking
        mockCourse = mock(Course.class);

        // Konfiguration der Mocks
        when(mockGroup1.getName()).thenReturn("Group 1");
        when(mockGroup1.getStudents()).thenReturn(List.of(mockStudent1));
        when(mockGroup2.getName()).thenReturn("Group 2");
        when(mockGroup2.getStudents()).thenReturn(List.of(mockStudent2));

        when(mockStudent1.getName()).thenReturn("Alice");
        when(mockStudent1.getMatriculationNumber()).thenReturn("M12345");
        when(mockStudent2.getName()).thenReturn("Bob");
        when(mockStudent2.getMatriculationNumber()).thenReturn("M67890");

        when(mockCourse.getExerciseGroups()).thenReturn(List.of(mockGroup1, mockGroup2));
        when(mockCourse.getId()).thenReturn("mockId");

        // Initialisiere StudentManager
        studentManager = new StudentManager(List.of(mockStudent1, mockStudent2), List.of(mockCourse));
    }

    @Test
    public void testGenerateStudentDistribution() {
        var result = studentManager.generateStudentDistribution("mockId");

        Assertions.assertNotNull(result, "Das Ergebnis darf nicht null sein.");
        assertTrue(result.containsKey("Group 1"), "Die Ergebnisliste sollte 'Group 1' enthalten.");
        assertTrue(result.containsKey("Group 2"), "Die Ergebnisliste sollte 'Group 2' enthalten.");
        assertTrue(result.get("Group 1").contains("Alice (M12345)"), "'Group 1' sollte 'Alice (M12345)' enthalten.");
        assertTrue(result.get("Group 2").contains("Bob (M67890)"), "'Group 2' sollte 'Bob (M67890)' enthalten.");
    }

    @Test
    public void testGenerateStudentDistributionWithInvalidCourseId() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> studentManager.generateStudentDistribution("invalidId"));

        assertEquals("Course with ID invalidId not found.", exception.getMessage());
    }
}
