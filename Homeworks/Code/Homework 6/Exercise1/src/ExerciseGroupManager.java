public class ExerciseGroupManager {

    /**
     * Berechnet die maximale Anzahl von Studenten, die in den verfügbaren Gruppen verteilt werden können.
     *
     * @param totalStudents Die Gesamtzahl der Studenten.
     * @param groupSize Die maximale Gruppengröße.
     * @param availableGroups Die Anzahl verfügbarer Gruppen.
     * @return Die Anzahl der verbleibenden Studenten oder 0, wenn alle verteilt wurden.
     * @throws IllegalArgumentException Wenn eine der Eingaben ungültig ist (negativ oder 0).
     */
    public int checkGroupCapacities(int totalStudents, int groupSize, int availableGroups) {
        // Überprüfe, ob die Eingaben gültig sind
        if (totalStudents < 0 || groupSize <= 0 || availableGroups <= 0) {
            throw new IllegalArgumentException("Ungültige Eingabeparameter.");
        }

        // Berechnung der maximalen Kapazität
        int maxCapacity = groupSize * availableGroups;

        // Wenn alle Studenten verteilt werden können
        if (totalStudents <= maxCapacity) {
            return 0; // Keine verbleibenden Studenten
        } else {
            // Berechnung der verbleibenden Studenten
            return totalStudents - maxCapacity;
        }
    }
}
