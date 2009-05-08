package g7;

import javafx.ext.swing.SwingCheckBox;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

def check = SwingCheckBox { text: "Acredita em Deus?" };
def msg = Text { y : 34 content: bind "{check.selected}" };

Stage {
    width: 140
    height: 60
    scene: Scene {
        content: [ check, msg ]
    }
}