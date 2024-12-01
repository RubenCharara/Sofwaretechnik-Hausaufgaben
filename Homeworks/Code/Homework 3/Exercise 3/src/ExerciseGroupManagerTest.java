// Datei: ExerciseGroupManagerTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class ExerciseGroupManagerTest {

    @Test
    void testCapacityExceeded() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        assertEquals(5, manager.checkGroupCapacities(25, 5, 4));
    }

    @Test
    void testExactFit() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        assertEquals(0, manager.checkGroupCapacities(20, 5, 4));
    }

    @Test
    void testTotalStudentsZero() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        assertEquals(0, manager.checkGroupCapacities(0, 5, 4));
    }

    @Test
    void testNegativeGroupSize() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(25, -5, 4));
    }

    @Test
    void testNegativeAvailableGroups() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(25, 5, -4));
    }
}
