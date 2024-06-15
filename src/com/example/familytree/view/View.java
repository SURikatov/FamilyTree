package com.example.familytree.view;

import com.example.familytree.model.Dog;
import com.example.familytree.model.Person;

import java.util.List;

public interface View {
    void displayPeople(List<Person> people);
    void displayDogs(List<Dog> dogs);
    void displayMessage(String message);
    void displayError(String errorMessage);
}
