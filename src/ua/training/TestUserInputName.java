package ua.training;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUserInputName extends InputName {

    @Test
    public void Success() {
        assertTrue(userInputCorrect("Typicalname"));
    }

    @Test
    public void FailureSpace() {
        assertFalse(userInputCorrect("Typical name"));
    }

    @Test
    public void FailureLanguage() {
        assertFalse(userInputCorrect("Типичноеимя"));
    }

    @Test
    public void FailureUnacceptableSymbol() {
        assertFalse(userInputCorrect("Typical_name"));
        assertFalse(userInputCorrect("Typical-name"));
        assertFalse(userInputCorrect("Typical.name"));
        assertFalse(userInputCorrect("Typical+name"));
        assertFalse(userInputCorrect("Typical=name"));
        assertFalse(userInputCorrect("Typical/name"));
    }
}