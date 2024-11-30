public class Student {
    private final String name;
    private final String matriculationNumber;

    public Student(String name, String matriculationNumber) {
        this.name = name;
        this.matriculationNumber = matriculationNumber;
    }

    public String getName() {
        return name;
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }
}