package jfx4;

import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jfx4.Main.Aluno;

def aluno = Aluno {
    nome : "Fulano"
    nota : 5.8
}

Stage {
    title: "Application title"
    scene: Scene {
        fill: if (aluno.nota >= 7) Color.BLUE else Color.RED
        content: Text {
            x: 10, y: 20
            content: "Nome: {aluno.nome} ({aluno.nota})"
        }
    }
}

class Aluno {
    var nome:String = "Não fornecido";
    var nota:Number = 0.0;
}



