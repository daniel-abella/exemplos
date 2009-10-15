package br.ufg.inf.es.ad;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;

/**
 * Tela principal da aplicação.
 
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */

Stage {
    title: "Avaliação Docente"
    width: 350
    height: 200
    scene: Scene {
        content: [
        ]
        fill: RadialGradient {
                        centerX: 5
                        centerY: 5
                        focusX: 0.1
                        focusY: 0.1
                        radius: 10
                        stops: [
                                Stop {
                                        color : Color.WHITE
                                        offset: 0.0
                                },
                                Stop {
                                        color : Color.BLUE
                                        offset: 1.0
                                },

                        ]
                }
    }
}