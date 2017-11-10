package ua.training;

/**
 * <h1>RegEx Program</h1>
 * The RegexTask program implements an application that
 * requests user to input login, name and E-mail address,
 * checks it for correctness, and if all input is correct,
 * passes input to model class.
 *
 * @author  Egor Volkov
 * @version 1.0
 * @since   2017-11-09
 */

public class Main {

    /**
     * The main method which initializes all basic program components.
     * @param args Unused.
     */

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.initiateProgram();
    }
}
