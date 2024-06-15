package com.example.familytree.presenter;

import java.io.*;
import java.util.Map;

import com.example.familytree.model.FamilyTree;

public class FileHandler {
    private FileHandler() {

    }

    public static <T> void saveFamilyTree(FamilyTree<T> tree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tree.getMembers());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> FamilyTree<T> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Map<Integer, T> members = (Map<Integer, T>) ois.readObject();
            FamilyTree<T> tree = new FamilyTree<>();
            tree.setMembers(members);
            return tree;
        }
    }
}
