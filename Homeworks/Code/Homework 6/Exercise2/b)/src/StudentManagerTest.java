package homework_mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class StudentManagerTest {

    @Test
    void testGenerateStudentDistributionWithMocks() {
        // Arrange
        StudentManager manager = StudentManagerFactory.create(true);

        // Act
        Map<String, List<String>> result = manager.generateStudentDistribution("C01");

        // Assert
        assertEquals(1, result.size());
        assertEquals(List.of("Mock Alice (12345)"), result.get("Mock Group A"));
    }
}
