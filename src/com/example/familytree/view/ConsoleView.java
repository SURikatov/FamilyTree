package com.example.familytree.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.familytree.model.Gender;
import com.example.familytree.model.Person;

public class ConsoleView implements View {
    private static final Logger logger = Logger.getLogger(ConsoleView.class.getName());
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayPeople(List<Person> people) {
        logger.info("Люди:");
        for (Person person : people) {
            logger.info(person.toString());
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

    @Override
    public String getInput(String prompt) {
        logger.info(prompt);
        return scanner.nextLine();
    }

    @Override
    public Person getPersonDetails() {
        logger.info("Введите ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        logger.info("Введите имя: ");
        String name = scanner.nextLine();

        logger.info("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());

        logger.info("Введите дату рождения (гггг-мм-дд): ");
        String birthdate = scanner.nextLine();

        logger.info("Введите пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        return new Person(id, name, age, LocalDate.parse(birthdate), null, true, gender);
    }
}
