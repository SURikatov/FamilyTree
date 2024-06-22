package com.example.familytree;

import com.example.familytree.model.Gender;
import com.example.familytree.model.Person;
import com.example.familytree.presenter.FamilyTreePresenter;
import com.example.familytree.service.FamilyTreeService;
import com.example.familytree.view.ConsoleView;
import com.example.familytree.view.View;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        FamilyTreeService service = new FamilyTreeService();
        View view = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);

        addInitialData(presenter);

        presenter.loadPeople();
        service.saveFamilyTreeToFile();
    }

    private static void addInitialData(FamilyTreePresenter presenter) {
        LocalDate birthdatePerson1 = LocalDate.of(1990, 1, 1);
        LocalDate birthdatePerson2 = LocalDate.of(1995, 6, 15);

        Person person1 = new Person(1, "Света", 30, birthdatePerson1, null, true, Gender.FEMALE);
        Person person2 = new Person(2, "Федор", 25, birthdatePerson2, null, true, Gender.MALE);

        presenter.addPerson(person1);
        presenter.addPerson(person2);
    }
}
