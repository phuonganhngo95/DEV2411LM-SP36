package com.devmaster.lesson01.pkg_lambda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Book {
    int id;
    String name;
    float price;

//    Constructor
    public Book(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

//    Output
    public String toString() {
        return "ID: " + id + ", NAME: " + name + ", PRICE: " + price;
    }
}

public class LambdaExpression5 {
    public static void main(String[] args) {
//        Tạo list books
        List<Book> books = new ArrayList<Book>();
//        Add vào list
        books.add(new Book(1, "Lập trình Java", 9.95f));
        books.add(new Book(2, "Java SpringBoot", 19.95f));
        books.add(new Book(3, "PHP Laravel", 12.95f));
        books.add(new Book(4, "NetCore API", 29.95f));
        books.add(new Book(5, "JavaScript", 19.95f));

//        Output list books
        books.stream().forEach(System.out::println);

        //        Filter c1
        Stream<Book> filter = books.stream().filter(b->b.price > 15);
        filter.forEach(System.out::println);

//        Filter c2
        var filterPrice = books.stream().filter(x->x.price > 15);
        filterPrice.forEach(System.out::println);
    }
}
