package _EXCEPTIONS____.Pensionsantritt_____Eigene_____Exeptions;

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

    //    überprüft ob das Alter zwischen 60-65 Jahren ist (inklusive 60 und exklusive 65),
    //    wenn nicht wirft der Setter eine ZAMAgeTooLowException
    //    oder ZAMAgeTooHighException.
    public void setAge(int age) throws ZAMAgeTooLowException, ZAMAgeTooHighException {

            if (age >= 60 && age < 65) {
                this.Age = age;
            } else if (age >= 65) {
                throw new ZAMAgeTooHighException("zu alt");
            } else {
                throw new ZAMAgeTooLowException("zu jung");
            }

        }





    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
