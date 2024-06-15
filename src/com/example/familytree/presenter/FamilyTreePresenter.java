package com.example.familytree.presenter;

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
        view.displayPeople(familyTree.getPeople());
    }

    @Override
    public void loadDogs() {
        view.displayDogs(familyTree.getDogs());
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
