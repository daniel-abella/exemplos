package g8;

import javafx.ext.swing.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

def tg = SwingToggleGroup {}

var nos = for (cor in ["RED", "GREEN", "BLUE"]) {
    SwingRadioButton {
        id: "{indexof cor}"
        text: cor toggleGroup: tg selected: true
    }
}

var box = Rectangle { width: 100 height: 70
    fill: bind change(tg.getSelection())
}

function change(botao:SwingToggleButton) {
    if (botao == null) return Color.RED;
    var id = Integer.valueOf(botao.id);
    [ Color.RED, Color.GREEN, Color.BLUE ][id]
}

def cena = Scene { fill: Color.rgb(238, 238, 238)
    content: HBox { content: [ VBox { content: nos }, box ] }
}

Stage { title: "Cores" width: 165 scene: cena }