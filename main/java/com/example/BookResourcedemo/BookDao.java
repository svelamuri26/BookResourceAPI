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

    public void addBook(Book book) {
         String sql = "INSERT INTO Books (id, title, author) VALUES (?, ?, ?)";
         jdbcTemplate.update(sql, book.getTitle(), book.getAuthor());
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


}

