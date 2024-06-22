package com.example.familytree.presenter;

import com.example.familytree.model.FamilyTree;
import com.example.familytree.model.Person;

import java.io.*;

import java.util.Map;

public class FileHandler {
    private FileHandler() {

    }

    public static void saveFamilyTree(FamilyTree<Person> tree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tree.getMembers());
        }
    }

    public static FamilyTree<Person> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object object = ois.readObject();
            if (object instanceof Map<?, ?>) {
                @SuppressWarnings("unchecked")
                Map<Integer, Person> members = (Map<Integer, Person>) object;
                FamilyTree<Person> tree = new FamilyTree<>();
                tree.setMembers(members);
                return tree;
            } else {
                throw new IOException("Файл не содержит корректных данных для FamilyTree");
            }
        }
    }
}
