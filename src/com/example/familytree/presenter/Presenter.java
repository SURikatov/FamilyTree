package com.example.familytree.presenter;

import com.example.familytree.model.Person;

public interface Presenter {
    void loadPeople();
    void addPerson(Person person);
}
