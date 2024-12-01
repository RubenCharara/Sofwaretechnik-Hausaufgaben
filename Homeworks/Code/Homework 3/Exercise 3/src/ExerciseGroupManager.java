// Datei: ExerciseGroupManager.java
public class ExerciseGroupManager {

    /**
     * Überprüft, wie viele Studenten in die Gruppen passen, basierend auf der Kapazität.
     *
     * @param totalStudents Die Gesamtzahl der Studenten.
     * @param groupSize Die maximale Größe einer Gruppe.
     * @param groupCount Die Anzahl der verfügbaren Gruppen.
     * @return Die Anzahl der Studenten, die in die Gruppen passen.
     */
    public int checkGroupCapacities(int totalStudents, int groupSize, int groupCount) {
        int maxCapacity = groupSize * groupCount;
        return Math.min(totalStudents, maxCapacity);
    }
}
