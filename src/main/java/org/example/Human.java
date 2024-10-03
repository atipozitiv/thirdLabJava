package org.example;

public class Human implements Comparable<Human> {
    String name;
    String surname;
    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human (String name, String surname, int age) {
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    @Override
    public int compareTo(Human secondHuman) {
        return this.surname.compareTo(secondHuman.surname);
    }
}
