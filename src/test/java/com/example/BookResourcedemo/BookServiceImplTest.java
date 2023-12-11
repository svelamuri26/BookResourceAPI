package com.example.BookResourcedemo;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceImplTest {

    @Mock
    private BookDao bookDao;

    private BookService bookService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookServiceImpl(bookDao);
    }

    @Test
    void testGetAllBooks() {

        List<Book> mockBooks = new ArrayList<>();
        when(bookDao.getAllBooks()).thenReturn(mockBooks);


        List<Book> result = bookService.getAllBooks();


        verify(bookDao, times(1)).getAllBooks();


        assertEquals(mockBooks, result);
    }
}