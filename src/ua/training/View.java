package ua.training;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Basic View class in MVC architectural pattern.
 * @author  Egor Volkov
 * @version 1.0
 * @since   2017-11-09
 */

class View {

    /**
     * {@code messagesBundle} used for operating a messages bundle corresponding to current language.
     * new Locale("en") for English, new Locale("ru") for Russian.
     */

    private static final ResourceBundle messagesBundle =
            ResourceBundle.getBundle(Internationalization.MESSAGES_BUNDLE_NAME, new Locale("en"));

    /**
     * Prints message passed.
     * @param message current message to print
     */

    private void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Calls {@link #printMessage(String)} passing current {@link Internationalization} login requesting message.
     */

    void printInputLoginMessage() {
        printMessage(messagesBundle.getString(Internationalization.INPUT_LOGIN_MESSAGE));
    }

    /**
     * Calls {@link #printMessage(String)} passing current {@link Internationalization} name requesting message.
     */

    void printInputNameMessage() {
        printMessage(messagesBundle.getString(Internationalization.INPUT_NAME_MESSAGE));
    }

    /**
     * Calls {@link #printMessage(String)} passing current {@link Internationalization} E-mail requesting message.
     */

    void printInputEmailMessage() {
        printMessage(messagesBundle.getString(Internationalization.INPUT_EMAIL_MESSAGE));
    }

    /**
     * Calls {@link #printMessage(String)} passing current {@link Internationalization} login incorrect message.
     */

    void printOutputLoginIncorrect() {
        printMessage(messagesBundle.getString(Internationalization.OUTPUT_LOGIN_INCORRECT));
    }

    /**
     * Calls {@link #printMessage(String)} passing current {@link Internationalization} name incorrect message.
     */

    void printOutputNameIncorrect() {
        printMessage(messagesBundle.getString(Internationalization.OUTPUT_NAME_INCORRECT));
    }

    /**
     * Calls {@link #printMessage(String)} passing current {@link Internationalization} E-mail incorrect message.
     */

    void printOutputEmailIncorrect() {
        printMessage(messagesBundle.getString(Internationalization.OUTPUT_EMAIL_INCORRECT));
    }
}
