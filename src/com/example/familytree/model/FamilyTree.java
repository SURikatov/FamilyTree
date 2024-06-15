package com.example.familytree.model;

import java.io.Serializable;
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

    @Override
    public String toString() {
        return "FamilyTree{" +
                "members=" + members +
                '}';
    }

    public List<T> sortByNames() {
        List<T> sortedList = new ArrayList<>(members.values());
        if (!sortedList.isEmpty() && sortedList.get(0) instanceof Person) {
            sortedList.sort(Comparator.comparing(o -> ((Person) o).getName()));
        } else if (!sortedList.isEmpty() && sortedList.get(0) instanceof Dog) {
            sortedList.sort(Comparator.comparing(o -> ((Dog) o).getName()));
        }
        return sortedList;
    }

    public List<T> sortByIds() {
        List<T> sortedList = new ArrayList<>(members.values());
        if (!sortedList.isEmpty() && sortedList.get(0) instanceof Person) {
            sortedList.sort(Comparator.comparing(o -> ((Person) o).getId()));
        } else if (!sortedList.isEmpty() && sortedList.get(0) instanceof Dog) {
            sortedList.sort(Comparator.comparing(o -> ((Dog) o).getId()));
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
}
