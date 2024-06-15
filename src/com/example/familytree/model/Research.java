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
        List<Person> people = getAllPeople();
        for (Person person : people) {
            logger.info(person.toString());
        }
    }

    public void printAllDogs() {
        List<Dog> dogs = getAllDogs();
        for (Dog dog : dogs) {
            logger.info(dog.toString());
        }
    }
}


 // Методы printAllPeople и printAllDogs перенесены в класс ConsoleView