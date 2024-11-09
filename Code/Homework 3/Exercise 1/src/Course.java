// Datei: Course.java
public class Course {
    private String courseId;
    private String name;

    public Course(String courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }
}
