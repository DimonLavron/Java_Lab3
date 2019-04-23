package ua.lviv.iot.bank.models;

import javax.persistence.Embeddable;

@Embeddable
public class Person {
    private String firstName;
    private String surname;

    public Person() {
    }

    public Person(final String firstName, final String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final String getSurname() {
        return surname;
    }

    public final void setSurname(final String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return firstName + " " + surname;
    }
}
