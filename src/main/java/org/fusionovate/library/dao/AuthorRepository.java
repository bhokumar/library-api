package org.fusionovate.library.dao;

import org.fusionovate.library.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class AuthorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Author addAuthor(Author author) {

        try {
            GeneratedKeyHolder holder = new GeneratedKeyHolder();
            int affectedRows = jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO Author (name, email, birthdate) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, author.getName());
                    ps.setString(2, author.getEmail());
                    ps.setDate(3, java.sql.Date.valueOf(author.getDob()));
                    return ps;
                }
            }, holder);

            if (affectedRows == 0) {
                throw new SQLException("Creating author failed, no rows affected.");
            }

            author.setId(holder.getKey().intValue());
            return author;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return author;
    }

    public Author getAuthor(int authorId) {
        return jdbcTemplate.queryForObject("SELECT * FROM Author WHERE id = ?", new Object[]{authorId}, (rs, rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("name"));
            author.setEmail(rs.getString("email"));
            author.setDob(rs.getDate("birthdate").toLocalDate());
            return author;
        });
    }
}
