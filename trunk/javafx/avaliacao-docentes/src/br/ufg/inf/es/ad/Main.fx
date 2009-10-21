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
import javafx.scene.control.Button;

import javafx.stage.Alert;

import javafx.scene.control.Label;

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

def txbUsuario: TextBox = TextBox {
    columns: 12
    selectOnFocus: true
};

def usuarioLinha: HBox = HBox {
    spacing: 10
    nodeVPos: VPos.CENTER
    content: [ usuario, txbUsuario ]
};

def senha: Text = Text {
              font : Font.font("SansSerif", FontWeight.BOLD, 16)
              x: 10, y: 60
              content: "Senha:"
};

def password : PasswordBox = PasswordBox {
    columns: 12
    selectOnFocus: true
};


def senhaLinha: HBox = HBox {
    spacing: 10
    nodeVPos: VPos.CENTER
    content: [ senha, password ]
};

def loginButton: Button = Button {
    layoutY: 15
    text: "Entrar"
    action: function() {
        var str = "Usuário: {txbUsuario.text} Senha: {password.password}";
        var ok:Boolean = Alert.confirm(str);
        if (ok) {
            cena = leitura;
        }
    }
}

var login:Scene = Scene {
    content: [
        VBox {
            layoutX: 20
            layoutY: 20
            spacing: 15
            nodeHPos : HPos.RIGHT
            content: [usuarioLinha, senhaLinha, loginButton ]
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
};

var cena:Scene = login;

var btVoltar:Button = Button {
    text: "Voltar"
    action: function() {
        cena = login;
    }
};

var leitura:Scene = Scene {
  content: [ VBox { 
    spacing: 10
    content: [ Label { text: "teste" }, btVoltar ] }
  ]
};

Stage {
    title: "Avaliação Docente"
    width: 550
    height: 400
    scene: bind cena
}