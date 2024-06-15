package com.example.familytree.presenter;

import java.util.List;

import com.example.familytree.model.Dog;
import com.example.familytree.model.FamilyTree;
import com.example.familytree.model.Person;
import com.example.familytree.view.View;

public class FamilyTreePresenter implements Presenter {
    private FamilyTree<Object> familyTree;
    private View view;

    public FamilyTreePresenter(FamilyTree<Object> familyTree, View view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void loadPeople() {
        List<Person> people = familyTree.getPeople();
        view.displayPeople(people);
    }

    @Override
    public void loadDogs() {
        List<Dog> dogs = familyTree.getDogs();
        view.displayDogs(dogs);
    }

    @Override
    public void addPerson(Person person) {
        familyTree.addMember(person.getId(), person);
        view.displayMessage("Person added: " + person.getName());
    }

    @Override
    public void addDog(Dog dog) {
        familyTree.addMember(dog.getId(), dog);
        view.displayMessage("Dog added: " + dog.getName());
    }
}
