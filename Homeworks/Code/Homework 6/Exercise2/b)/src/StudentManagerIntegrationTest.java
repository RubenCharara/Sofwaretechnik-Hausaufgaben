import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class StudentManagerIntegrationTest {

    @Test
    void testGenerateStudentDistributionWithRealObjects() {
        // Arrange
        StudentManager manager = StudentManagerFactory.create(false);

        // Act
        Map<String, List<String>> result = manager.generateStudentDistribution("C01");

        // Assert
        assertEquals(1, result.size());
        assertEquals(List.of("Alice (12345)", "Bob (67890)"), result.get("Group A"));
    }
}
