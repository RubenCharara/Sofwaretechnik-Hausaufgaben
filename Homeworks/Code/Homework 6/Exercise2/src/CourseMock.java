import java.util.List;

public class CourseMock {
    public class MockCourse extends Course {
    public MockCourse() {
        super("mockId", List.of());
    }

    @Override
    public List<ExerciseGroup> getExerciseGroups() {
        return List.of(); // Oder mockbare Listen einfügen
    }
}

}
