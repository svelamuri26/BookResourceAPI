package com.example.BookResourcedemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book addBook(Book book) {
         String sql = "INSERT INTO Books (id, title, author) VALUES (?, ?, ?)";
         jdbcTemplate.update(sql, book.getTitle(), book.getAuthor());
        return book;
    }

    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM Books";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Book(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("author")
                )
        );
    }

    public Book getBookById(Long id) {
        return null;
    }

    public Book updateBook(Long id, Book updatedBook) {
        return null;
    }


    public boolean deleteBook(Long id) {
        return false;
    }
}

