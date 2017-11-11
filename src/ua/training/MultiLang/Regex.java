package ua.training.MultiLang;

import java.util.Locale;
import java.util.ResourceBundle;

public interface Regex {

    String REGEXP_BUNDLE_NAME = "regExp";

    /**
     * {@code regExpBundle} used for operating a regExp bundle corresponding to current language.
     * new Locale("en") for English, new Locale("ru") for Russian.
     */

    ResourceBundle regExpBundle =
            ResourceBundle.getBundle(REGEXP_BUNDLE_NAME, new Locale("en"));

    String REGEXP_LOGIN = "regexp.login";
    String REGEXP_NAME = "regexp.name";
    String REGEXP_EMAIL = "regexp.email";
}
