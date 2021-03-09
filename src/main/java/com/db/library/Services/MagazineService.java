package com.db.library.Services;

import java.util.List;

import com.db.library.Entities.Magazine;
import com.db.library.Repositories.MagazineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MagazineService {
    @Autowired
    private MagazineRepository repo;
     
    // search if keyword is set, otherwise show all magazines
    public List<Magazine> listAll(String keywordMag) {
        if (keywordMag != null) {
            return repo.findByTitle(keywordMag);
        }
        return repo.findAll();
    }
}
