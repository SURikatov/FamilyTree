package com.example.familytree.model;

import java.io.*;
import com.example.utils.FileSerializable;

public class Person implements FileSerializable<Person>, Nameable, Identifiable, Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;
    private Gender gender;

    public Person(int id, String name, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public void saveToFile(String fileName, Person person) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(person);
        }
    }

    @Override
    public Person loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Person) ois.readObject();
        }
    }
}
