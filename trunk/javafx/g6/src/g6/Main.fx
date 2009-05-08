package g6;

import javafx.ext.swing.SwingButton;
import javafx.ext.swing.SwingIcon;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

def botao = SwingButton {
    text: "Fim"
    icon: SwingIcon { image: Image { url: "{__DIR__}fim.png" } }
    onMouseClicked: function(me:MouseEvent) { FX.exit(); };
};

Stage { scene: Scene { content: botao } }