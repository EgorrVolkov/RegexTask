package ua.training;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for testing regular expressions.
 * @author  Egor Volkov
 * @version 1.0
 * @since   2017-11-09
 */

public class InputTest {

    private Model model = new Model();
    private View view =  new View();

    /**
     * Tests regular expressions on correct user input.
     * @throws Exception if one of user inputs is incorrect
     */

    @org.junit.Test
    public void simpleRegexTest() throws Exception {
        Controller controller;
        ByteArrayOutputStream outContent;
        try {
            controller = new Controller(model, view);
            controller.scanner = new Scanner("login\nName\nEmail@mail.ru");
            controller.initiateProgram();

            outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            assertEquals("", outContent.toString());
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /**
     * Tests regular expressions on incorrect user input.
     * @throws Exception if user input is incorrect, thus assert
     * fails if user input is considered correct.
     */

    @org.junit.Test
    public void testInputCornerCases() throws Exception {
        //this test will fail, because input is correct:
        //testInputFails("login\nName\nEmail@mail.ru");

        // login less then 3 symbols:
        testInputFails("lo\nName\nEmail@mail.ru");
        // login extraneous symbols:
        testInputFails("login=\nName\nEmail@mail.ru");
        testInputFails("log in\nName\nEmail@mail.ru");
        testInputFails("l+ogin\nName\nEmail@mail.ru");
        testInputFails("login*\nName\nEmail@mail.ru");
        // login other language
        testInputFails("логин\nName\nEmail@mail.ru");

        // name less then 2 symbols:
        testInputFails("login\nN\nEmail@mail.ru");
        // name first letter downcase:
        testInputFails("login\nname\nEmail@mail.ru");
        // name all uppercase:
        testInputFails("login\nNAAAAME\nEmail@mail.ru");
        // name extraneous symbols:
        testInputFails("login\nNa=me\nEmail@mail.ru");
        testInputFails("login\nN_ame\nEmail@mail.ru");
        testInputFails("login\nName surname\nEmail@mail.ru");
        // name other language:
        testInputFails("login\nМоёимя\nEmail@mail.ru");
        // name more than one uppercase letter:
        testInputFails("login\nNaMe\nEmail@mail.ru");

        // email no "@" sign
        testInputFails("login\nName\nEmailmail.ru");
        // email no dot sign
        testInputFails("login\nName\nEmail@mailru");
        // email top-level domain less then 2 symbols:
        testInputFails("login\nName\nEmail@mail.r");
        // email top-level domain more then 6 symbols:
        testInputFails("login\nName\nEmail@mail.rururur");
        // email extraneous symbols:
        testInputFails("login\nName\nЯмейл@mail.ru");
        testInputFails("login\nName\nEmail@mail.ру");
        testInputFails("login\nName\nEmail@мейл.ru");
        testInputFails("login\nName\nEmРусскийТекстil@mail.ru");
        testInputFails("login\nName\nEm.ail@mail.ru");
        testInputFails("login\nName\nEm ail@mail.ru");
        testInputFails("login\nName\nEma+il@mail.ru");
        testInputFails("login\nName\nEmail@@mail.ru");
        testInputFails("login\nName\nEma=il@mail.ru");
        testInputFails("login\nName\nEmail@mail..ru");
    }

    /**
     * Conducts the testing itself, checks whether expected exception
     * will be thrown or not.
     * @param userInput represents simulation of user input
     */

    private void testInputFails(String userInput) {
        Controller controller;
        try {
            controller = new Controller(model, view);
            controller.scanner = new Scanner(userInput);
            controller.initiateProgram();

            fail();
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }
}