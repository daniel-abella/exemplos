package g10;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 * @author Fábio Nogueira de Lucena
 */

def telas : Scene[] = for (x in [0..9])
Scene {
        var meuId : Integer = x;
        fill : Color.rgb(80, 200, 20 * x)
        width: 250
        height: 80
        content: [
            Text {
                x: 10
                y: 15
                content: "Conteúdo da Tela: {x}"
            },
            Button {
                translateX : 10
                translateY : 20
                text: "Anterior"
                action: function() {
                        if (meuId == 0)
                            telaCorrenteId = 9
                        else
                            telaCorrenteId--;
                }
            },
            Button {
                translateX : 80
                translateY : 20
                text: "Próxima"
                action: function() {
                        if (meuId == 9)
                            telaCorrenteId = 0
                        else
                            telaCorrenteId++;
                }
            }
       ]
}

var telaCorrenteId : Integer = 0;

Stage {
    title: "Várias cenas (telas)"
    scene: bind telas[telaCorrenteId];
}