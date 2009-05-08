package g6;

import javafx.ext.swing.SwingButton;
import javafx.ext.swing.SwingIcon;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.stage.Stage;

Stage {
    title: "Application title"
    width: 250
    height: 80
    scene: Scene {
        content: SwingButton {
            text: "Fim"
            icon: SwingIcon { image: Image { url: "{__DIR__}fim.png" } }
        }
    }
}