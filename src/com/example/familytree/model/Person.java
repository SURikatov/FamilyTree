package com.example.familytree.model;

import java.io.*;
import java.time.LocalDate;

public class Person implements Identifiable, Nameable, Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;
    private Gender gender;
    private LocalDate birthdate;
    private LocalDate deathDate;
    private boolean isAlive;

    public Person(int id, String name, int age, LocalDate birthdate, LocalDate deathDate, boolean isAlive, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
        this.deathDate = deathDate;
        this.isAlive = isAlive;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                ", deathDate=" + deathDate +
                ", isAlive=" + isAlive +
                '}';
    }

    // Методы saveToFile и loadFromFile перенесены в класс FileHandler
}
