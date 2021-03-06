package com.db.library.Repositories;

import java.util.List;

import com.db.library.Entities.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title LIKE %?1%")
    public List<Book> findByTitle(String title);
}

