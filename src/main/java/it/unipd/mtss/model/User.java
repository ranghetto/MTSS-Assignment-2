////////////////////////////////////////////////////////////////////
// Matteo Rango 2008066
// Antonio Oseliero 1226325
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

public class User {
    private final int id;
    private final int age;
    private final String name;
    private final String surname;

    public User(int id, int age, String name, String surname) {
        if(id < 0) throw new IllegalArgumentException(
                "Cannot use negative value for 'id'");
        if(age < 0) throw new IllegalArgumentException(
                "Cannot use negative value for 'eta'");
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}
