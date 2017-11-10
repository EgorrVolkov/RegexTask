package ua.training;

/**
 * Basic Model class in MVC architectural pattern.
 * @author  Egor Volkov
 * @version 1.0
 * @since   2017-11-09
 */

class Model {
    private String loginInput;
    private String nameInput;
    private String emailInput;

    /**
     * Sets model field {@code loginInput} to user entered value.
     * @param loginInput login entered by user
     */

    void setLogin(String loginInput) {
        this.loginInput = loginInput;
    }

    /**
     * Sets model field {@code nameInput} to user entered value.
     * @param nameInput name entered by user
     */

    void setName(String nameInput) {
        this.nameInput = nameInput;
    }

    /**
     * Sets model field {@code emailInput} to user entered value.
     * @param emailInput E-mail entered by user
     */

    void setEmail(String emailInput) {
        this.emailInput = emailInput;
    }
}
