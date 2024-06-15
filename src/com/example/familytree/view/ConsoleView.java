package com.example.familytree.view;

import com.example.familytree.model.Dog;
import com.example.familytree.model.Person;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleView implements View {
    private static final Logger logger = Logger.getLogger(ConsoleView.class.getName());

    @Override
    public void displayPeople(List<Person> people) {
        logger.info("People:");
        for (Person person : people) {
            logger.info(person.toString());
        }
    }

    @Override
    public void displayDogs(List<Dog> dogs) {
        logger.info("Dogs:");
        for (Dog dog : dogs) {
            logger.info(dog.toString());
        }
    }

    @Override
    public void displayMessage(String message) {
        logger.info(message);
    }

    @Override
    public void displayError(String errorMessage) {
        logger.log(Level.SEVERE, errorMessage);
    }
}
