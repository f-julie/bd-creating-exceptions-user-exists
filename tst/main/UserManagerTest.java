package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class UserManagerTest {

    @Test
    public void createUser_withUnusedEmail_createsUserSuccessfully() {
        // GIVEN
        User user = new User("Richard Roe", "rroe@example.com", 5550100);
        UserManager manager = spy(UserManager.class);
        when(manager.isEmailInUse(user.getEmail())).thenReturn(false);

        try {
            // WHEN + THEN
            manager.createUser(user);
        } catch (Exception e) {
            fail("Expected nothing to be thrown, but exception was thrown with message: " + e.getMessage());
        }
    }

    @Test
    public void createUser_withEmailInUse_throwsUserExistsException() {
        // GIVEN
        User user = new User("Richard Roe", "rroe@example.com", 5550100);
        UserManager manager = spy(UserManager.class);
        when(manager.isEmailInUse(user.getEmail())).thenReturn(true);

        // WHEN + THEN
        assertThrows(UserExistsException.class, () -> manager.createUser(user));
    }

}
