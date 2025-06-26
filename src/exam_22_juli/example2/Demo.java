package exam_22_juli.example2;

public class Demo {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Beispiel-Daten hinzufügen
        manager.add(new Student("1", "Ivan", "ivan@gmail.com"));
        manager.add(new Student("2", "Nella", "nel@gmail.com"));
        manager.add(new Student("3", "Helgaa", "hel@gmail.com"));
        manager.add(new Student("4", "David", "dav@gmail.com"));
        manager.add(new Student("5", "Maria", "mar@gmail.com"));

        // Test-Ausgabe
        System.out.println("Studentenliste: " + manager);

        // Export versuchen
        try {
            manager.exportStudentsToBinaryFile("students.dat");
        } catch (StudentExportException e) {
            System.out.println("\nAchtung! Export fehlgeschlagen: " + e.getMessage());
        }



    }
}

/*  u variante

public class Demo {

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.add(new Student("1", "John Doe", "Computer Science"));
        studentManager.add(new Student("2", "Jane Smith", "Mathematics"));
        studentManager.add(new Student("3", "Emily Davis", "Physics"));
        studentManager.add(new Student("4", "Michael Brown", "Biology"));
        studentManager.add(new Student("5", "Jessica Wilson", "Chemistry"));

        // Pfad zur Ausgabedatei
        String filePath = "students.dat";

        // Versuch, die Studentenliste in die Datei zu exportieren
        try {
            studentManager.exportStudentsToBinaryFile(filePath);
        } catch (StudentExportException e) {
            System.out.println(e.getMessage());
        }
    }
}
 */