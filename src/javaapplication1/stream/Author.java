/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.stream;

/**
 *
 * @author cpu10955
 */
public class Author {

    private String surname;
    private String lastname;
    private int age;
    private String gender;

    public Author(String surname, String lastname, int age, String gender) {
        this.surname = surname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return lastname + " " + surname;
    }

    public String getFullName() {
        return lastname + " " + surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

}
