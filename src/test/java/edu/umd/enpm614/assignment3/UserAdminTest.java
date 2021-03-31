package edu.umd.enpm614.assignment3;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    void testCreateUser() throws SQLException {

        new Expectations() {{
            dbConnection.userExists(anyString);
            times=2;
            returns(true, false);
            result = new SQLException();
        }};

        assertFalse(userAdmin.createUser("someone", "something"));
        assertTrue(userAdmin.createUser("someone", "something"));
        assertFalse(userAdmin.createUser("someone", "something"));

    }

    @Test
    void testRemoveUser() throws SQLException {

        new Expectations() {{
            dbConnection.userExists(anyString);
            times=4;
            returns(false,true, true);
            result = new SQLException();

            dbConnection.isAdmin(anyString);
            times=2;
            returns(true, false);
        }};

        assertFalse(userAdmin.removeUser("someone"));
        assertFalse(userAdmin.removeUser("someone"));
        assertTrue(userAdmin.removeUser("someone"));
        assertFalse(userAdmin.removeUser("someone"));

    }

    @Test
    void testRunUserReport() throws SQLException{

        new Expectations() {{
            List<User> user = new ArrayList<User>();

            List<User> user2 = new ArrayList<User>();
            User a = new User("a", "a");
            User b = new User("b", "b");
            User c = new User("c", "c");
            user2.add(a);
            user2.add(b);
            user2.add(c);

            List<User> user3 = new ArrayList<User>();
            User d = new User("d", "d");
            User e = new User("e", "e");
            User f = new User("f", "f");
            User g = new User("g", "g");
            User h = new User("h", "h");
            User i = new User("i", "i");
            User j = new User("j", "j");
            User k = new User("k", "k");
            User l = new User("l", "l");
            user3.add(a);
            user3.add(b);
            user3.add(c);
            user3.add(d);
            user3.add(e);
            user3.add(f);
            user3.add(g);
            user3.add(h);
            user3.add(i);
            user3.add(j);
            user3.add(k);
            user3.add(l);

            dbConnection.getUsers();
            times=4;
            returns(user, user2, user3 );
            result = new SQLException();

        }};

        userAdmin.runUserReport();
        userAdmin.runUserReport();
        userAdmin.runUserReport();
        userAdmin.runUserReport();

    }
}