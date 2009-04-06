package g4;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextOrigin;
import javafx.stage.Stage;

var borda = Rectangle {
    width: 320 height: 45
    fill : LinearGradient {
        endX: 0.0
        endY: 1.0
        stops: [
            Stop { color: Color.web("0xAEBBCC") },
            Stop { color: Color.web("0x6D84A3") offset: 1.0 } ]
    }
    onMouseMoved: function(e: MouseEvent): Void {
      corCorrente = Color.BLACK;
    }
    onMouseExited: function(e: MouseEvent): Void {
        corCorrente = Color.WHITE;
    }
};

var corCorrente = Color.WHITE;

var texto = Text {
  translateX: 65
  translateY: 12
  textOrigin: TextOrigin.TOP
  fill: bind corCorrente
  content: "Meu primeiro menu"
  font: Font.font("SansSerif", FontWeight.BOLD, 20)
};

Stage {
    title: "Apenas barra de menus"
    scene: Scene { content: [ borda, texto ] }
}