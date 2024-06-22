package com.example.familytree.service;

import com.example.familytree.model.FamilyTree;
import com.example.familytree.model.Person;
import com.example.familytree.presenter.FileHandler;

import java.io.IOException;
import java.util.List;

public class FamilyTreeService {
    private FamilyTree<Person> familyTree;
    private static final String FILENAME = "familytree.ser";

    public FamilyTreeService() {
        this.familyTree = loadFamilyTreeFromFile();
    }

    public void addPerson(Person person) {
        familyTree.addMember(person.getId(), person);
    }

    public List<Person> getPeople() {
        return familyTree.getPeople();
    }

    private FamilyTree<Person> loadFamilyTreeFromFile() {
        try {
            return FileHandler.loadFamilyTree(FILENAME);
        } catch (IOException | ClassNotFoundException e) {
            return new FamilyTree<>();
        }
    }

    public void saveFamilyTreeToFile() {
        try {
            FileHandler.saveFamilyTree(familyTree, FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
