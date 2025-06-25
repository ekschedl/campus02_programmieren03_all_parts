package _EXCEPTIONS____.FUCHS_Pensionsantritt_Exceptions;

public class Person {

    private int Age;    // Alter der Person
    private String Name;  // Name der Person

    public Person(int age, String name) {
        Age = age;    // Konstruktor setzt Anfangsalter
        Name = name;  // Konstruktor setzt Namen
    }

    public int getAge() {
        return Age;   // Getter für das Alter
    }

    public String getName() {
        return Name;  // Getter für den Namen
    }

    public void setAge(int age) throws ZAMAgeTooLowException, ZAMAgeTooHighException {
        //der Setter für Age überprüft ob das Alter zwischen 60-65 Jahren ist (inklusive 60 und exklusive 65),
        //wenn nicht wirft der Setter eine ZAMAgeTooLowException oder ZAMAgeTooHighException.

        if (age < 60) {                          // Prüfen ob Alter zu niedrig
            throw new ZAMAgeTooLowException("Alter zu niedrig!");  // Eigene Exception wird geworfen
        }
        if (age >= 65) {                        // Prüfen ob Alter zu hoch
            throw new ZAMAgeTooHighException("Alter zu hoch!");    // Eigene Exception wird geworfen
        }
        Age = age;   // Wenn keine Exception, wird Alter gespeichert
    }

    public void setName(String name) {
        Name = name;  // Setter für Namen ohne weitere Prüfung
    }
}