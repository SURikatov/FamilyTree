package com.example.familytree.model;

import java.io.*;

import com.example.utils.FileSerializable;

public class Dog implements FileSerializable<Dog>, Nameable, Identifiable, Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;

    public Dog(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void saveToFile(String fileName, Dog dog) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(dog);
        }
    }

    @Override
    public Dog loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Dog) ois.readObject();
        }
    }
}
