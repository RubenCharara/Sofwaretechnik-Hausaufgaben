public class checkGroupCapacities {public int checkGroupCapacities(int totalStudents, int groupSize, int availableGroups) {
    // Überprüfen auf ungültige Eingaben
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
