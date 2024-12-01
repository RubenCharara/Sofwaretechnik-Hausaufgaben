import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class ExerciseGroupManagerTest {

    @ParameterizedTest(name = "Test {index}: totalStudents={0}, groupSize={1}, availableGroups={2}, expected={3}")
    @CsvSource({
            "-5, 10, 10, Exception",     // Negative Studentenanzahl
            "0, 10, 10, 0",              // Keine Studenten
            "15, 5, 3, 0",               // Exakte Kapazität
            "20, 5, 3, 5",               // Überschüssige Studenten
            "25, -5, 4, Exception",      // Negative Gruppengröße
            "25, 0, 4, Exception",       // Gruppengröße 0
            "1000000, 5, 200000, 0"      // Extrem große Eingabe
    })
    void testCheckGroupCapacities(String totalStudents, String groupSize, String availableGroups, String expected) {
        ExerciseGroupManager manager = new ExerciseGroupManager();

        if (expected.equals("Exception")) {
            assertThrows(IllegalArgumentException.class, () ->
                    manager.checkGroupCapacities(Integer.parseInt(totalStudents), Integer.parseInt(groupSize), Integer.parseInt(availableGroups))
            );
        } else {
            int result = manager.checkGroupCapacities(
                    Integer.parseInt(totalStudents),
                    Integer.parseInt(groupSize),
                    Integer.parseInt(availableGroups)
            );
            assertEquals(Integer.parseInt(expected), result);
        }
    }}
