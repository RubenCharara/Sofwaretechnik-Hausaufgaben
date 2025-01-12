import java.util.List;

public class ExerciseGroup {
    private final String name;
    private final List<Student> students;

    public ExerciseGroup(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}