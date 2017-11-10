package ua.training;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Basic Controller class in MVC architectural pattern.
 * @author  Egor Volkov
 * @version 1.0
 * @since   2017-11-09
 */

class Controller {

    /**
     * An abstract class that is used as general class for other
     * classes to extend from.
     */

    abstract class Input {
        private String key;

        /**
         * Constructor that is used by child classes to obtain personal key value.
         * @param key represents certain value from regExp.properties
         */

        Input(String key) {
            this.key = key;
        }

        /**
         * Prints a sequence of messages for a case of incorrect user input.
         * @param view current View instance
         */

        abstract void printIncorrect(View view);

        /**
         * Prints a message requesting a user input.
         * @param view current View instance
         */

        abstract void printInputRequest(View view);

        /**
         * Updates corresponding {@code model} field value.
         * {@code userInput} passed.
         * @param model current Model instance
         * @param userInput user input value
         */

        abstract void updateModel(Model model, String userInput);

        /**
         * This is a getter for a key variable.
         * @return the key.
         */

        public String getKey() {
            return key;
        }

        /**
         * Processes user input. Prints current input request message, gets input
         * from user, updates corresponding {@code model} field.
         * @param model current Model instance
         * @param view current View instance
         * @param scanner current Scanner used for obtaining {@code userInput}
         */

        public void processUserInput(Model model, View view, Scanner scanner) {
            printInputRequest(view);
            String userInput = getCorrectInput(scanner);
            updateModel(model, userInput);
        }

        /**
         * Calls a check of user input on correctness. Repeats input request message until
         * user inputs a correct value for certain field.
         * @param scanner current Scanner used for obtaining {@code userInput}
         * @return {@code String} of user input, ready to be passed to corresponding {@code model} field
         */

        private String getCorrectInput(Scanner scanner) {
            String userInput;
            while(true) {
                userInput = scanner.nextLine();
                if (userInputCorrect(userInput))
                    break;
                else {
                    printIncorrect(view);
                }
            }
            return userInput;
        }

        /**
         * Checks user input for correctness, returns corresponding {@code boolean} value.
         * @param userInput Current string of user input
         * @return Boolean value, representing if user input is correct
         */

        private boolean userInputCorrect(String userInput) {
            final Pattern pattern =
                    Pattern.compile(regExpBundle.getString(getKey()));
            return pattern.matcher(userInput).matches();
        }
    }

    /**
     *  Class for working with user input of login.
     */

    class InputLogin extends Input {

        /**
         * Constructing via superclass, using current regExp value
         */

        InputLogin() {
            super(Internationalization.REGEXP_LOGIN);
        }

        /**
         * {@inheritDoc}
         * @param view current View instance
         */

        @Override
        void printIncorrect(View view) {
            view.printOutputLoginIncorrect();
            view.printInputLoginMessage();
        }

        /**
         * {@inheritDoc}
         * @param view current View instance
         */

        @Override
        void printInputRequest(View view) {
            view.printInputLoginMessage();
        }

        /**
         * {@inheritDoc}
         * @param model current Model instance
         * @param userInput user input value
         */

        @Override
        void updateModel(Model model, String userInput) {
            model.setLogin(userInput);
        }
    }

    /**
     *  Class for working with user input of name.
     */

    class InputName extends Input {

        /**
         * Constructing via superclass, using current regExp value
         */

        InputName() {
            super(Internationalization.REGEXP_NAME);
        }

        /**
         * {@inheritDoc}
         * @param view current View instance
         */

        @Override
        void printIncorrect(View view) {
            view.printOutputNameIncorrect();
            view.printInputNameMessage();
        }

        /**
         * {@inheritDoc}
         * @param view current View instance
         */

        @Override
        void printInputRequest(View view) {
            view.printInputNameMessage();
        }

        /**
         * {@inheritDoc}
         * @param model current Model instance
         * @param userInput user input value
         */

        @Override
        void updateModel(Model model, String userInput) {
            model.setName(userInput);
        }
    }

    /**
     *  Class for working with user input of E-mail.
     */

    class InputEmail extends Input {

        /**
         * Constructing via superclass, using current regExp value
         */

        InputEmail() {
            super(Internationalization.REGEXP_EMAIL);
        }

        /**
         * {@inheritDoc}
         * @param view current View instance
         */

        @Override
        void printIncorrect(View view) {
            view.printOutputEmailIncorrect();
            view.printInputEmailMessage();
        }

        /**
         * {@inheritDoc}
         * @param view current View instance
         */


        @Override
        void printInputRequest(View view) {
            view.printInputEmailMessage();
        }

        /**
         * {@inheritDoc}
         * @param model current Model instance
         * @param userInput user input value
         */

        @Override
        void updateModel(Model model, String userInput) {
            model.setEmail(userInput);
        }
    }

    /**
     * {@code regExpBundle} used for operating a regExp bundle corresponding to current language.
     * new Locale("en") for English, new Locale("ru") for Russian.
     */

    private static final ResourceBundle regExpBundle =
            ResourceBundle.getBundle(Internationalization.REGEXP_BUNDLE_NAME, new Locale("en"));

    private Model model;
    private View view;
    Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param model current {@code model} to work with
     * @param view current {@code view} to work with
     */

    Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     * Starting point for this file, creates an array holding class instances, that
     * represent corresponding user input. Loops over this array and calls processUserInput
     * that works next with each user input required.
     */

    void initiateProgram() {
        Input[] inputs = {new InputLogin(), new InputName(), new InputEmail()};

        for(Input inp: inputs)
            inp.processUserInput(model, view, scanner);
    }
}