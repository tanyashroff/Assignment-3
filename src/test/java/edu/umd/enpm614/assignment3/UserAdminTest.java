package edu.umd.enpm614.assignment3;

import mockit.Mocked;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserAdminTest {
    UserAdmin userAdmin;

    @Mocked
    DBConnection dbConnection;

    @BeforeEach
    public void setUp() {
        userAdmin = new UserAdmin(dbConnection);
    }

    @AfterEach
    public void tearDown() {
        userAdmin = null;
    }

    @Test
    void createUser() {
        userAdmin.createUser("something", "something");
    }

    @Test
    void removeUser() {
    }

    @Test
    void runUserReport() {
    }
}