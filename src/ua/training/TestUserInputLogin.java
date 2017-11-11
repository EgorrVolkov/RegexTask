package ua.training;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class for testing regular expressions.
 * @author  Egor Volkov
 * @version 1.0
 * @since   2017-11-09
 */

public class TestUserInputLogin extends InputLogin {

    @Test
    public void Success() {
        assertTrue(userInputCorrect("TypicalLogin"));
    }

    @Test
    public void SuccessNumbers() {
        assertTrue(userInputCorrect("TypicalLogin1233"));
        assertTrue(userInputCorrect("1T2y3p4i5c6a7l8L9o10g11i12n13"));
    }

    @Test
    public void SuccessSymbol() {
        assertTrue(userInputCorrect("Typical_Login"));
        assertTrue(userInputCorrect("Typical-Login"));
        assertTrue(userInputCorrect("Typical.Login"));
    }

    @Test
    public void FailureSpace() {
        assertFalse(userInputCorrect("Typical Login"));
    }

    @Test
    public void FailureUnacceptableSymbol() {
        assertFalse(userInputCorrect("Typical+Login"));
        assertFalse(userInputCorrect("Typical=Login"));
        assertFalse(userInputCorrect("Typical/Login"));
    }

    @Test
    public void FailureLanguage() {
        assertFalse(userInputCorrect("ТипичныйЛогин"));
    }

    @Test
    public void FailureTooShort() {
        assertFalse(userInputCorrect("Ty"));
    }
}