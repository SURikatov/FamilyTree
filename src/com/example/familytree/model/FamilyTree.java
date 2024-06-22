package com.example.familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree<T extends Person> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<Integer, T> members;

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
        sortedList.sort(Comparator.comparing(Person::getName));
        return sortedList;
    }

    public List<T> sortByIds() {
        List<T> sortedList = new ArrayList<>(members.values());
        sortedList.sort(Comparator.comparing(Person::getId));
        return sortedList;
    }

    public List<Person> getPeople() {
        return new ArrayList<>(members.values());
    }

    public List<Person> getLivingPeople() {
        List<Person> livingPeople = new ArrayList<>();
        for (T member : members.values()) {
            if (member.isAlive()) {
                livingPeople.add(member);
            }
        }
        return livingPeople;
    }

    public List<Person> getPeopleByBirthdate(LocalDate birthdate) {
        List<Person> peopleByBirthdate = new ArrayList<>();
        for (T member : members.values()) {
            if (member.getBirthdate() != null && member.getBirthdate().equals(birthdate)) {
                peopleByBirthdate.add(member);
            }
        }
        return peopleByBirthdate;
    }

    public List<Person> getPeopleByDeathDate(LocalDate deathDate) {
        List<Person> peopleByDeathDate = new ArrayList<>();
        for (T member : members.values()) {
            if (member.getDeathDate() != null && member.getDeathDate().equals(deathDate)) {
                peopleByDeathDate.add(member);
            }
        }
        return peopleByDeathDate;
    }
}
