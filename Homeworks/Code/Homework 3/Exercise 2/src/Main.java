public class Main {
    public static void main(String[] args) {
        // EntityManager für Studenten
        EntityManager<Student> studentManager = new EntityManager<>();
        studentManager.addEntity(new Student("S1", "Alice", "Smith"));

        // EntityManager für Dozenten
        EntityManager<Lecturer> lecturerManager = new EntityManager<>();
        lecturerManager.addEntity(new Lecturer("L1", "Dr. Bob", "Jones"));

        // Suchen eines Studenten mit ID "S1"
        Student foundStudent = studentManager.getEntityBy(s -> s.getId().equals("S1"));
        System.out.println("Found Student: " + (foundStudent != null ? foundStudent.getFirstName() : "None"));

        // Suchen eines Dozenten mit ID "L1"
        Lecturer foundLecturer = lecturerManager.getEntityBy(l -> l.getId().equals("L1"));
        System.out.println("Found Lecturer: " + (foundLecturer != null ? foundLecturer.getFirstName() : "None"));
    }
}
