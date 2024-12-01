import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentManagerFactory {
    public static StudentManager create(boolean useMocks) {
        if (useMocks) {
            // Mocks erstellen
            Student mockStudent1 = Mockito.mock(Student.class);
            Mockito.when(mockStudent1.getName()).thenReturn("Mock Alice");
            Mockito.when(mockStudent1.getMatriculationNumber()).thenReturn("12345");

            ExerciseGroup mockGroup = Mockito.mock(ExerciseGroup.class);
            Mockito.when(mockGroup.getName()).thenReturn("Mock Group A");
            Mockito.when(mockGroup.getStudents()).thenReturn(Collections.singletonList(mockStudent1));

            Course mockCourse = Mockito.mock(Course.class);
            Mockito.when(mockCourse.getId()).thenReturn("C01");
            Mockito.when(mockCourse.getExerciseGroups()).thenReturn(Collections.singletonList(mockGroup));

            List<Course> mockCourses = Collections.singletonList(mockCourse);

            return new StudentManager(Collections.emptyList(), mockCourses);
        } else {
            // Echte Objekte erstellen
            Student student1 = new Student("Alice", "12345");
            Student student2 = new Student("Bob", "67890");

            ExerciseGroup group = new ExerciseGroup("Group A", Arrays.asList(student1, student2));

            Course course = new Course("C01", Collections.singletonList(group));

            List<Course> realCourses = Collections.singletonList(course);

            return new StudentManager(Collections.emptyList(), realCourses);
        }
    }
}
