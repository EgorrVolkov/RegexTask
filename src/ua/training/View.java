package ua.training;

import static ua.training.MultiLang.Messages.*;

/**
 * Basic View class in MVC architectural pattern.
 * @author  Egor Volkov
 * @version 1.0
 * @since   2017-11-09
 */

class View {

    /**
     * Prints message passed.
     * @param message current message to print
     */

    private void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Calls {@link #printMessage(String)} passing current login requesting message.
     */

    void printInputLoginMessage() {
        printMessage(messagesBundle.getString(INPUT_LOGIN_MESSAGE));
    }

    /**
     * Calls {@link #printMessage(String)} passing current name requesting message.
     */

    void printInputNameMessage() {
        printMessage(messagesBundle.getString(INPUT_NAME_MESSAGE));
    }

    /**
     * Calls {@link #printMessage(String)} passing current E-mail requesting message.
     */

    void printInputEmailMessage() {
        printMessage(messagesBundle.getString(INPUT_EMAIL_MESSAGE));
    }

    /**
     * Calls {@link #printMessage(String)} passing current login incorrect message.
     */

    void printOutputLoginIncorrect() {
        printMessage(messagesBundle.getString(OUTPUT_LOGIN_INCORRECT));
    }

    /**
     * Calls {@link #printMessage(String)} passing current name incorrect message.
     */

    void printOutputNameIncorrect() {
        printMessage(messagesBundle.getString(OUTPUT_NAME_INCORRECT));
    }

    /**
     * Calls {@link #printMessage(String)} passing current E-mail incorrect message.
     */

    void printOutputEmailIncorrect() {
        printMessage(messagesBundle.getString(OUTPUT_EMAIL_INCORRECT));
    }
}
