package com.example.familytree.model;

import java.util.List;
import java.util.logging.Logger;

public class Research {
    private static final Logger logger = Logger.getLogger(Research.class.getName());
    private FamilyTree<Object> familyTree;

    public Research(FamilyTree<Object> familyTree) {
        this.familyTree = familyTree;
    }

    public List<Person> getAllPeople() {
        return familyTree.getPeople();
    }

    public List<Dog> getAllDogs() {
        return familyTree.getDogs();
    }

    public void printAllPeople() {
        for (Person person : getAllPeople()) {
            logger.info(person.toString());
        }
    }

    public void printAllDogs() {
        for (Dog dog : getAllDogs()) {
            logger.info(dog.toString());
        }
    }
}
