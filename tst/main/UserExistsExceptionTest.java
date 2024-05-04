package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserExistsExceptionTest {

    @Test
    public void userExistsException_isCheckedException() {
        // GIVEN + WHEN + THEN
        assertTrue(Exception.class.isAssignableFrom(UserExistsException.class));
    }

    @Test
    public void constructor_withMessage_correctMessageUsed() {
        // GIVEN + WHEN
        UserExistsException userExistsException = new UserExistsException("User1 already exists");

        // THEN
        assertEquals("User1 already exists", userExistsException.getMessage(),
                     "Expecting to return message passed to constructor");
    }

    @Test
    public void constructor_withCause_correctMessageUsed() {
        // GIVEN
        Exception wrap = new Exception("Wrap me");

        // WHEN
        UserExistsException userExistsException = new UserExistsException(wrap);

        // THEN
        assertEquals(wrap.getMessage(), userExistsException.getCause().getMessage(), "Expecting message passed from wrapped exception");
    }

    @Test
    public void constructor_withMessageAndCause_correctMessageUsed() {
        // GIVEN
        Exception wrap = new Exception("Wrap me");

        // WHEN
        UserExistsException userExistsException = new UserExistsException("User2 already exists", wrap);

        // THEN
        assertEquals(wrap.getMessage(), userExistsException.getCause().getMessage(), "Expecting message from wrapped exception");
        assertEquals("User2 already exists", userExistsException.getMessage(),
                     "Expecting to return message passed to constructor");
    }
}
