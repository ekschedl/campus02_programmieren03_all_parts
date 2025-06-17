package ue_19_sort_list;

import ue_19_sortieren.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person(7, "Max", "Schedlberger"));
        people.add(new Person(1, "Ekaterina", "Schedlberger"));
        people.add(new Person(2, "Simon", "Schedlberger"));
        people.add(new Person(7, "Alex", "Schedlberger"));
        people.add(new Person(10, "Sonic", "Schedlberger"));

        Collections.sort(people);

        System.out.println("Sortierte Liste:");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}