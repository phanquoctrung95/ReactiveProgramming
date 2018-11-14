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
public class Book {

    private String name;
    private Author author;

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

}
