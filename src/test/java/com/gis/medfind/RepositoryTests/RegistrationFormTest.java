package com.gis.medfind.RepositoryTests;

import com.gis.medfind.Forms.RegistrationForm;
import com.gis.medfind.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RegistrationFormTest {
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private RegistrationForm user;
     
     
    @Test
    public void testCreateUser() {
        user.setEmail("kkmichaelkk@gmail.com");
        user.setPassword("@michael0958267");
        user.setFirstName("Kaleab");
        user.setLastName("Kindu");
        
      //  User savedUser = user.toUser(passwordEncoder);
        
      //  User existUser = entityManager.find(User.class, savedUser.getId());
        
       // assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
        
    }
}
