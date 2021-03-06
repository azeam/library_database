package com.db.library.Services;

import java.util.List;

import com.db.library.Entities.Book;
import com.db.library.Repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;
     
    public List<Book> listAll(String keyword) {
        if (keyword != null) {
            return repo.findByTitle(keyword);
        }
        return repo.findAll();
    }
}
