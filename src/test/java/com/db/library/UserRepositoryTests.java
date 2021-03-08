package com.db.library;

import static org.assertj.core.api.Assertions.assertThat;

import com.db.library.Entities.Admin;
import com.db.library.Repositories.AdminRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private AdminRepository repo;
     
    @Test
    public void testCreateUser() {
        Admin user = new Admin();
        user.setUsername("admin4");
 
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("admin");       
        user.setPassword(encodedPassword);
        user.setAddress("test");
        Admin savedUser = repo.saveAndFlush(user);
        Admin existUser = entityManager.find(Admin.class, savedUser.getId());
        
        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
        
    }
}
