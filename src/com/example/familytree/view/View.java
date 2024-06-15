package com.example.familytree.view;

import java.util.List;

import com.example.familytree.model.Dog;
import com.example.familytree.model.Person;

public interface View {
    void displayPeople(List<Person> people);
    void displayDogs(List<Dog> dogs);
    void displayMessage(String message);
    void displayError(String errorMessage);
}
