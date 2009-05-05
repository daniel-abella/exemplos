package jfx1;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/*  Toda interface possui um Stage.
    Elemento mais externo.
*/
Stage {
    title: "Título da Aplicação (janela)"
    width: 250 
    height: 80
    scene: Scene {
        content: Text {
            font : Font {
                size : 16
            }
            x: 10, y: 30
            content: "Meu primeiro teste"
        }
    }
}