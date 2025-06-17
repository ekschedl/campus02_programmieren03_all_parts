package ue_19_sortieren;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] zahlen = {5, 2, 9, 1, 3};


        // Vor dem Sortieren ausgeben
        System.out.println("Vor dem Sortieren: " + Arrays.toString(zahlen));

        // Array sortieren
        Arrays.sort(zahlen);

        // Nach dem Sortieren ausgeben
        System.out.println("Nach dem Sortieren: " + Arrays.toString(zahlen));


        int min = zahlen[0];


        char[] chars = {'o', 'n', 'q', 's', 'a' };
        System.out.println("Vor dem Sortieren: " + Arrays.toString(chars));
        Arrays.sort(chars);
        System.out.println("Nach dem Sortieren: " + Arrays.toString(chars));

        String[] myStringd = {"Olja", "Katja", "Ella", "Boris", "Igor"};
        System.out.println("Vor dem Sortieren: " + Arrays.toString(myStringd));
        Arrays.sort(myStringd);
        System.out.println("Nach dem Sortieren: " + Arrays.toString(myStringd));

        Person[] persons = {
                new Person(7, "Max", "Schedlberger"),
                new Person(1, "Ekaterina", "Schedlberger"),
                new Person(2, "Simon", "Schedlberger"),
                new Person(7, "Alex", "Schedlberger"),
                new Person(10, "Sonic", "Schedlberger")

        };
        Arrays.sort(persons);
        System.out.println("Sortiertes Array");
        for (Person p : persons) {
            System.out.println(p);
        }

    }
}
