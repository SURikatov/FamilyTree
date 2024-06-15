package com.example.familytree;

import com.example.familytree.model.Dog;
import com.example.familytree.model.FamilyTree;
import com.example.familytree.model.Gender;
import com.example.familytree.model.Person;
import com.example.familytree.presenter.FamilyTreePresenter;
import com.example.familytree.presenter.FileHandler;
import com.example.familytree.presenter.Presenter;
import com.example.familytree.view.ConsoleView;
import com.example.familytree.view.View;

import java.io.IOException;
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
            logger.log(Level.SEVERE, "Не удалось загрузить семейное дерево из файла. Создаем новое семейное дерево.", e);
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
        Person person1 = new Person(1, "Алиса", 30, Gender.FEMALE);
        Person person2 = new Person(2, "Боб", 25, Gender.MALE);
        Dog dog1 = new Dog(1, "Бадди", 5);
        Dog dog2 = new Dog(2, "Чарли", 3);

        presenter.addPerson(person1);
        presenter.addPerson(person2);
        presenter.addDog(dog1);
        presenter.addDog(dog2);
    }
}
