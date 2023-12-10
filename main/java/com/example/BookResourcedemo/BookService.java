package com.example.BookResourcedemo;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);
    Book addBook(Book book);
    Book updateBook(Long id, Book book);
    boolean deleteBook(Long id);
    String getBooks();

}
