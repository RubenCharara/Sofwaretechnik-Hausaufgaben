// Datei: Lecturer.java
import java.util.ArrayList;
import java.util.List;

public class Lecturer extends User {
    private List<Course> managedCourses;

    public Lecturer(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.managedCourses = new ArrayList<>();
    }

    public void manageCourse(Course course) {
        managedCourses.add(course);
    }

    public List<Course> getManagedCourses() {
        return managedCourses;
    }
}
