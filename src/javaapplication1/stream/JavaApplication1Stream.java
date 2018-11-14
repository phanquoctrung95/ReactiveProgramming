/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;
import static java.util.stream.Collectors.toList;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author cpu10955
 */
public class JavaApplication1Stream {

    private static JavaApplication1Stream instance = new JavaApplication1Stream();

    public static JavaApplication1Stream getInstance() {
        return instance;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        int lengthSur = 10;
        int lengthLast = 5;
        boolean useLetters = true;
        boolean useNumbers = false;
        for (int i = 0; i < 10; i++) {
            String surname = RandomStringUtils.random(lengthSur, useLetters, useNumbers);
            String lstname = RandomStringUtils.random(lengthLast, useLetters, useNumbers);
            String name = RandomStringUtils.random(15, useLetters, useNumbers);
            Author author = new Author(surname, lstname, 48 + i, "female");
            listBook.add(new Book(name, author));
        }
        System.out.println(JavaApplication1Stream.getInstance().getSumFemaleAuthorLessThan25(listBook));
        System.out.println(JavaApplication1Stream.getInstance().getNameAuthorGreaterThan50(listBook));

    }

    public int getSumFemaleAuthorLessThan25(List<Book> listBook) {
        return listBook.stream()
                .map(book -> book.getAuthor())
                .filter(author -> author.getAge() < 25 & "female".equals(author.getGender()))
                .map(Author::getAge)
                .reduce(0, Integer::sum);
    }

    public List<String> getNameAuthorGreaterThan50(List<Book> listBook) {
        return listBook.stream()
                .map(book -> book.getAuthor())
                .filter(author -> author.getAge() > 50)
                .map(Author::getFullName)
                .distinct()
                .map(String::toUpperCase)
                .collect(toList());
    }

}
