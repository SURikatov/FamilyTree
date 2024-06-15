package com.example.familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient Map<Integer, T> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(int id, T member) {
        members.put(id, member);
    }

    public T getMember(int id) {
        return members.get(id);
    }

    public Collection<T> getAllMembers() {
        return members.values();
    }

    public Map<Integer, T> getMembers() {
        return members;
    }

    public void setMembers(Map<Integer, T> members) {
        this.members = members;
    }

    public List<T> sortByNames() {
        List<T> sortedList = new ArrayList<>(members.values());
        if (!sortedList.isEmpty() && sortedList.get(0) instanceof Nameable) {
            sortedList.sort(Comparator.comparing(o -> ((Nameable) o).getName()));
        }
        return sortedList;
    }

    public List<T> sortByIds() {
        List<T> sortedList = new ArrayList<>(members.values());
        if (!sortedList.isEmpty() && sortedList.get(0) instanceof Identifiable) {
            sortedList.sort(Comparator.comparing(o -> ((Identifiable) o).getId()));
        }
        return sortedList;
    }

    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        for (T member : members.values()) {
            if (member instanceof Person) {
                people.add((Person) member);
            }
        }
        return people;
    }

    public List<Dog> getDogs() {
        List<Dog> dogs = new ArrayList<>();
        for (T member : members.values()) {
            if (member instanceof Dog) {
                dogs.add((Dog) member);
            }
        }
        return dogs;
    }

    public List<Person> getLivingPeople() {
        List<Person> livingPeople = new ArrayList<>();
        for (T member : members.values()) {
            if (member instanceof Person) {
                Person person = (Person) member;
                if (person.isAlive()) {
                    livingPeople.add(person);
                }
            }
        }
        return livingPeople;
    }

    public List<Dog> getLivingDogs() {
        List<Dog> livingDogs = new ArrayList<>();
        for (T member : members.values()) {
            if (member instanceof Dog) {
                Dog dog = (Dog) member;
                if (dog.isAlive()) {
                    livingDogs.add(dog);
                }
            }
        }
        return livingDogs;
    }

    public List<Person> getPeopleByBirthdate(LocalDate birthdate) {
        List<Person> peopleByBirthdate = new ArrayList<>();
        for (T member : members.values()) {
            if (member instanceof Person) {
                Person person = (Person) member;
                if (person.getBirthdate() != null && person.getBirthdate().equals(birthdate)) {
                    peopleByBirthdate.add(person);
                }
            }
        }
        return peopleByBirthdate;
    }

    public List<Dog> getDogsByBirthdate(LocalDate birthdate) {
        List<Dog> dogsByBirthdate = new ArrayList<>();
        for (T member : members.values()) {
            if (member instanceof Dog) {
                Dog dog = (Dog) member;
                if (dog.getBirthdate() != null && dog.getBirthdate().equals(birthdate)) {
                    dogsByBirthdate.add(dog);
                }
            }
        }
        return dogsByBirthdate;
    }

    public List<Person> getPeopleByDeathDate(LocalDate deathDate) {
        List<Person> peopleByDeathDate = new ArrayList<>();
        for (T member : members.values()) {
            if (member instanceof Person) {
                Person person = (Person) member;
                if (person.getDeathDate() != null && person.getDeathDate().equals(deathDate)) {
                    peopleByDeathDate.add(person);
                }
            }
        }
        return peopleByDeathDate;
    }

    public List<Dog> getDogsByDeathDate(LocalDate deathDate) {
        List<Dog> dogsByDeathDate = new ArrayList<>();
        for (T member : members.values()) {
            if (member instanceof Dog) {
                Dog dog = (Dog) member;
                if (dog.getDeathDate() != null && dog.getDeathDate().equals(deathDate)) {
                    dogsByDeathDate.add(dog);
                }
            }
        }
        return dogsByDeathDate;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "members=" + members +
                '}';
    }
}
