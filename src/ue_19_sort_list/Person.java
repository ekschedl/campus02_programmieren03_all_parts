package ue_19_sort_list;

public class Person implements Comparable<Person> {
    private int id;
    private String firstName;
    private String lastName;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        Person person1 = this;
        Person person2 = p;
        System.out.println("Vergleiche: " + person1 + " mit " + person2);
        if (person1.id < person2.id) return -1;
        if (person1.id > person2.id) return 1;
        return 0;
    }
}