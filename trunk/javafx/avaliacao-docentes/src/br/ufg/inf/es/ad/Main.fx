package br.ufg.inf.es.ad;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

import javafx.scene.text.FontWeight;


import javafx.geometry.HPos;


import javafx.scene.layout.VBox;

import javafx.scene.layout.HBox;
import javafx.scene.control.TextBox;

import javafx.geometry.VPos;

/**
 * Tela principal da aplicação.
 
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
def usuario: Text = Text {
              font : Font.font("SansSerif", FontWeight.BOLD, 16) 
              x: 10, y: 30
              content: "Usuário:"
           };

def usuarioLinha: HBox = HBox {
    spacing: 10
    nodeVPos: VPos.CENTER
    content: [ usuario,
            TextBox {
            text: "SampleText"
            columns: 12
            selectOnFocus: true
    }
    ]
};

def senha: Text = Text {
              font : Font.font("SansSerif", FontWeight.BOLD, 16)
              x: 10, y: 60
              content: "Senha:"
};

def senhaLinha: HBox = HBox {
    spacing: 10
    nodeVPos: VPos.CENTER
    content: [
        senha,
        TextBox {
            text: "SampleText"
            columns: 12
            selectOnFocus: true
        }
    ]
};

Stage {
    title: "Avaliação Docente"
    width: 550
    height: 400
    scene: Scene {
        content: [
                VBox {
                    layoutX: 20
                    layoutY: 20
                    spacing: 15
                    nodeHPos : HPos.RIGHT
                    content: [usuarioLinha, senhaLinha ]
                }
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