package com.example.familytree;

import com.example.familytree.model.*;
import com.example.familytree.presenter.*;
import com.example.familytree.view.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String FILENAME = "familytree.ser";

    public static void main(String[] args) {
        FamilyTree<Object> familyTree = loadFamilyTreeFromFile();
        View view = new ConsoleView();
        Presenter presenter = new FamilyTreePresenter(familyTree, view);

        addInitialData(presenter);

        presenter.loadPeople();
        presenter.loadDogs();

        saveFamilyTreeToFile(familyTree);
    }

    private static FamilyTree<Object> loadFamilyTreeFromFile() {
        try {
            return FileHandler.loadFamilyTree(FILENAME);
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Не удалось загрузить семейное дерево из файла. Создается новое семейное дерево.", e);
            return new FamilyTree<>();
        }
    }

    private static void saveFamilyTreeToFile(FamilyTree<Object> familyTree) {
        try {
            FileHandler.saveFamilyTree(familyTree, FILENAME);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Не удалось сохранить семейное дерево в файл.", e);
        }
    }

    private static void addInitialData(Presenter presenter) {
        LocalDate birthdatePerson1 = LocalDate.of(1990, 1, 1);
        LocalDate birthdatePerson2 = LocalDate.of(1995, 6, 15);
        LocalDate birthdateDog1 = LocalDate.of(2019, 5, 1);
        LocalDate birthdateDog2 = LocalDate.of(2021, 8, 10);

        Person person1 = new Person(1, "Света", 30, birthdatePerson1, null, true, Gender.FEMALE);
        Person person2 = new Person(2, "Федор", 25, birthdatePerson2, null, true, Gender.MALE);
        Dog dog1 = new Dog(1, "Шарик", 5, birthdateDog1, null, true);
        Dog dog2 = new Dog(2, "Себастьян", 3, birthdateDog2, null, true);

        presenter.addPerson(person1);
        presenter.addPerson(person2);
        presenter.addDog(dog1);
        presenter.addDog(dog2);
    }
}
