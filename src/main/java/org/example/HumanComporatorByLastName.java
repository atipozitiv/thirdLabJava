package org.example;

import java.util.Comparator;

public class HumanComporatorByLastName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.surname.compareTo(o2.surname);
    }
}
