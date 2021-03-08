package com.db.library.Repositories;

import java.util.List;
import java.util.Optional;

import com.db.library.Entities.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title LIKE %?1%")
    public List<Book> findByTitle(String title);

    @Query("SELECT b FROM Book b JOIN Borrows c ON b.id = c.book JOIN User u ON c.borrower = u")
    public List<Book> findBorrowedBooks();

    @Query("SELECT b FROM Book b WHERE b.id = ?1")
    public Optional<Book> findById(Long id);
}

