package com.db.library.Repositories;

import com.db.library.Entities.Borrows;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowsRepository extends JpaRepository<Borrows, Long> {
    // only using default operations
}
