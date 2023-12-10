package com.example.BookResourcedemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final List<Book> books = new ArrayList<>();
    private Long nextId = 1L;
    private final BookDao bookDao;

    @PostConstruct
    public void init() {

        System.out.println("Bean initialized");
    }

    @PreDestroy
    public void destroy() {

        System.out.println("Bean destroyed");
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public Book getBookById(Long id) {
        Optional<Book> foundBook = books.stream().filter(book -> book.getId().equals(id)).findFirst();
        return foundBook.orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                break;
            }
        }
        return updatedBook;
    }

    @Override
    public boolean deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
        return false;
    }

    @Override
    public String getBooks() {
        return "books";
    }
}
