package com.db.library.Repositories;

import java.util.List;

import com.db.library.Entities.Magazine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {
    @Query("SELECT m FROM Magazine m WHERE m.title LIKE %?1%")
    public List<Magazine> findByTitle(String title);
}

