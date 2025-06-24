package _EXCEPTIONS____.FUCHS_Pensionsantritt_Exceptions;


public class Person {
    private int Age;
    private String Name;

    public Person(int age, String name) {
        Age = age;
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public String getName() {
        return Name;
    }

    public void setAge(int age) throws ZAMAgeTooLowException, ZAMAgeTooHighException {
        //der Setter für Age überprüft ob das Alter zwischen 60-65 Jahren ist (inklusive 60 und exklusive 65), wenn nicht wirft der Setter eine ZAMAgeTooLowException oder ZAMAgeTooHighException.
        if (age < 60) {
            throw new ZAMAgeTooLowException("Alter zu niedrig!");
        }
        if (age >= 65) {
            throw new ZAMAgeTooHighException("Alter zu hoch!");
        }
        Age = age;
    }

    public void setName(String name) {
        Name = name;
    }
}
