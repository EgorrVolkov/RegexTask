package ua.training;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUserInputEmail extends InputEmail {

    @Test
    public void Success() {
        assertTrue(userInputCorrect("TypicalEmail@mail.com"));
    }

    @Test
    public void FailureLanguage() {
        assertFalse(userInputCorrect("ТипичныйEmail@mail.com"));
    }

    @Test
    public void FailureSpace() {
        assertFalse(userInputCorrect("Typical Email@mail.com"));
    }

    @Test
    public void FailureNoDog() {
        assertFalse(userInputCorrect("TypicalEmailmail.com"));
    }

    @Test
    public void FailureNoDot() {
        assertFalse(userInputCorrect("TypicalEmail@mailcom"));
    }

    @Test
    public void FailureOtherSymbols() {
        assertFalse(userInputCorrect("TypicalEmail@mail..com"));
        assertFalse(userInputCorrect("TypicalEmail@@mail.com"));
        assertFalse(userInputCorrect("TypicalEm=ail@mail.com"));
        assertFalse(userInputCorrect("Typical-Email@mail.com"));
    }

    @Test
    public void FailureNoEmailName() {
        assertFalse(userInputCorrect("@mail.com"));
    }

    @Test
    public void FailureToLittleUpperDomain() {
        assertFalse(userInputCorrect("TypicalEmail@mail.c"));
    }

    @Test
    public void FailureNoDomain() {
        assertFalse(userInputCorrect("TypicalEmail@.com"));
    }
}
