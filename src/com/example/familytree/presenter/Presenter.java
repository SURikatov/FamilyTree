package com.example.familytree.presenter;

import com.example.familytree.model.Dog;
import com.example.familytree.model.Person;

public interface Presenter {
    void loadPeople();
    void loadDogs();
    void addPerson(Person person);
    void addDog(Dog dog);
}
