/*
import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Object> registeredCourses;

    public Student(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.registeredCourses = new ArrayList<>().reversed();
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }
}
*/

// Datei: Student.java
import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Course> registeredCourses;

    public Student(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }
}
