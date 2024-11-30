import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

@RunWith(MockitoJUnitRunner.class)

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

        // Konfiguriere mockCourse, um die Gruppen zu simulieren
        when(mockCourse.getExerciseGroups()).thenReturn(List.of(mockGroup1, mockGroup2));

        // Initialisiere StudentManager
        studentManager = new StudentManager(List.of(mockStudent1, mockStudent2), List.of(mockCourse));
    }

    @Test
    public void testGenerateStudentDistribution() {
        var result = studentManager.generateStudentDistribution("mockId");

        // Überprüfe die Ergebnisse
        assert result.containsKey("Group 1");
        assert result.containsKey("Group 2");

        assert result.get("Group 1").contains("Alice (M12345)");
        assert result.get("Group 2").contains("Bob (M67890)");
    }
}
