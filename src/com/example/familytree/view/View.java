package com.example.familytree.view;

import java.util.List;

import com.example.familytree.model.Person;

public interface View {
    void displayPeople(List<Person> people);
    void displayMessage(String message);
    void displayError(String errorMessage);
    String getInput(String prompt);
    Person getPersonDetails();
}
