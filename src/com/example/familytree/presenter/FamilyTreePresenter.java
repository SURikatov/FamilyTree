package com.example.familytree.presenter;

import java.util.List;

import com.example.familytree.model.Person;
import com.example.familytree.service.FamilyTreeService;
import com.example.familytree.view.View;

public class FamilyTreePresenter implements Presenter {
    private FamilyTreeService service;
    private View view;

    public FamilyTreePresenter(FamilyTreeService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void loadPeople() {
        List<Person> people = service.getPeople();
        view.displayPeople(people);
    }

    @Override
    public void addPerson(Person person) {
        service.addPerson(person);
        view.displayMessage("Человек добавлен: " + person.getName());
    }
}
