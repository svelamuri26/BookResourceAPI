package com.example.BookResourcedemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private  BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBookById(Long id) {
        return bookDao.getBookById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        return bookDao.updateBook(id, updatedBook);
    }

    @Override
    public boolean deleteBook(Long id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public String getBooks() {
        return null;
    }


    @PostConstruct
    public void init() {
        System.out.println("Bean initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean destroyed");
    }
}


