package br.ufg.inf.es.ad;

import javafx.scene.control.TextBox;
import javafx.util.Math;

/**
 * Obtido da internet com a permissão do autor em
 * http://blog.alutam.com/2009/09/12/javafx-password-field/
 * @author Martin Matula
 */
public class PasswordBox extends TextBox {
    public-read var password = "";

    override function replaceSelection(arg) {
        var pos1 = Math.min(dot, mark);
        var pos2 = Math.max(dot, mark);
        password = "{password.substring(0, pos1)}{arg}{password.substring(pos2)}";
        super.replaceSelection(getStars(arg.length()));
    }

    override function deleteNextChar() {
        if ((mark == dot) and (dot < password.length())) {
            password = "{password.substring(0, dot)}{password.substring(dot + 1)}";
        }
        super.deleteNextChar();
    }

    override function deletePreviousChar() {
        if ((mark == dot) and (dot > 0)) {
            password = "{password.substring(0, dot - 1)}{password.substring(dot)}";
        }
        super.deletePreviousChar();
    }

    function getStars(len: Integer): String {
        var result: String = "";
        for (i in [1..len]) {
            result = "{result}*";
        }
        result;
    }
}
